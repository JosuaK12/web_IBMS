package com.IBFS.AdminIBFS.controlador;

import java.util.HashMap;
import java.util.List;

import com.IBFS.AdminIBFS.modelo.entidades.Publicacion;

public interface PublicacionControlador {
	public HashMap<String, Object> insertarPublicacion(Publicacion nuevoPublicacion);
	public void actualizarPublicacion(Publicacion actualizarPublicacion);
	public void borrarPublicacion(Publicacion borrarPublicacion);
	public List<Publicacion> listarPublicacion();
	public List<Publicacion> buscarPublicacionPorTitulo(String pub_titulo);
}
