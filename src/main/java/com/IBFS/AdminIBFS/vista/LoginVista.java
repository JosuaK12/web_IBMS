package com.IBFS.AdminIBFS.vista;

import java.io.Serializable;
import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.json.JSONArray;
import org.json.JSONObject;
import org.primefaces.PrimeFaces;
import com.IBFS.AdminIBFS.modelo.entidades.Login;
import com.IBFS.AdminIBFS.controlador.LoginControlador;
import com.IBFS.AdminIBFS.controlador.impl.LoginControladorImpl;

@ManagedBean
@ViewScoped
public class LoginVista implements Serializable {

	private static final long serialVersionUID = 1L;

	private LoginControlador loginControlador;
	private Login nuevoLogin;

	public LoginVista() {

	}

	@PostConstruct
	public void init() {
		nuevoLogin = new Login();
		loginControlador = new LoginControladorImpl();
	}

	public String Login() {
		String redireccion = null;
		Login login = new Login();
		HashMap<String, Object> insert = loginControlador.inciarSesion(nuevoLogin);
		try {

			if (Integer.parseInt(insert.get("status").toString()) != 200) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", insert.get("data").toString()));
			} else {
				JSONObject object = new JSONObject(insert.get("data").toString());
				login.setToken(object.getString("access"));
				String prueba = "sessionStorage.setItem(\"token\",\"" + login.getToken() + "\");";
				PrimeFaces.current().executeScript(prueba);
				redireccion = "Principal";
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", e.getMessage()));
		}
		return redireccion;
	}

	public LoginControlador getLoginControlador() {
		return loginControlador;
	}

	public void setLoginControlador(LoginControlador loginControlador) {
		this.loginControlador = loginControlador;
	}

	public Login getNuevoLogin() {
		return nuevoLogin;
	}

	public void setNuevoLogin(Login nuevoLogin) {
		this.nuevoLogin = nuevoLogin;
	}
}
