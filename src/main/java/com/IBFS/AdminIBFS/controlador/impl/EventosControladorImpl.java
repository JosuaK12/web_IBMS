package com.IBFS.AdminIBFS.controlador.impl;

import java.util.HashMap;
import java.util.List;

import com.IBFS.AdminIBFS.controlador.EventosControlador;
import com.IBFS.AdminIBFS.modelo.dao.EventosDao;
import com.IBFS.AdminIBFS.modelo.dao.impl.EventosDaoImpl;
import com.IBFS.AdminIBFS.modelo.entidades.Eventos;

public class EventosControladorImpl implements EventosControlador{

	private EventosDao eventosDao;

	public EventosControladorImpl() {
		eventosDao = new EventosDaoImpl();
	}
	
	@Override
	public HashMap<String, Object> insertarEventos(Eventos nuevoEventos) {
		// TODO Auto-generated method stub
		return eventosDao.insertarEventos(nuevoEventos);
	}

	@Override
	public void actualizarEventos(Eventos actualizarEventos) {
		// TODO Auto-generated method stub
		eventosDao.actualizarEventos(actualizarEventos);
	}

	@Override
	public void borrarEventos(Eventos borrarEventos) {
		// TODO Auto-generated method stub
		eventosDao.borrarEventos(borrarEventos);
	}

	@Override
	public List<Eventos> listarEventos() {
		// TODO Auto-generated method stub
		return eventosDao.listarEventos();
	}

	@Override
	public List<Eventos> buscarEventosPorNombre(String eve_nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
