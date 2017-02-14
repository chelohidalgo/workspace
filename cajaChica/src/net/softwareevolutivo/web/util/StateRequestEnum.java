package net.softwareevolutivo.web.util;

/**
 * <b> Enumeracion para control de estados de las solicitudes de dinero en caja </b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
 *          </p>
 */
public enum StateRequestEnum {

	ACTIVO("ACT"),
	INACTIVO("INA"),
	ENTREGADO("ENT");
	
	private StateRequestEnum(String state) {
		this.state = state;
	}
	
	private String state;

	public String getState() {
		return state;
	}
	
}
