package com.busca.cep.apibuscacep.config.validacao;

public class ErrorValidacaoDto {

    private String campo;
    private String erro;

    public ErrorValidacaoDto(String campo, String erro){
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
