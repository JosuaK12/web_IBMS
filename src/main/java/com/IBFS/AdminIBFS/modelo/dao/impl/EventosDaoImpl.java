package com.IBFS.AdminIBFS.modelo.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.IBFS.AdminIBFS.modelo.dao.EventosDao;
import com.IBFS.AdminIBFS.modelo.entidades.Eventos;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class EventosDaoImpl extends Conector implements EventosDao {

	@Override
	public HashMap<String, Object> insertarEventos(Eventos nuevoEventos) {
		// TODO Auto-generated method stub
		HashMap<String, Object> result = new HashMap<>();
		try {
			HttpResponse<String> response = Unirest.post( resturl+"/eventos/post")
					.header("Content-Type", "application/json")
					.body("{\n\t\"eve_nombre\":\n\t\t\"" + nuevoEventos.getEve_nombre() + "\",\n\t\"eve_info\":\n\t\t\""
							+ nuevoEventos.getEve_info() + "\",\n\t\"eve_fecha\":\n\t\t\"" + nuevoEventos.getEve_fecha()
							+ "\",\n\t\"eve_horaInicio\":\n\t\t\""+nuevoEventos.getEve_horaInicio()+"\",\n\t\"eve_horaFinal\":\n\t\t\""+nuevoEventos.getEve_horaFinal()+"\"\n}")
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
	public void actualizarEventos(Eventos actualizarEventos) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrarEventos(Eventos borrarEventos) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Eventos> listarEventos() {
		// TODO Auto-generated method stub
		List<Eventos> eventos = new ArrayList<>();
		try {
			HttpResponse<String> response = Unirest.get(resturl + "/eventos/get")
					.header("Content-Type", "application/json").asString();
			JSONArray array = new JSONArray(response.getBody());
			for (int i = 0; i < array.length(); i++) {
				JSONObject object = array.getJSONObject(i);
				Eventos eve = new Eventos();
				eve.setId(object.getInt("id"));
				eve.setEve_nombre(object.getString("eve_nombre"));
				eve.setEve_info(object.getString("eve_info"));
				eve.setEve_fecha(object.getString("eve_fecha"));
				eve.setEve_horaInicio(object.getString("eve_horaInicio"));
				eve.setEve_horaFinal(object.getString("eve_horaFinal"));
				eventos.add(eve);
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return eventos;
	}

	@Override
	public List<Eventos> buscarEventosPorNombre(String eve_nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
