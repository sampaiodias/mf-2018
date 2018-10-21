/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.mf2018.aula5;

/**
 * Mais detalhes no tópico "Aula 5" do documento disponível em:
 * https://docs.google.com/document/d/1TTFjo0qcjmuaYkE1okWAiV_qqoyYs9r4FFO3dp7nikI/edit#
 * @author Lucas Sampaio Dias
 */
public class Estabelecimento {

    private String codigoEstabelecimento;
    private String razaoSocial;
    private String latitude;
    private String longitude;

    public void setCodigoEstabelecimento(String codigoEstabelecimento) {
        this.codigoEstabelecimento = codigoEstabelecimento;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
