package edu.eci.cvds.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import edu.eci.cvds.entities.abstractEntities.*;
import edu.eci.cvds.concrete.concreteEntities.*;


public class serviciosLab implements servicios{
	@Inject
	private UsuarioDAO usuario;
	@Inject
	private EquipoDAO equipo;
	@Inject
	private LaboratorioDAO laboratorio;
	@Inject
	private NovedadDAO novedad;
	@Inject
	private ElementoEquipoDAO elemento;
	
	public serviciosLab(){
		
	}
	public void insertarEquipoSinLaboratorio(int id,Date fechaInicioActividad,Date fechafinactividad,Date fechaAdquisicion) throws ECILabException {
		if(fechaInicioActividad==null || fechaAdquisicion==null) throw new ECILabException("Error: La fecha de adquisicion o la fecha de fin de actividad no pueden ser vacias o nulas.");
		if(fechaInicioActividad.before(fechaAdquisicion)) throw new ECILabException("Error: Un equipo no puede iniciar actividad antes de su adquisicion.");
		equipo.insertarEquipoSinLaboratorio(id, fechaInicioActividad, fechafinactividad, fechaAdquisicion);
	}	
	public void insertarEquipoSinLaboratorio(int id,Date fechaInicioActividad,Date fechafinactividad,Date fechaAdquisicion,ArrayList<Elemento> elementos) throws ECILabException{	
		if(elementos==null) throw new ECILabException("Error: Deben existir elementos");
		if(elementos.size()!=4) throw new ECILabException("Error: Por favor, verifique el numero de los elementos.");
		if(!hayUnElementoDeCadaCategoria(elementos)) throw new ECILabException("Error: Por favor, verifique los elementos ya que hay categorias repetidas.");
		if(!elementosLibres(elementos)) throw new ECILabException("Error: Algunos elementos ya se encuentran vinculados a otro equipo.");
		insertarEquipoSinLaboratorio(id,fechaInicioActividad,fechafinactividad,fechaAdquisicion);
		for(Elemento e:elementos) {
			this.asociarElemento(e.getId(), id);
			this.AgregarNovedad("Se asocio el elemento "+String.valueOf(e.getId())+" al equipo "+String.valueOf(id), "Elemento necesario para registrar el equipo", id, e.getId(), this.getUsuario(SecurityUtils.getSubject().getPrincipal().toString()).getId());
		}		
	}	
	private boolean elementosLibres(ArrayList<Elemento> elementos) {	
		for(Elemento e:elementos) {
			if(this.equipoPoseElemento(e.getId())) return false;
		}
		return true;
	}	
	private boolean hayUnElementoDeCadaCategoria(ArrayList<Elemento> elementos) {	
		String[] categoria = new String[] {"TORRE","MOUSE","TECLADO","PANTALLA"};
		for(String c:categoria) {
			if(!existeElementoConCategoria(elementos,c)) return false;
		}
		return true;
	}	
	
	
	public Elemento getElemento(int id) {
		return elemento.getElemento(id);
	}	
	public List<Elemento> getElementos(){
		return elemento.consultarElementos();
	}	
	
	public void AgregarElemento(String categoria, String fabricante, String referencia, Date fechaAdquisicion, Date fechaInicioActividad, Date fechaFinActivida) throws ECILabException {
		elemento.AgregarElemento(categoria, fabricante, referencia, fechaAdquisicion, fechaInicioActividad, fechaFinActivida);
	}	
	
	public void AgregarNovedad(String descripcion,String justificacion,int idEquipo,int idElemento,int usuario) throws ECILabException {
		if(equipo.getEquipo(idEquipo)==null) throw new ECILabException("Error: No existe el equipo.");
		if(elemento.getElemento(idElemento)==null) throw new ECILabException("Error: No existe el Elemento.");
		if(!equipoPosee(equipo.getEquipo(idEquipo),idElemento)) throw new ECILabException("Error: El equipo y el elemento no se encuentran vinculados.");
		novedad.agregarNovedad(descripcion, justificacion, idEquipo, idElemento,usuario);
	}	
	private boolean equipoPosee(Equipo equipo2, int idElemento) {
		for(Elemento e:equipo2.getElementos()) {
			if(e.getId()==idElemento) return true;
		}
		return false;
	}
	@Override
	
	public Novedad getNovedad(int id) throws ECILabException  {
		return novedad.getNovedad(id);
	}	
	@Override
	public int getUltimaNovedad() {
		return novedad.getUltimaNovedad();
	}	
	private boolean existeElementoConCategoria(ArrayList<Elemento> elementos, String categoria) {	
		for(Elemento e:elementos) {
			if(e.getCategoria().equals(categoria)) return true;
		}
		return false;
	}	
	
	public Equipo getEquipo(int id) {
		return equipo.getEquipo(id);
	}	
	@Override
	
	public void asociarElemento(int idElemento, int IdEquipoN,int usuario) throws ECILabException {
		Elemento e = getElemento(idElemento);
		if(e==null) throw new ECILabException("Error: No existe el elemento por vincular.");
		if(elementoAsociadoaEquipo(idElemento)) throw new ECILabException("Error: Este elemento ya se encuentra vinculado a otro equipo.");
		if(e.getFechaFinActividad()!=null) throw new ECILabException("Error: El elemento a sido dado de baja y este no puede ser vinculado a ningun equipo.");
		if(equipo.getEquipo(IdEquipoN)==null) throw new ECILabException("Error: No existe este equipo.");
		elemento.desvincularElementos(e.getCategoria(),equipo.getEquipo(IdEquipoN).getId());
		equipo.asociarElemento(idElemento, IdEquipoN);
		novedad.agregarNovedad("Asociacion elemento "+String.valueOf(idElemento),"completar equipo "+String.valueOf(IdEquipoN), IdEquipoN, idElemento,usuario);
	}	
	
	public void asociarElemento(int idElemento, int IdEquipoN) throws ECILabException {
		Elemento e = getElemento(idElemento);
		if(e==null) throw new ECILabException("Error: No existe el elemento por vincular.");
		if(elementoAsociadoaEquipo(idElemento)) throw new ECILabException("Error: Este elemento ya se encuentra vinculado a otro equipo.");
		if(e.getFechaFinActividad()!=null) throw new ECILabException("Error: El elemento a sido dado de baja y este no puede ser vinculado a ningun equipo.");
		Equipo eq =equipo.getEquipo(IdEquipoN); 
		if(eq==null) throw new ECILabException("Error: No existe este equipo.");
		if(eq.getFechaFinActividad()!=null) throw new ECILabException("Error: El equipo fue dado de baja y no se le pueden asociar elementos.");
		elemento.desvincularElementos(e.getCategoria(),equipo.getEquipo(IdEquipoN).getId());
		equipo.asociarElemento(idElemento, IdEquipoN);
	}	
	
	public void asociarEquipo(int idEquipo, int IdLaboratorioN) throws ECILabException {
		Equipo e = getEquipo(idEquipo);
		if(e==null) throw new ECILabException("Error: No existe el equipo por vincular.");
		if(e.getFechaFinActividad()!=null) throw new ECILabException("Error: El equipo a sido dado de baja y este no puede ser vinculado a ningun laboratorio.");
		if(laboratorio.getLaboratorio(IdLaboratorioN) == null) throw new ECILabException("Error: No existe este laboratorio.");
		equipo.desvincularEquipo(idEquipo);
		laboratorio.asociarEquipo(idEquipo,IdLaboratorioN);
	}
	@Override
	public ArrayList<Equipo> getEquipos() {
		return equipo.getEquipos();
	}	
	@Override
	public List<Laboratorio> getLaboratorios() {
		return laboratorio.getLaboratorios();
	}	
	@Override
	public void registrarUsuario(int carnet, String nombre, String apellido, String correo, String rol, String contra) {
		usuario.registrarUsuario(carnet,nombre,apellido,correo,rol,contra);
	}	
	@Override
	public boolean equipoPoseElemento(int elemento) {
		return equipo.equipoPoseElemento(elemento);
	}	
	@Override
	public void darBajaElemento(int elemento,int usuario) throws ECILabException {
		Elemento elm = this.elemento.getElemento(elemento);
		if(elm==null) throw new ECILabException("Error: El elememento debe existir para poder eliminarlo.");
		if(equipoPoseElemento(elemento)) throw new ECILabException("Error: Este equipo no debe estar asociado a algun equipo.");
		if(elm.getFechaFinActividad()!=null)  throw new ECILabException("Error: Este elemento ya fue dado de baja.");
		
		this.elemento.darBaja(elemento);
		registrarNovedadSinEquipo("Dar de baja","Tiempo o daño",elemento,usuario);
		
	}	
	
	public boolean elementoAsociadoaEquipo(int elemento) {
		return this.elemento.elementoAsociadoaEquipo(elemento);
	}
	@Override
	public void asociarEquipo(int idEquipo, int IdLaboratorioN,int usuario) throws ECILabException {
		Equipo e = getEquipo(idEquipo);
		if(e==null) throw new ECILabException("Error: No existe el equipo por vincular.");
		if(e.getFechaFinActividad()!=null) throw new ECILabException("Error: El equipo a sido dado de baja y este no puede ser vinculado a ningun laboratorio.");
		Laboratorio l = laboratorio.getLaboratorio(IdLaboratorioN); 
		if(l==null) throw new ECILabException("Error: No existe este laboratorio.");
		if(l.getCapacidad()<=l.getEquipos().size()) throw new ECILabException("Error: El laboratorio actualmente esta lleno.");
		if(l.getFechaCierre()!=null) throw new ECILabException("Error: No se pueden asociar equipos a un laboratorio que se encuentra cerrado.");
		equipo.desvincularEquipo(idEquipo);
		laboratorio.asociarEquipo(idEquipo,IdLaboratorioN);
	}	
	@Override
	public void darBajaConEquipoAsociado(Elemento elemento, Equipo eq) {
		this.elemento.darBaja(elemento.getId());
		this.elemento.desvincularElementos(elemento.getCategoria(), eq.getId());
		registrarNovedadSinEquipo("Dar de baja","Tiempo o daño",elemento.getId(),getUsuario(SecurityUtils.getSubject().getPrincipal().toString()).getId());
	}	
	@Override
	public void registrarNovedadSinEquipo(String descripcion,String justificacion,int elemento,int usuario){
		novedad.registrarNovedadSinEquipo(descripcion,justificacion,elemento,usuario);
	}	
	@Override
	public void darBajaEquipo(int equipo,int usuario) throws ECILabException {
		Equipo equi = this.equipo.getEquipo(equipo);
		if(equi==null) throw new ECILabException("Error: El equipo debe existir para poder eliminarlo.");
		if(equi.getFechaFinActividad()!=null)  throw new ECILabException("Error: Este equipo ya fue dado de baja.");
		if(equi.getElementos().size() != 0) throw new ECILabException("Error: Debe desasociar o dar de baja todos los elementos.");
		laboratorio.desasociarEquipo(equipo);
		this.equipo.darBaja(equipo);		
	}
	@Override
	public void desvincularElemento(Elemento e,Equipo eq){
		elemento.desvincularElementos(e.getCategoria(),eq.getId());
	}
	@Override
	public ArrayList<Novedad> getNovedades() {
		return novedad.getNovedades();
	}	
	public ArrayList<Elemento> getElementos(String categoria) {
		return elemento.getElemento(categoria);
	}	
	@Override
	public void agregarLaboratorio(int id, String nombre, int capacidad, Date fechacierre,Date fechaapertura) throws ECILabException{
		if(capacidad<=0) throw new ECILabException("Error: La capacidad del laboratorio no puede ser negativa o cero.");
		laboratorio.agregarLaboratorio(id, nombre, capacidad, fechacierre,fechaapertura);
	}	
	public boolean equipoAsociadoaLaboratorio(int equipo) {
		return this.equipo.equipoAsociadoaLaboratorio(equipo);
	}
	public ArrayList<Elemento> getElementosActivos() {
		return elemento.getElementosActivos();
	}
	public Laboratorio getLaboratorio(int laboratorio) {
		return this.laboratorio.getLaboratorio(laboratorio);
	}
	@Override
	public void cerrarLaboratorio(int laboratorio) throws ECILabException {
		Laboratorio l = this.laboratorio.getLaboratorio(laboratorio);
		if(l==null) throw new ECILabException("Error: No existe este laboratorio.");
		if(l.getFechaCierre()!=null) throw new ECILabException("Error: El laboratorio ya se encuentra cerrado.");
		for(Equipo e:l.getEquipos()) {
			this.laboratorio.desasociarEquipo(e.getId());
		}
		this.laboratorio.cerrarLaboratorio(laboratorio);		
	}
	public ArrayList<Equipo> getAllEquipos() {
		return equipo.getAllEquipos();
	}
	public ArrayList<Novedad> novedadesEquipo(int equipo) {
		return novedad.novedadesEquipo(equipo);
	}
	public ArrayList<Novedad> getNovedadesElemento(int elemento) {
		return novedad.getNovedadesElemento(elemento);
	}	
	public ArrayList<Equipo> getEquiposinLab(){
		return equipo.getEquiposinLab();
	}
	
	public ArrayList<Novedad> getNovedades(int elemento, int equipo) {
		return novedad.getNovedades(elemento,equipo);
	}
	public void agregarNovedadSinElemento(String razon, String justificacion, int equipo, int usuario) {
		novedad.agregarNovedadSinElemento(razon,justificacion,equipo,usuario);		
	}	
	@Override
	public List<Laboratorio> getTodosLaboratorios(){
		return laboratorio.getTodosLaboratorios();
	}	
	@Override
	public int cantidadEquipo( int laboratorio) {
		return this.laboratorio.cantidadEquipo(laboratorio);
	}	
	@Override
	public ArrayList<Novedad> getNovedadesLabEqui(int labo){
		return novedad.getNovedadesLabEqui(labo);
	}	
	@Override
	public int ElementosLaboratorio(int laboratorio) {
		return this.laboratorio.ElementosLaboratorio(laboratorio);
	}	
	@Override
	public int equiposLaboratorios(String mes) {
		return this.laboratorio.equiposLaboratorios(mes);
	}
	public Laboratorio getLaboratorioEquipo(int idEquipo) {
		return laboratorio.getLaboratorioEquipo(idEquipo);
	}
}
	