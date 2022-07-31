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
import com.IBFS.AdminIBFS.controlador.PublicacionControlador;
import com.IBFS.AdminIBFS.controlador.UsuarioControlador;
import com.IBFS.AdminIBFS.controlador.impl.CategoriaControladorImpl;
import com.IBFS.AdminIBFS.controlador.impl.PublicacionControladorImpl;
import com.IBFS.AdminIBFS.controlador.impl.UsuarioControladorImpl;
import com.IBFS.AdminIBFS.modelo.entidades.Categoria;
import com.IBFS.AdminIBFS.modelo.entidades.Publicacion;
import com.IBFS.AdminIBFS.modelo.entidades.Usuario;

@ManagedBean
@ViewScoped
public class PublicacionVista implements Serializable {

	private static final long serialVersionUID = 1L;

	private PublicacionControlador publicacionControlador;
	private UsuarioControlador usuarioControlador;
	private CategoriaControlador categoriaControlador;
	private Publicacion nuevoPublicacion;
	private Publicacion seleccionPublicacion;
	private List<Publicacion> listaPublicacion;
	private List<Usuario> listaUsuario;
	private List<Categoria> listaCategoria;
	private String user_id;
	private String categoria_id;

	public PublicacionVista() {

	}

	@PostConstruct
	public void init() {
		categoriaControlador = new CategoriaControladorImpl();
		usuarioControlador = new UsuarioControladorImpl();
		publicacionControlador = new PublicacionControladorImpl();
		nuevoPublicacion = new Publicacion();
		// listaPublicacion = new ArrayList<>();
		listarPublicacion();
		listarUsuarios();
		listarCategoria();
	}

	public void insertarPublicacion() {
		try {
			if (user_id.equals("")) {
				nuevoPublicacion.setUser_id(0);
			} else {
				nuevoPublicacion.setUser_id(Integer.parseInt(user_id));
			}
			if (categoria_id.equals("")) {
				nuevoPublicacion.setCategoria_id(0);
			} else {
				nuevoPublicacion.setCategoria_id(Integer.parseInt(categoria_id));
			}
			HashMap<String, Object> insert = publicacionControlador.insertarPublicacion(nuevoPublicacion);
			if (Integer.parseInt(insert.get("status").toString()) != 201) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", insert.get("data").toString()));
			} else {
				PrimeFaces.current().executeScript("PF('publicacionDialogo').hide()");
				listarPublicacion();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Gurdado con exito", "Publicacion registrado con exito"));
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "hubo un problema al insertar publicacion"));
		}
		PrimeFaces.current().ajax().update("frmPublicacion:mensaje", "frmPublicacion:dtpublicacion");
	}

	public void listarPublicacion() {
		listaPublicacion = publicacionControlador.listarPublicacion();
		System.out.print(listaPublicacion);
	}

	public void listarUsuarios() {
		listaUsuario = usuarioControlador.listarUsuario();
		System.out.print(listaUsuario);
	}

	public void listarCategoria() {
		listaCategoria = categoriaControlador.listarCategoria();
		System.out.print(listaCategoria);
	}

	public PublicacionControlador getPublicacionControlador() {
		return publicacionControlador;
	}

	public void setPublicacionControlador(PublicacionControlador publicacionControlador) {
		this.publicacionControlador = publicacionControlador;
	}

	public Publicacion getNuevoPublicacion() {
		return nuevoPublicacion;
	}

	public void setNuevoPublicacion(Publicacion nuevoPublicacion) {
		this.nuevoPublicacion = nuevoPublicacion;
	}

	public Publicacion getSeleccionPublicacion() {
		return seleccionPublicacion;
	}

	public void setSeleccionPublicacion(Publicacion seleccionPublicacion) {
		this.seleccionPublicacion = seleccionPublicacion;
	}

	public List<Publicacion> getListaPublicacion() {
		return listaPublicacion;
	}

	public void setListaPublicacion(List<Publicacion> listaPublicacion) {
		this.listaPublicacion = listaPublicacion;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(String categoria_id) {
		this.categoria_id = categoria_id;
	}

	public UsuarioControlador getUsuarioControlador() {
		return usuarioControlador;
	}

	public void setUsuarioControlador(UsuarioControlador usuarioControlador) {
		this.usuarioControlador = usuarioControlador;
	}

	public CategoriaControlador getCategoriaControlador() {
		return categoriaControlador;
	}

	public void setCategoriaControlador(CategoriaControlador categoriaControlador) {
		this.categoriaControlador = categoriaControlador;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public List<Categoria> getListaCategoria() {
		return listaCategoria;
	}

	public void setListaCategoria(List<Categoria> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}
}
