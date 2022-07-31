package com.IBFS.AdminIBFS.controlador.impl;

import java.util.HashMap;
import java.util.List;

import com.IBFS.AdminIBFS.controlador.UsuarioControlador;
import com.IBFS.AdminIBFS.modelo.dao.UsuarioDao;
import com.IBFS.AdminIBFS.modelo.dao.impl.UsuarioDaoImpl;
import com.IBFS.AdminIBFS.modelo.entidades.Usuario;

public class UsuarioControladorImpl implements UsuarioControlador{
	
	private UsuarioDao usuarioDao;

	public UsuarioControladorImpl() {
		usuarioDao = new UsuarioDaoImpl();
	}

	@Override
	public HashMap<String, Object> insertarUsuario(Usuario nuevoUsuario) {
		// TODO Auto-generated method stub
		return usuarioDao.insertarUsuario(nuevoUsuario);
	}

	@Override
	public void actualizarUsuario(Usuario actualizarUsuario) {
		// TODO Auto-generated method stub
		usuarioDao.actualizarUsuario(actualizarUsuario);
	}

	@Override
	public void borrarUsuario(Usuario borrarUsuario) {
		// TODO Auto-generated method stub
		usuarioDao.borrarUsuario(borrarUsuario);
	}

	@Override
	public List<Usuario> listarUsuario() {
		// TODO Auto-generated method stub
		return usuarioDao.listarUsuario();
	}

	@Override
	public List<Usuario> buscarUsuarioPorCi(String cedulaUsuario) {
		return usuarioDao.buscarUsuarioPorCi(cedulaUsuario);
	}

	@Override
	public List<Usuario> buscarUsuarioPorNombre(String nombreUsuario) {
		// TODO Auto-generated method stub
		return usuarioDao.buscarUsuarioPorNombre(nombreUsuario);
	}

}
