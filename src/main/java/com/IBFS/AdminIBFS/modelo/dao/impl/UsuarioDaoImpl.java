package com.IBFS.AdminIBFS.modelo.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.IBFS.AdminIBFS.modelo.dao.UsuarioDao;
import com.IBFS.AdminIBFS.modelo.entidades.Usuario;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class UsuarioDaoImpl extends Conector implements UsuarioDao {

	@Override
	public HashMap<String, Object> insertarUsuario(Usuario nuevoUsuario) {
		// TODO Auto-generated method stub
		HashMap<String, Object> result = new HashMap<>();
		try {
			HttpResponse<String> response = Unirest.post(resturl + "/user/post")
					.header("Content-Type", "application/json")
					.body("{\n\t\"first_name\": \"" + nuevoUsuario.getFirst_name() + "\",\"last_name\": \""
							+ nuevoUsuario.getLast_name() + "\",\t\"username\": \"" + nuevoUsuario.getUsername()
							+ "\",\t\"email\": \"" + nuevoUsuario.getEmail() + "\",\t\"password\": \""
							+ nuevoUsuario.getPassword() + "\",\t\"rol_id\": " + nuevoUsuario.getRoles_id()
							+ ",\t\"images\": \"" + nuevoUsuario.getImage() + "\"\n}")
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
	public void actualizarUsuario(Usuario actualizarUsuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrarUsuario(Usuario borrarUsuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Usuario> listarUsuario() {
		// TODO Auto-generated method stub
		List<Usuario> usuario = new ArrayList<>();
		try {
			HttpResponse<String> response = Unirest.get(resturl + "/user/get")
					.header("Content-Type", "application/json").asString();
			JSONArray array = new JSONArray(response.getBody());
			for (int i = 0; i < array.length(); i++) {
				JSONObject object = array.getJSONObject(i);
				Usuario user = new Usuario();
				user.setId(object.getInt("user_id"));
				user.setFirst_name(object.getString("first_name"));
				user.setLast_name(object.getString("last_name"));
				user.setUsername(object.getString("username"));
				user.setEmail(object.getString("email"));
				user.setImage(object.getString("image"));
				user.setRoles_id(object.getInt("roles_id"));
				usuario.add(user);
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return usuario;
	}

	@Override
	public List<Usuario> buscarUsuarioPorCi(String cedulaUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> buscarUsuarioPorNombre(String nombreUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
