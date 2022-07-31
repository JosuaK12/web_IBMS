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
import com.IBFS.AdminIBFS.controlador.impl.CategoriaControladorImpl;
import com.IBFS.AdminIBFS.modelo.entidades.Categoria;

@ManagedBean
@ViewScoped
public class CategoriaVista implements Serializable {

	private static final long serialVersionUID = 1L;

	private CategoriaControlador categoriaControlador;
	private Categoria nuevoCategoria;
	private Categoria seleccionCategoria;
	private List<Categoria> listaCategoria;

	public CategoriaVista() {

	}

	@PostConstruct
	public void init() {
		categoriaControlador = new CategoriaControladorImpl();
		nuevoCategoria = new Categoria();
		// listaCategoria = new ArrayList<>();
		listarCategoria();
	}

	public void insertarCategoria() {
		try {
			HashMap<String, Object> insert = categoriaControlador.insertarCategoria(nuevoCategoria);
			if (Integer.parseInt(insert.get("status").toString()) != 201) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", insert.get("data").toString()));
			} else {
				PrimeFaces.current().executeScript("PF('categoriaDialogo').hide()");
				listarCategoria();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Gurdado con exito", "Transaccion registrada con exito"));
			}

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "hubo un problema al insertar Categoria"));
		}
		PrimeFaces.current().ajax().update("frmCategoria:mensaje", "frmCategoria:dtcategoria");
	}

	public void listarCategoria() {
		listaCategoria = categoriaControlador.listarCategoria();
		System.out.print(listaCategoria);
	}

	public CategoriaControlador getCategoriaControlador() {
		return categoriaControlador;
	}

	public void setCategoriaControlador(CategoriaControlador categoriaControlador) {
		this.categoriaControlador = categoriaControlador;
	}

	public Categoria getNuevoCategoria() {
		return nuevoCategoria;
	}

	public void setNuevoCategoria(Categoria nuevoCategoria) {
		this.nuevoCategoria = nuevoCategoria;
	}

	public Categoria getSeleccionCategoria() {
		return seleccionCategoria;
	}

	public void setSeleccionCategoria(Categoria seleccionCategoria) {
		this.seleccionCategoria = seleccionCategoria;
	}

	public List<Categoria> getListaCategoria() {
		return listaCategoria;
	}

	public void setListaCategoria(List<Categoria> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}
}
