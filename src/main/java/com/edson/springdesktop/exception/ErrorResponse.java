package com.edson.springdesktop.exception;

import java.util.List;

public class ErrorResponse {
    private List<String> erros;

    public ErrorResponse(List<String> erros) {
        this.erros = erros;
    }

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }
}
