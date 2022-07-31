package com.IBFS.AdminIBFS.controlador.impl;

import java.util.HashMap;
import java.util.List;

import com.IBFS.AdminIBFS.controlador.PublicacionControlador;
import com.IBFS.AdminIBFS.modelo.dao.PublicacionDao;
import com.IBFS.AdminIBFS.modelo.dao.impl.PublicacionDaoImpl;
import com.IBFS.AdminIBFS.modelo.entidades.Publicacion;

public class PublicacionControladorImpl implements PublicacionControlador{
	
	private PublicacionDao publicacionDao;

	public PublicacionControladorImpl() {
		publicacionDao = new PublicacionDaoImpl();
	}
	
	@Override
	public HashMap<String, Object> insertarPublicacion(Publicacion nuevoPublicacion) {
		// TODO Auto-generated method stub
		return publicacionDao.insertarPublicacion(nuevoPublicacion);
	}

	@Override
	public void actualizarPublicacion(Publicacion actualizarPublicacion) {
		// TODO Auto-generated method stub
		publicacionDao.actualizarPublicacion(actualizarPublicacion);
	}

	@Override
	public void borrarPublicacion(Publicacion borrarPublicacion) {
		// TODO Auto-generated method stub
		publicacionDao.borrarPublicacion(borrarPublicacion);
	}

	@Override
	public List<Publicacion> listarPublicacion() {
		// TODO Auto-generated method stub
		return publicacionDao.listarPublicacion();
	}

	@Override
	public List<Publicacion> buscarPublicacionPorTitulo(String pub_titulo) {
		// TODO Auto-generated method stub
		return publicacionDao.buscarPublicacionPorTitulo(pub_titulo);
	}

}
