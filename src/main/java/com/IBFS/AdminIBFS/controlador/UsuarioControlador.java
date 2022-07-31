package com.IBFS.AdminIBFS.controlador;

import java.util.HashMap;
import java.util.List;

import com.IBFS.AdminIBFS.modelo.entidades.Usuario;

public interface UsuarioControlador {
	public HashMap<String, Object> insertarUsuario(Usuario nuevoUsuario);
	public void actualizarUsuario(Usuario actualizarUsuario);
	public void borrarUsuario(Usuario borrarUsuario);
	public List<Usuario> listarUsuario();
	public List<Usuario> buscarUsuarioPorCi(String cedulaUsuario);
	public List<Usuario> buscarUsuarioPorNombre(String nombreUsuario);
}
