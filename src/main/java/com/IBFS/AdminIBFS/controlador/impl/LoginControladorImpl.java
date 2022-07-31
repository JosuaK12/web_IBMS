package com.IBFS.AdminIBFS.controlador.impl;

import java.util.HashMap;

import com.IBFS.AdminIBFS.controlador.LoginControlador;
import com.IBFS.AdminIBFS.modelo.dao.LoginDao;
import com.IBFS.AdminIBFS.modelo.dao.impl.LoginDaoImpl;
import com.IBFS.AdminIBFS.modelo.entidades.Login;

public class LoginControladorImpl implements LoginControlador {
	private LoginDao loginDao;

	public LoginControladorImpl() {
		loginDao = new LoginDaoImpl();
	}

	@Override
	public HashMap<String, Object> inciarSesion(Login nuevoLogin) {
		// TODO Auto-generated method stub
		return loginDao.inciarSesion(nuevoLogin);
	}

}
