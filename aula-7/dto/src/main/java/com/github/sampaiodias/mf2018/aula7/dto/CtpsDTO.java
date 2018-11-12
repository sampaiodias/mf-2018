/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula7.dto;

/**
 *
 * @author Lucas Sampaio Dias
 */
public class CtpsDTO {

    private Integer serie;
    private String codigoEstado;

    public final String getCodigoEstado() {
        return codigoEstado;
    }

    public final Integer getSerie() {
        return serie;
    }

    public final void setCodigoEstado(final String newCodigoEstado) {
        codigoEstado = newCodigoEstado;
    }

    public final void setSerie(final Integer newSerie) {
        serie = newSerie;
    }
}
