package com.IBFS.AdminIBFS.modelo.dao.impl;

import java.util.HashMap;

import com.IBFS.AdminIBFS.modelo.dao.LoginDao;
import com.IBFS.AdminIBFS.modelo.entidades.Login;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class LoginDaoImpl implements LoginDao {

	@Override
	public HashMap<String, Object> inciarSesion(Login nuevoLogin) {
		// TODO Auto-generated method stub
		HashMap<String, Object> result = new HashMap<>();
		try {
			HttpResponse<String> response = Unirest.post("http://127.0.0.1:8000/user/token")
					.header("Content-Type", "application/json")
					.body("{\n\t\"username\":\n\t\t\"" + nuevoLogin.getUsername() + "\",\n\t\"password\":\n\t\t\""
							+ nuevoLogin.getPassword() + "\"\n}")
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

}
