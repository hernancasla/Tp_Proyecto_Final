package utn.frba.proyecto.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;
import utn.frba.proyecto.entities.Usuarios;
import utn.frba.proyecto.repositorios.RepositorioUsuarios;
import static spark.Spark.*;

public class TestAplication {
	
    private static String nombreCazador;

	public static void main(String[] args) {
    	/*
		List <Cazador> cazadores = RepositorioCazadores.getInstance().getAllCazadores();
    	Cazador unCazador = cazadores.get(0);
    	List <Jugador> jugadores = unCazador.getJugadores();
    	for(Jugador unJugador: jugadores){
    		System.out.println(unJugador.toString());
    	}
		*/
		
    	// Imprimir el nombre del CAZADOR del animal GATO
    	/*
		List <Cazador> cazadores = RepositorioCazadores.getInstance().getAllCazadores();
    	for(Cazador unCazador: cazadores){
    		List <Animal> animales = unCazador.getAnimales();
    		for(Animal unAnimal: animales){
    			if(unAnimal.getNombre().equals("gato")){
    				nombreCazador = unCazador.getNombre();
    			}
    		}
    	}
		System.out.println("El cazador del gato es: " + nombreCazador);
    	*/
		
    	/*
    	List <Cazador> cazadores = RepositorioCazadores.getInstance().getAllCazadores();
    	Cazador unCazador = cazadores.get(0);
    	List <Jugador> jugadores = unCazador.getJugadores();
    	for(Jugador unJugador: jugadores){
    		String nombre = unJugador.getNombre();
    		String edad = unJugador.getEdad();
    		System.out.println(nombre + " - " + edad);
    	}
    	*/
    	
    	/*
    	String datosJugador = unCazador.toString();
    	System.out.println(datosJugador);
    	*/
    	
    	/*
    	List <Jugador> jugadores = RepositorioJugadores.getInstance().getAllJugadores();
    	Jugador unJugador = jugadores.get(0);
    	String datosJugador = unJugador.toString();
    	System.out.println(datosJugador);
    	*/
    	
    	/*
    	List <Animal> animales = RepositorioAnimales.getInstance().getAllAnimales();
    	Animal unAnimal = animales.get(0);
    	String datosAnimal = unAnimal.toString();
    	System.out.println(datosAnimal);
    	*/
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
        
    	// En la URL /hello imprimimos la leyenda "Hello World".
        // get("/hello", (request, response) -> "Hello World!");
        
    	// List <Jugador> jugadores = RepositorioJugadores.getInstance().getAllJugadores();
    	
    	/* Ej: 1) Mostrar el jugador primer jugador de la base de datos.
    	// -------------------------------------------------------------
    	Jugador unJugador = jugadores.get(0);
    	String datosJugador = unJugador.toString();
    	*/
    	
    	/* Ej: 2) Mostrar el jugador mas viejo de la base de datos.
    	// --------------------------------------------------------
    	Object jugadorMasViejo = null;
    	int maxEdad = 0;
    	for(Jugador unJugador: jugadores){
    		if(Integer.parseInt(unJugador.getEdad()) >= maxEdad){
    		   maxEdad = Integer.parseInt(unJugador.getEdad());
    		   jugadorMasViejo = unJugador;
    		}
    	}
		
		String datosJugador = jugadorMasViejo.toString();
    	*/
    	
    	/*
    	List <Jugador> jugadores = RepositorioJugadores.getInstance().getAllJugadores();
    	
    	Object jugadorMasViejo = null;
    	int maxEdad = 0;
    	for(Jugador unJugador: jugadores){
    		if(Integer.parseInt(unJugador.getEdad()) >= maxEdad){
    		   maxEdad = Integer.parseInt(unJugador.getEdad());
    		   jugadorMasViejo = unJugador;
    		}
    	}
		
		String datosJugador = jugadorMasViejo.toString();
        Map map = new HashMap();
        map.put("informacionJugador", datosJugador);
        get("/hello", (req, res) -> new ModelAndView(map, "info.hbs"), new HandlebarsTemplateEngine());
        */
    	
    }
}