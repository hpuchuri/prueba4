package pe.gob.vuce.sgringesta.exception;

public class ServiceException extends RuntimeException {
	private String cabecera;
	private String detalle;

	public ServiceException() {
		super();
	}

	public ServiceException(String cabecera, String detalle) {
		super(detalle);

		this.cabecera = cabecera;
		this.detalle = detalle;
	}

	public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
		this.detalle = message;
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public String getCabecera() {
		return cabecera;
	}

	public void setCabecera(String cabecera) {
		this.cabecera = cabecera;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

}
