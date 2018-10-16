package br.com.resource.santander.gestaodegastosapi.model;

import org.springframework.http.HttpStatus;

/**
 * Classe utilizada para mapear mensagens retorno de erro!.
 */
public class ApiError {

    /** Status http. */
    private HttpStatus httpStatus;

    /** Mensagem. */
    private String mensagem;

    /**
     * Construtor.
     *
     * @param httpStatus
     *            the http status
     * @param mensagem
     *            the mensagem
     */
    public ApiError(HttpStatus httpStatus, String mensagem) {

        this.httpStatus = httpStatus;
        this.mensagem = mensagem;
    }

    /**
     * Gets the http status.
     *
     * @return the httpStatus
     */
    public HttpStatus getHttpStatus() {

        return this.httpStatus;
    }

    /**
     * Gets the mensagem.
     *
     * @return the mensagem
     */
    public String getMensagem() {

        return this.mensagem;
    }
}