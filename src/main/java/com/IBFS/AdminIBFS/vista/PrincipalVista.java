package com.IBFS.AdminIBFS.vista;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import com.IBFS.AdminIBFS.modelo.entidades.Login;

@ManagedBean
@ViewScoped
public class PrincipalVista implements Serializable {

	private static final long serialVersionUID = 1L;
	private Login login;
	private String token1;
	
	public PrincipalVista() {

	}

	@PostConstruct
	public void init() {
		login = new Login();
		session();	}

	public String LogOut() {

		String redireccion = null;
		redireccion = "Login";
		return redireccion;

	}
	
	private void session() {
		UIViewRoot view = FacesContext.getCurrentInstance().getViewRoot();
		UIComponent component = view.findComponent("token-access");
		System.out.print(component.toString());
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getToken1() {
		return token1;
	}

	public void setToken1(String token1) {
		this.token1 = token1;
	}
}
