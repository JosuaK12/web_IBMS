package com.IBFS.AdminIBFS.controlador;

import java.util.HashMap;
import java.util.List;

import com.IBFS.AdminIBFS.modelo.entidades.Eventos;

public interface EventosControlador {
	public HashMap<String, Object> insertarEventos(Eventos nuevoEventos);
	public void actualizarEventos(Eventos actualizarEventos);
	public void borrarEventos(Eventos borrarEventos);
	public List<Eventos> listarEventos();
	public List<Eventos> buscarEventosPorNombre(String eve_nombre);
}
