package net.softwareevolutivo.exception;

/**
 * <b> Excepcion para manejar errore controlados en la base de datos</b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
 *          </p>
 */
public class DAOException extends Exception {

	private static final long serialVersionUID = 1L;
	
	/**
	* 
	*/
	public DAOException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	* @param message : mensaje
	* @param cause : causa
	 */
	public DAOException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message : mensaje
	 */
	public DAOException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause : causa
	 */
	public DAOException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
