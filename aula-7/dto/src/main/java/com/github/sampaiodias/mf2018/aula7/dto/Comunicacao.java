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
public class Comunicacao {

    private Integer codigoMeio;
    private String codigoPreferencia;
    private Integer codigoUso;
    private String detalhe;
    
    public final Integer getCodigoMeio() {
        return codigoMeio;
    }
    
    public final String getCodigoPreferencia() {
        return codigoPreferencia;
    }

    public final Integer getCodigoUso() {
        return codigoUso;
    }

    public final String getDetalhe() {
        return detalhe;
    }

    public final void setCodigoMeio(final Integer newCodigoMeio) {
        codigoMeio = newCodigoMeio;
    }

    public final void setCodigoPreferencia(final String newCodigoPreferencia) {
        codigoPreferencia = newCodigoPreferencia;
    }

    public final void setCodigoUso(final Integer newCodigoUso) {
        codigoUso = newCodigoUso;
    }

    public final void setDetalhe(final String newDetalhe) {
        detalhe = newDetalhe;
    }
}
