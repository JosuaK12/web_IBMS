package com.IBFS.AdminIBFS.modelo.dao.impl;

import kong.unirest.Unirest;
import org.json.JSONObject;

import org.json.JSONArray;
import kong.unirest.HttpResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.IBFS.AdminIBFS.modelo.dao.RolesDao;
import com.IBFS.AdminIBFS.modelo.entidades.Roles;

public class RolesDaoImpl extends Conector implements RolesDao {

	@Override
	public HashMap<String, Object> insertarRoles(Roles nuevoRoles) {
		// TODO Auto-generated method stub
		HashMap<String, Object> result = new HashMap<>();
		try {
			HttpResponse<String> response = Unirest.post(resturl + "/Roles/post")
					.header("Content-Type", "application/json")
					.body("{\n\t\"rol_nombre\": \n\t\t\"" + nuevoRoles.getNombreRol()
							+ "\",\n\t\"rol_descripcion\":\n\t\t\"" + nuevoRoles.getDescripcionRol() + "\"\n}")
					.asString();
			result.put("status", response.getStatus());
			result.put("data", response.getBody());
		} catch (Exception e) {
			System.err.println(e.getMessage());
			result.put("status", 500);
			result.put("data", e.getMessage());
		}
		return result;
	}

	@Override
	public void actualizarRoles(Roles actualizarRoles) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrarRoles(Roles borrarRoles) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Roles> listarRoles() {
		// TODO Auto-generated method stub
		List<Roles> roles = new ArrayList<>();
		try {
			HttpResponse<String> response = Unirest.get(resturl + "/Roles/get")
					.header("Content-Type", "application/json").asString();
			JSONArray array = new JSONArray(response.getBody());
			for (int i = 0; i < array.length(); i++) {
				JSONObject object = array.getJSONObject(i);
				Roles rol = new Roles();
				rol.setId(object.getInt("id"));
				rol.setNombreRol(object.getString("rol_nombre"));
				rol.setDescripcionRol(object.getString("rol_descripcion"));
				roles.add(rol);
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return roles;
	}

}
