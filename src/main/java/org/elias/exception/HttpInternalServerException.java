package ar.gob.ushuaia.exception;


/**
 * The type Http internal server exception.
 */
public class HttpInternalServerException extends RuntimeException {

    /**
     * Instantiates a new Http internal server exception.
     *
     * @param mensaje el mensaje recibido desde el lanzador de la excepción.
     */
    public HttpInternalServerException(String mensaje, Throwable cause) { super(mensaje, cause); }

    public HttpInternalServerException(String mensaje) { super(mensaje); }

}
