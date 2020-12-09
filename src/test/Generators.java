import org.quicktheories.generators.Generate;
import org.quicktheories.core.Gen;
import static org.quicktheories.generators.SourceDSL.strings;


public class Generators {
	static private int nextUserID = 0;
	Generator  correo=new Generator(()-> {
		return radomString(10) "@" randomString(6)  "." randomString(3);
	});
	}
	static public Gen<Usuario> user() {
		return palabra(10,20).zip(strings().basicLatinAlphabet().ofLengthBetween(10, 50),
						(name, lastName) -> {
							nextUserID++;
							return new Usuario("user"+nextUserID,nombre,apellido,correo);	
						});
	}
	public static Gen<String> palabra(int min, int max){
		return strings().basicLatinAlphabet().ofLengthBetween(min, max);
	}
	public static Gen<TipoElemento> tipoElemento(){
		return Generate.enumValues(TipoElemento.class);
	}
	public static  Gen<Elemento> mouse(){
		return palabra(5,10).zip(palabras(5,10), (nombre,descripcion)-> new Elemento(TipoElemento.mouse, nombre,descripcion));
	}
	public static  Gen<Elemento> teclado(){
		return palabra(5,10).zip(palabras(5,10), (nombre,descripcion)-> new Elemento(TipoElemento.teclado, nombre,descripcion));
	}
	public static  Gen<Elemento> torre(){
		return palabra(5,10).zip(palabras(5,10), (nombre,descripcion)-> new Elemento(TipoElemento.torre, nombre,descripcion));	
	}
	public static  Gen<Elemento> pantalla(){
		return palabra(5,10).zip(palabras(5,10), (nombre,descripcion)-> new Elemento(Tipo.pantalla, nombre,descripcion));
	}
	public static  Gen<Elemento> elemento(){
		return palabra(5,10).zip(palabras(5,10), (nombre,descripcion)-> new Elemento(tipoElemento().generate(source), nombre,descripcion));
		
	}
	public static  Gen<Equipo> equipo(){
		return palabra(5,10).map((laboratorio)-> 
		new Equipo(null)).zip(torre(),mouse(),teclado(),pantalla(), (equip, torre,mouse,teclado,pantalla)->
		{
			equip.setTorre(torre);
			equip.setMouse(mouse);
			equip.setPantalla(pantalla);
			equip.setTeclado(teclado);
			return equip;
		});
	}
	public static  Gen<Novedad> novedadEquipo(){
		return source ->{
			String equipo =equipo();
			Date fecha= Generate.longRange(0,50).map(1 ->new Date(1));
			String descripcion =palabra(10,20);
			return new Novedad(equipo,null,descripcion,detalle):
			
		};
	}
	public static  Gen<Novedad> novedadElemento(){
		return source ->{
			String equipo =equipo();
			String elemento= elemento();
			Date fecha= Generate.longRange(0,50).map(1 ->new Date(1));
			String descripcion =palabra(10,20);
			return new Novedad(equipo,elemento,descripcion,fecha):
			
		};
	}
	
	
	
	
	
}
 