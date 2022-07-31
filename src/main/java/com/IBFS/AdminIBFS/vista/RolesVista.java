package com.IBFS.AdminIBFS.vista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import com.IBFS.AdminIBFS.controlador.RolesControlador;
import com.IBFS.AdminIBFS.controlador.impl.RolesControladorImpl;
import com.IBFS.AdminIBFS.modelo.entidades.Roles;

@ManagedBean
@ViewScoped
public class RolesVista implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private RolesControlador rolesControlador;
    private Roles nuevoRoles;
    private Roles seleccionRoles;
    private List<Roles> listaRoles;
    
    public RolesVista() {

    }
    
    @PostConstruct
    public void init() {
        rolesControlador = new RolesControladorImpl();
        nuevoRoles = new Roles();
        //listaRoles = new ArrayList<>();
        listarRoles();
    }
    
    public void insertarRoles() {
        try {
        	HashMap<String, Object> insert = rolesControlador.insertarRoles(nuevoRoles);
        	if (Integer.parseInt(insert.get("status").toString()) != 201) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", insert.get("data").toString()));
        	}else {    
        		PrimeFaces.current().executeScript("PF('rolesDialogo').hide()");
        		listarRoles();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Gurdado con exito", "TRansaccion registrada con exito"));
                
        	}
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "hubo un problema al insertar registro"));
        }
        
        PrimeFaces.current().ajax().update("frmRoles:mensaje", "frmRoles:dtroles");
    }
    public void listarRoles() {
        listaRoles = rolesControlador.listarRoles();
        System.out.print(listaRoles);
    }

	public RolesControlador getRolesControlador() {
		return rolesControlador;
	}

	public Roles getNuevoRoles() {
		return nuevoRoles;
	}

	public void setNuevoRoles(Roles nuevoRoles) {
		this.nuevoRoles = nuevoRoles;
	}

	public Roles getSeleccionRoles() {
		return seleccionRoles;
	}

	public void setSeleccionRoles(Roles seleccionRoles) {
		this.seleccionRoles = seleccionRoles;
	}

	public List<Roles> getListaRoles() {
		return listaRoles;
	}

	public void setListaRoles(List<Roles> listaRoles) {
		this.listaRoles = listaRoles;
	}

	public void setRolesControlador(RolesControlador rolesControlador) {
		this.rolesControlador = rolesControlador;
	}

}
