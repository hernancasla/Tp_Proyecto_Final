package utn.frba.proyecto.controllers;

import static spark.Spark.after;
import static spark.Spark.before;
import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.halt;
import static spark.Spark.post;
import static utn.frba.proyecto.utils.JSONUtils.json;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import utn.frba.proyecto.entities.Marcas;
import utn.frba.proyecto.entities.Publicidades;
import utn.frba.proyecto.entities.Usuarios;
import utn.frba.proyecto.repositorios.RepositorioMarcas;
import utn.frba.proyecto.services.PublicidadService;
import utn.frba.proyecto.utils.AuthenticationUtil;
import utn.frba.proyecto.utils.ResponseError;

public class PublicidadController {

	private static final String rutaDeImagenes = "C:/Users/LaTota/workspace6/tota-server-master/tota-server/src/main/resources/public/img";
	
	public PublicidadController(final PublicidadService publicidadService) {

		HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();

		get("/publicidades", (request, response) -> {
			List<Publicidades> publicidades = publicidadService.getPublicidades();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("usuario", AuthenticationUtil.getAuthenticatedUser(request));
			map.put("publicidades", publicidades);
			return new ModelAndView(map, "publicidades.hbs");

		}, engine);
		
		before("/publicidades", (request, response) -> {
			Usuarios user = AuthenticationUtil.getAuthenticatedUser(request);
			if (user == null) {
				response.redirect("/");
				halt();
			}
		});
		
		get("/publicidades/:pub_id", (request, response) -> {
			int pub_id = Integer.parseInt(request.params(":pub_id"));
			Publicidades publicidad = publicidadService.getPublicidad(pub_id);
			if (publicidad != null) {
				return publicidad;
			}
			response.status(400);
			return new ResponseError("No hay publicidad con id '%s'", String.valueOf(pub_id));
		}, json());

		delete("/publicidades/:pub_id", (req, res) -> {
			int pub_id = Integer.parseInt(req.params(":pub_id"));
			Publicidades publicidad = publicidadService.getPublicidad(pub_id);

			if (publicidad != null) {
				publicidadService.eliminarPublicidad(publicidad);
				return publicidadService.getPublicidades();
			} else {
				res.status(400);
				return "No hay publicidades con Id " + pub_id;
			}
		}, json());
		
		post("/publicidades", (request, response) -> {
			String sexo = request.queryParams("sexo");
			int emin = Integer.parseInt(request.queryParams("edad_min"));
			int emax = Integer.parseInt(request.queryParams("edad_max"));
			int hrmin = Integer.parseInt(request.queryParams("horario_min"));
			int hrmax = Integer.parseInt(request.queryParams("horario_max"));
			String descripcion = request.queryParams("descripcion");
			
			String cantPublicidades = String.valueOf(publicidadService.getPublicidades().size() + 1);
			String ruta = "../img/";
			String extension = ".png";
			String nombreFinal = cantPublicidades + extension;
			
			File fichero1 = new File(rutaDeImagenes, descripcion);
			File fichero2 = new File(rutaDeImagenes, nombreFinal);
			fichero1.renameTo(fichero2);
			
			// Marca marca = RepositorioMarcas.getInstance().getBrandById(1L);
			publicidadService.crearPublicidad(sexo, emin, emax, hrmin, hrmax, nombreFinal);
			return publicidadService.getPublicidades();
		}, json());
		
		after("/publicidades/*", (request, response) -> {
			response.type("application/json");
		});
	}
}