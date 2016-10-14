package utn.frba.proyecto.repositorios;

import java.util.List;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import utn.frba.proyecto.entities.Publicidades;

public class RepositorioPublicidades implements WithGlobalEntityManager, TransactionalOps {

	private static RepositorioPublicidades instance = new RepositorioPublicidades();

	public static RepositorioPublicidades getInstance() {
		return instance;
	}

	public List<Publicidades> getPublicidades() {
		return entityManager().createQuery("from Publicidades", Publicidades.class).getResultList();
	}
	
	public void addPublicidad(Publicidades publicidad) {
		withTransaction(() -> {
			entityManager().persist(publicidad);
		});

	}

	public void modificarPublicidad(Publicidades publicidad) {
		withTransaction(() -> {
			entityManager().persist(publicidad);
		});
	}

	public void quitarPublicidad(Publicidades publicidad) {
		withTransaction(() -> {
			entityManager().remove(publicidad);
		});
	}

	public Publicidades getPublicidadById(int id) {
		return entityManager().find(Publicidades.class, id);
	}

}