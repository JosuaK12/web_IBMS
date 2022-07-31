package com.IBFS.AdminIBFS.modelo.dao;

import java.util.HashMap;
import java.util.List;

import com.IBFS.AdminIBFS.modelo.entidades.Roles;

public interface RolesDao {
	public HashMap<String, Object> insertarRoles(Roles nuevoRoles);
	public void actualizarRoles(Roles actualizarRoles);
	public void borrarRoles(Roles borrarRoles);
	public List<Roles> listarRoles();
}
