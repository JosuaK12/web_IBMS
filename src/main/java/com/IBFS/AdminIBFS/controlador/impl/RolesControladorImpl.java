package com.IBFS.AdminIBFS.controlador.impl;

import java.util.HashMap;
import java.util.List;

import com.IBFS.AdminIBFS.controlador.RolesControlador;
import com.IBFS.AdminIBFS.modelo.dao.RolesDao;
import com.IBFS.AdminIBFS.modelo.dao.impl.RolesDaoImpl;
import com.IBFS.AdminIBFS.modelo.entidades.Roles;

public class RolesControladorImpl implements RolesControlador {
	
	private RolesDao rolesDao;

	public RolesControladorImpl() {
		rolesDao = new RolesDaoImpl();
	}

	@Override
	public HashMap<String, Object> insertarRoles(Roles nuevoRoles) {
		// TODO Auto-generated method stub
		return rolesDao.insertarRoles(nuevoRoles);
	}

	@Override
	public void actualizarRoles(Roles actualizarRoles) {
		// TODO Auto-generated method stub
		rolesDao.actualizarRoles(actualizarRoles);
	}

	@Override
	public void borrarRoles(Roles borrarRoles) {
		// TODO Auto-generated method stub
		rolesDao.borrarRoles(borrarRoles);
	}

	@Override
	public List<Roles> listarRoles() {
		// TODO Auto-generated method stub
		return rolesDao.listarRoles();
	}

}
