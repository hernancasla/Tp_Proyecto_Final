package utn.frba.proyecto.services;

import java.util.List;

import utn.frba.proyecto.entities.Publicidades;
import utn.frba.proyecto.repositorios.RepositorioPublicidades;

public class PublicidadService {

	public List<Publicidades> getPublicidades() {
		return RepositorioPublicidades.getInstance().getPublicidades();
	}

	public Publicidades getPublicidad(int id) {
		return RepositorioPublicidades.getInstance().getPublicidadById(id);
	}

	public Publicidades crearPublicidad(String sexo, int emin, int emax, int hrmin, int hrmax, String desc) {
		Publicidades publicidad = new Publicidades(sexo, emin, emax, hrmin, hrmax, desc);
		RepositorioPublicidades.getInstance().addPublicidad(publicidad);
		return publicidad;
	}

	public Publicidades modificarPublicidad(int id, String sexo, int emin, int emax, int hrmin, int hrmax, String desc) {
		Publicidades publicidad = RepositorioPublicidades.getInstance().getPublicidadById(id);
		publicidad.setSexo(sexo);
		publicidad.setEdad_min(emin);
		publicidad.setEdad_max(emax);
		publicidad.setHorario_min(hrmin);
		publicidad.setHorario_max(hrmax);
		publicidad.setDescripcion(desc);
		RepositorioPublicidades.getInstance().modificarPublicidad(publicidad);
		return publicidad;
	}
	
	public void eliminarPublicidad(Publicidades publicidad) {
		RepositorioPublicidades.getInstance().quitarPublicidad(publicidad);
	}

}