package com.IBFS.AdminIBFS.modelo.dao;

import java.util.HashMap;
import java.util.List;

import com.IBFS.AdminIBFS.modelo.entidades.Publicacion;

public interface PublicacionDao {
	public HashMap<String, Object> insertarPublicacion(Publicacion nuevoPublicacion);
	public void actualizarPublicacion(Publicacion actualizarPublicacion);
	public void borrarPublicacion(Publicacion borrarPublicacion);
	public List<Publicacion> listarPublicacion();
	public List<Publicacion> buscarPublicacionPorTitulo(String pub_titulo);
}
