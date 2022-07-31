package com.IBFS.AdminIBFS.controlador.impl;

import java.util.HashMap;
import java.util.List;

import com.IBFS.AdminIBFS.controlador.RegistroControlador;
import com.IBFS.AdminIBFS.modelo.dao.RegistroDao;
import com.IBFS.AdminIBFS.modelo.dao.impl.RegistroDaoImpl;
import com.IBFS.AdminIBFS.modelo.entidades.Registro;

public class RegistroControladorImpl implements RegistroControlador {
	
	private RegistroDao registroDao;

	public RegistroControladorImpl() {
		registroDao = new RegistroDaoImpl();
	}
	
	@Override
	public HashMap<String, Object> insertarRegistro(Registro nuevoRegistro) {
		// TODO Auto-generated method stub
		return registroDao.insertarRegistro(nuevoRegistro);
		
	}

	@Override
	public void actualizarRegistro(Registro actualizarRegistro) {
		// TODO Auto-generated method stub
		registroDao.actualizarRegistro(actualizarRegistro);
	}

	@Override
	public void borrarRegistro(Registro borrarRegistro) {
		// TODO Auto-generated method stub
		registroDao.borrarRegistro(borrarRegistro);
		
	}

	@Override
	public List<Registro> listarRegistro() {
		// TODO Auto-generated method stub
		return registroDao.listarRegistro();
	}

}
