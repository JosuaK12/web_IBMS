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

import com.IBFS.AdminIBFS.controlador.UsuarioControlador;
import com.IBFS.AdminIBFS.controlador.impl.UsuarioControladorImpl;
import com.IBFS.AdminIBFS.modelo.entidades.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioVista implements Serializable {

	private static final long serialVersionUID = 1L;
	private UsuarioControlador usuarioControlador;
	private Usuario nuevoUsuario;
	private Usuario seleccionUsuario;
	private List<Usuario> listaUsuario;

	public UsuarioVista() {

	}

	@PostConstruct
	public void init() {
		usuarioControlador = new UsuarioControladorImpl();
		nuevoUsuario = new Usuario();
		// listaUsuario = new ArrayList<>();
		listarUsuario();
	}

	public void insertarUsuario() {
		try {
			HashMap<String, Object> insert = usuarioControlador.insertarUsuario(nuevoUsuario);
			if (Integer.parseInt(insert.get("status").toString()) != 201) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", insert.get("data").toString()));
			} else {
				PrimeFaces.current().executeScript("PF('usuarioDialogo').hide()");
				listarUsuario();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Gurdado con exito", "TRansaccion registrada con exito"));
			}

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "hubo un problema al insertar Usuario"));
		}

		PrimeFaces.current().ajax().update("frmUsuario:mensaje", "frmUsuario:dtusuario");
	}

	public void listarUsuario() {
		listaUsuario = usuarioControlador.listarUsuario();
		System.out.print(listaUsuario);
	}

	public UsuarioControlador getUsuarioControlador() {
		return usuarioControlador;
	}

	public void setUsuarioControlador(UsuarioControlador usuarioControlador) {
		this.usuarioControlador = usuarioControlador;
	}

	public Usuario getNuevoUsuario() {
		return nuevoUsuario;
	}

	public void setNuevoUsuario(Usuario nuevoUsuario) {
		this.nuevoUsuario = nuevoUsuario;
	}

	public Usuario getSeleccionUsuario() {
		return seleccionUsuario;
	}

	public void setSeleccionUsuario(Usuario seleccionUsuario) {
		this.seleccionUsuario = seleccionUsuario;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
}
