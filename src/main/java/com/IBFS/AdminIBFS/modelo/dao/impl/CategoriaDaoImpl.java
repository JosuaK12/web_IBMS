package com.IBFS.AdminIBFS.modelo.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.IBFS.AdminIBFS.modelo.dao.CategoriaDao;
import com.IBFS.AdminIBFS.modelo.entidades.Categoria;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class CategoriaDaoImpl extends Conector implements CategoriaDao {

	@Override
	public HashMap<String, Object> insertarCategoria(Categoria nuevoCategoria) {
		// TODO Auto-generated method stub
		HashMap<String, Object> result = new HashMap<>();
		try {
			HttpResponse<String> response = Unirest.post(resturl + "/categoria/post")
				.header("Content-Type", "application/json")
				.body("{\n\t\"cat_nombre\":\n\t\t\""+nuevoCategoria.getCat_nombre()+"\",\n\t\"cat_descripcion\":\n\t\t\""+nuevoCategoria.getCat_descripcion()+"\"\n}")
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
	public void actualizarCategoria(Categoria actualizarCategoria) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrarCategoria(Categoria borrarCategoria) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Categoria> listarCategoria() {
		// TODO Auto-generated method stub
		List<Categoria> categoria = new ArrayList<>();
		try {
			HttpResponse<String> response = Unirest.get(resturl + "/categoria/get")
					.header("Content-Type", "application/json").asString();
			JSONArray array = new JSONArray(response.getBody());
			for (int i = 0; i < array.length(); i++) {
				JSONObject object = array.getJSONObject(i);
				Categoria cat = new Categoria();
				cat.setId(object.getInt("id"));
				cat.setCat_nombre(object.getString("cat_nombre"));
				cat.setCat_descripcion(object.getString("cat_descripcion"));
				categoria.add(cat);
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return categoria;
	}

	@Override
	public List<Categoria> buscarCategoriaPorNombre(String cat_nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
