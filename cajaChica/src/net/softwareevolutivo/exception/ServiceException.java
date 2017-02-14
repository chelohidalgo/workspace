package net.softwareevolutivo.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	* 
	*/
	public ServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param message
	 *            : mensaje
	 * @param cause
	 *            : causa
	 */
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 *            : mensaje
	 */
	public ServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 *            : causa
	 */
	public ServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
