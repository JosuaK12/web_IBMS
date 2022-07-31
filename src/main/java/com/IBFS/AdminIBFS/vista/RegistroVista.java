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

import com.IBFS.AdminIBFS.controlador.CategoriaControlador;
import com.IBFS.AdminIBFS.controlador.EventosControlador;
import com.IBFS.AdminIBFS.controlador.RegistroControlador;
import com.IBFS.AdminIBFS.controlador.UsuarioControlador;
import com.IBFS.AdminIBFS.controlador.impl.CategoriaControladorImpl;
import com.IBFS.AdminIBFS.controlador.impl.EventosControladorImpl;
import com.IBFS.AdminIBFS.controlador.impl.RegistroControladorImpl;
import com.IBFS.AdminIBFS.controlador.impl.UsuarioControladorImpl;
import com.IBFS.AdminIBFS.modelo.entidades.Categoria;
import com.IBFS.AdminIBFS.modelo.entidades.Eventos;
import com.IBFS.AdminIBFS.modelo.entidades.Publicacion;
import com.IBFS.AdminIBFS.modelo.entidades.Registro;
import com.IBFS.AdminIBFS.modelo.entidades.Usuario;

@ManagedBean
@ViewScoped
public class RegistroVista implements Serializable {

	private static final long serialVersionUID = 1L;

	private RegistroControlador registroControlador;
	private UsuarioControlador usuarioControlador;
	private EventosControlador eventosControlador;
	private Registro nuevoRegistro;
	private Registro seleccionRegistro;
	private List<Registro> listaRegistro;
	private List<Usuario> listaUsuario;
	private List<Eventos> listaEventos;
	private String user_id;
	private String eventos_id;

	public RegistroVista() {

	}

	@PostConstruct
	public void init() {
		eventosControlador = new EventosControladorImpl();
		usuarioControlador = new UsuarioControladorImpl();
		registroControlador = new RegistroControladorImpl();
		nuevoRegistro = new Registro();
		// listaRegistro = new ArrayList<>();
		listarRegistro();
		listarEventos();
		listarUsuarios();
	}

	public void insertarRegistro() {
		try {
			if (user_id.equals("")) {
				nuevoRegistro.setUser_id(0);
			} else {
				nuevoRegistro.setUser_id(Integer.parseInt(user_id));
			}
			if (eventos_id.equals("")) {
				nuevoRegistro.setEventos_id(0);
			} else {
				nuevoRegistro.setEventos_id(Integer.parseInt(eventos_id));
			}
			HashMap<String, Object> insert = registroControlador.insertarRegistro(nuevoRegistro);
			if (Integer.parseInt(insert.get("status").toString()) != 201) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", insert.get("data").toString()));
			} else {
				PrimeFaces.current().executeScript("PF('registroDialogo').hide()");
				listarRegistro();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Gurdado con exito", "Transaccion registrada con exito"));
			}

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "hubo un problema al insertar"));
		}

		PrimeFaces.current().ajax().update("frmRegistro:mensaje", "frmRegistro:dtregistro");
	}

	public void listarRegistro() {
		listaRegistro = registroControlador.listarRegistro();
		System.out.print(listaRegistro);
	}

	public void listarUsuarios() {
		listaUsuario = usuarioControlador.listarUsuario();
		System.out.print(listaUsuario);
	}

	public void listarEventos() {
		listaEventos = eventosControlador.listarEventos();
		System.out.print(listaEventos);
	}

	public RegistroControlador getRegistroControlador() {
		return registroControlador;
	}

	public void setRegistroControlador(RegistroControlador registroControlador) {
		this.registroControlador = registroControlador;
	}

	public Registro getNuevoRegistro() {
		return nuevoRegistro;
	}

	public void setNuevoRegistro(Registro nuevoRegistro) {
		this.nuevoRegistro = nuevoRegistro;
	}

	public Registro getSeleccionRegistro() {
		return seleccionRegistro;
	}

	public void setSeleccionRegistro(Registro seleccionRegistro) {
		this.seleccionRegistro = seleccionRegistro;
	}

	public List<Registro> getListaRegistro() {
		return listaRegistro;
	}

	public void setListaRegistro(List<Registro> listaRegistro) {
		this.listaRegistro = listaRegistro;
	}

	public UsuarioControlador getUsuarioControlador() {
		return usuarioControlador;
	}

	public void setUsuarioControlador(UsuarioControlador usuarioControlador) {
		this.usuarioControlador = usuarioControlador;
	}

	public EventosControlador getEventosControlador() {
		return eventosControlador;
	}

	public void setEventosControlador(EventosControlador eventosControlador) {
		this.eventosControlador = eventosControlador;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public List<Eventos> getListaEventos() {
		return listaEventos;
	}

	public void setListaEventos(List<Eventos> listaEventos) {
		this.listaEventos = listaEventos;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getEventos_id() {
		return eventos_id;
	}

	public void setEventos_id(String eventos_id) {
		this.eventos_id = eventos_id;
	}
}
