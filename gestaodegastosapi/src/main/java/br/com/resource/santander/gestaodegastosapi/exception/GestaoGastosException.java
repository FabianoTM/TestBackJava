package br.com.resource.santander.gestaodegastosapi.exception;

public class GestaoGastosException extends Exception {

    private static final long serialVersionUID = 1L;

    public GestaoGastosException(String msg) {

        super(msg);
    }

    public GestaoGastosException(Throwable exception) {

        super(exception);
    }

    public GestaoGastosException(String msgErro, Exception exception) {

        super(msgErro, exception);
    }

}
