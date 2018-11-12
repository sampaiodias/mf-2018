/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula7.dto;

import java.time.LocalDate;

/**
 *
 * @author Lucas Sampaio Dias
 */
public class NacionalidadeDTO {

    private Integer codigoMunicipio;
    private String codigoEstado;
    private Integer codigoPais;
    private LocalDate dataEntradaPais;
    
    public final Integer getCodigoMunicipio() {
        return codigoMunicipio;
    }
    
        public final String getCodigoEstado() {
        return codigoEstado;
    }

    public final Integer getCodigoPais() {
        return codigoPais;
    }

    public final LocalDate getDataEntradaPais() {
        return dataEntradaPais;
    }

    public final void setCodigoMunicipio(final Integer newCodigoMunicipio) {
        codigoMunicipio = newCodigoMunicipio;
    }
    
    public final void setCodigoEstado(final String newCodigoEstado) {
        codigoEstado = newCodigoEstado;
    }

    public final void setCodigoPais(final Integer newCodigoPais) {
        codigoPais = newCodigoPais;
    }

    public final void setDataEntradaPais(
            final LocalDate newDataEntradaPais) {
        dataEntradaPais = newDataEntradaPais;
    }
}