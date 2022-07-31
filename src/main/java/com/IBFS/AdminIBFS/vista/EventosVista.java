package com.IBFS.AdminIBFS.vista;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import com.IBFS.AdminIBFS.controlador.EventosControlador;
import com.IBFS.AdminIBFS.controlador.impl.EventosControladorImpl;
import com.IBFS.AdminIBFS.modelo.entidades.Eventos;

@ManagedBean
@ViewScoped
public class EventosVista implements Serializable {

	private static final long serialVersionUID = 1L;

	private EventosControlador eventosControlador;
	private Eventos nuevoEventos;
	private Eventos seleccionEventos;
	private List<Eventos> listaEventos;

	public EventosVista() {

	}

	@PostConstruct
	public void init() {
		eventosControlador = new EventosControladorImpl();
		nuevoEventos = new Eventos();
		// listaEventos = new ArrayList<>();
		listarEventos();
	}

	public void insertarEventos() {
		try {
			HashMap<String, Object> insert = eventosControlador.insertarEventos(nuevoEventos);
			if (Integer.parseInt(insert.get("status").toString()) != 201) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", insert.get("data").toString()));
			} else {
				PrimeFaces.current().executeScript("PF('eventosDialogo').hide()");
				listarEventos();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Gurdado con exito", "Transaccion registrada con exito"));
			}

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "hubo un problema al insertar Evento"));
		}
		PrimeFaces.current().ajax().update("frmEventos:mensaje", "frmEventos:dteventos");
	}

	public void listarEventos() {
		listaEventos = eventosControlador.listarEventos();
		System.out.print(listaEventos);
	}

	public EventosControlador getEventosControlador() {
		return eventosControlador;
	}

	public void setEventosControlador(EventosControlador eventosControlador) {
		this.eventosControlador = eventosControlador;
	}

	public Eventos getNuevoEventos() {
		return nuevoEventos;
	}

	public void setNuevoEventos(Eventos nuevoEventos) {
		this.nuevoEventos = nuevoEventos;
	}

	public Eventos getSeleccionEventos() {
		return seleccionEventos;
	}

	public void setSeleccionEventos(Eventos seleccionEventos) {
		this.seleccionEventos = seleccionEventos;
	}

	public List<Eventos> getListaEventos() {
		return listaEventos;
	}

	public void setListaEventos(List<Eventos> listaEventos) {
		this.listaEventos = listaEventos;
	}

}
