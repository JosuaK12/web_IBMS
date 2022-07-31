package com.IBFS.AdminIBFS.modelo.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.IBFS.AdminIBFS.modelo.dao.RegistroDao;
import com.IBFS.AdminIBFS.modelo.entidades.Registro;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class RegistroDaoImpl extends Conector implements RegistroDao {

	@Override
	public HashMap<String, Object> insertarRegistro(Registro nuevoRegistro) {
		// TODO Auto-generated method stub
		HashMap<String, Object> result = new HashMap<>();
		try {
			HttpResponse<String> response = Unirest.post(resturl+"/registro/post")
					.header("Content-Type", "application/json")
					.body("{\n\t\"id\": \"" + nuevoRegistro.getId() + "\",\n\t\"user_id\": \""
							+ nuevoRegistro.getUser_id() + "\",\n\t\"user\": \"" + nuevoRegistro.getUser()
							+ "\",\n\t\"eventos_id\": \"" + nuevoRegistro.getEventos_id() + "\",\n\t\"eventos\": \""
							+ nuevoRegistro.getEventos() + "\",\n\t\"reg_fechaRegistro\": \""
							+ nuevoRegistro.getReg_fechaRegistro() + "\",\n\t\"" + nuevoRegistro.getReg_asistencia()
							+ "\": false\n}")
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
	public void actualizarRegistro(Registro actualizarRegistro) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrarRegistro(Registro borrarRegistro) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Registro> listarRegistro() {
		// TODO Auto-generated method stub
		List<Registro> registro = new ArrayList<>();
		try {
			HttpResponse<String> response = Unirest.get(resturl + "/registro/get")
					.header("Content-Type", "application/json").asString();
			JSONArray array = new JSONArray(response.getBody());
			for (int i = 0; i < array.length(); i++) {
				JSONObject object = array.getJSONObject(i);
				Registro reg = new Registro();
				reg.setId(object.getInt("id"));
				reg.setReg_fechaRegistro(object.getString("reg_fechaRegistro"));
				reg.setReg_asistencia(object.getBoolean("reg_asistencia"));
				reg.setUser_id(object.getInt("user_id"));
				reg.setUser(object.getString("user"));
				reg.setEventos_id(object.getInt("eventos_id"));
				reg.setEventos(object.getString("eventos"));
				registro.add(reg);
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return registro;
	}

}
