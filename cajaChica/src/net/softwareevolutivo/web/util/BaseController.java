/*
 * Copyright 2012 UNIVERSIDAD CENTRAL DEL ECUADOR 
 * Todos los derechos reservados
 */

package net.softwareevolutivo.web.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <b> Controlador base para manejo de mensajes expuestos en las paginas </b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
 *          </p>
 */
public class BaseController {

	/**
	 * 
	 * <b> <b> Permite agregar mensajes de informacion a la pagina </b>
	 * <p>
	 * [Author: Marcelo Hidalgo, Date: 13/02/2017]
	 * </p>
	 * 
	 * @param summary
	 *            : summary
	 */
	public void addInfoMessage(String summary) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, summary, ""));
	}

	/**
	 * Permite agregar mensajes de error a la pagina
	 * 
	 * @param mensaje
	 */
	public void addErrorMessage(String mensaje) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje, ""));
	}

	/**
	 * @return HttpServletRequest: HttpServletRequest
	 */
	public HttpServletRequest getHttpRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	/**
	 * @return HttpServletResponse: HttpServletResponse
	 */
	public HttpServletResponse getHttpResponse() {
		return (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
	}

	/**
	 * @return HttpSession: HttpSession
	 */
	public HttpSession getHttpSession() {
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	}

	/**
	 * Obtiene la URL completa de la pagina actual
	 * 
	 * @return String: String
	 */
	protected String getURL() {
		return ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest())
				.getRequestURL().toString();
	}

	/**
	 * Obtiene el FacesContext del contexto actual web de la aplicacion
	 * FacesContext.getCurrentInstance()
	 * 
	 * @return FacesContext: FacesContext
	 */
	protected FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

}
