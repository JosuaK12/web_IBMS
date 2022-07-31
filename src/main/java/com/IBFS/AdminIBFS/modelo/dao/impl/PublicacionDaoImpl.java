package com.IBFS.AdminIBFS.modelo.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.IBFS.AdminIBFS.modelo.dao.PublicacionDao;
import com.IBFS.AdminIBFS.modelo.entidades.Publicacion;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class PublicacionDaoImpl extends Conector implements PublicacionDao {

	@Override
	public HashMap<String, Object> insertarPublicacion(
			com.IBFS.AdminIBFS.modelo.entidades.Publicacion nuevoPublicacion) {
		// TODO Auto-generated method stub
		HashMap<String, Object> result = new HashMap<>();
		try {
			HttpResponse<String> response = Unirest.post("http://127.0.0.1:8000/publicacion/post")
					.header("Content-Type", "application/json")
					.body("{\n\t\"categoria_id\":\n\t\t" + nuevoPublicacion.getCategoria_id()
							+ ",\n\t\"pub_titulo\":\n\t\t\"" + nuevoPublicacion.getPub_titulo()
							+"\",\n\t\"pub_contenido\":\n\t\t\"" + nuevoPublicacion.getPub_contenido()
							+"\",\n\t\"user_id\":\n\t\t"+nuevoPublicacion.getUser_id()+"\n}")
					.asString();
			result.put("status", response.getStatus());
			result.put("data", response.getBody());
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			result.put("status", 500);
			result.put("data", e.getMessage());
		}
		return result;
	}

	@Override
	public void actualizarPublicacion(com.IBFS.AdminIBFS.modelo.entidades.Publicacion actualizarPublicacion) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrarPublicacion(com.IBFS.AdminIBFS.modelo.entidades.Publicacion borrarPublicacion) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<com.IBFS.AdminIBFS.modelo.entidades.Publicacion> listarPublicacion() {
		// TODO Auto-generated method stub
		List<Publicacion> publicacion = new ArrayList<>();
		try {
			HttpResponse<String> response = Unirest.get(resturl + "/publicacion/get")
					.header("Content-Type", "application/json").asString();
			JSONArray array = new JSONArray(response.getBody());
			for (int i = 0; i < array.length(); i++) {
				JSONObject object = array.getJSONObject(i);
				Publicacion pub = new Publicacion();
				pub.setId(object.getInt("id"));
				pub.setPub_titulo(object.getString("pub_titulo"));
				pub.setPub_contenido(object.getString("pub_contenido"));
				pub.setPub_fechaPublic(object.getString("pub_fechaPublic"));
				pub.setCategoria_id(object.getInt("categoria_id"));
				pub.setCategoria(object.getString("categoria"));
				pub.setUser_id(object.getInt("user_id"));
				pub.setUser(object.getString("user"));
				publicacion.add(pub);
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return publicacion;
	}

	@Override
	public List<com.IBFS.AdminIBFS.modelo.entidades.Publicacion> buscarPublicacionPorTitulo(String pub_titulo) {
		// TODO Auto-generated method stub
		return null;
	}

}
