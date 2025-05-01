package org.elias.exception;

public class HttpNoContentException extends RuntimeException{

    public HttpNoContentException(String mensaje){
        super(mensaje);
    }

    public HttpNoContentException(){
        super();
    }

}
