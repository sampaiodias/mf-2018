/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula7.dto;

import com.github.sampaiodias.mf2018.aula7.LocalDateXmlAdapter;
import java.time.LocalDate;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Lucas Sampaio Dias
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class NacionalidadeDTO {

    private Integer codigoMunicipio;
    private String codigoEstado;
    private Integer codigoPais;
    @XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
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