package org.elias.exception;

public class HttpNotFoundException extends RuntimeException {

    public HttpNotFoundException(String mensaje) {
        super(mensaje);
    }

}
