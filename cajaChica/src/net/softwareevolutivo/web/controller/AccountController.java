package net.softwareevolutivo.web.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import net.softwareevolutivo.dao.entity.Account;
import net.softwareevolutivo.service.AccountService;
import net.softwareevolutivo.web.util.BaseController;

/**
 * <b> Controlador tipo request para el manejo de las cuentas relacionadas al sistema</b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 06/07/2012 $]
 *          </p>
 */
@ManagedBean
@RequestScoped
public class AccountController extends BaseController {

	@EJB
	private AccountService usuarioService;

	private String usuario;
	private String password;

	/**
	 * <b> Valida el usuario ingresado conjuntamente con su password </b>
	 * 
	 * @author Marcelo Hidalgo
	 * @version $Revision: 1.0 $
	 *          <p>
	 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
	 *          </p>
	 */
	public String validarUsuario() {
		try {
			Account user = usuarioService.findAccountByUsernameAndPassword(usuario, password);
			if (user != null) {
				return "menu";
			} else{
				addErrorMessage("Error de Login, password o usuario incorrecto");
			}
		} catch (Exception e) {
			addErrorMessage(e.getMessage());
		}
		return "home";
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
