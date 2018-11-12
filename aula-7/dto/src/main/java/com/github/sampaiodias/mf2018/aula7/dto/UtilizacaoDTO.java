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
public class UtilizacaoDTO {

    private Integer idIdentificador;
    private Integer codigoUso;
    @XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
    private LocalDate dataInicial;
    @XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
    private LocalDate dataFinal;
    
    public final Integer getCodigoUso() {
        return codigoUso;
    }

    public final LocalDate getDataFinal() {
        return dataFinal;
    }

    public final LocalDate getDataInicial() {
        return dataInicial;
    }

    public final Integer getIdIdentificador() {
        return idIdentificador;
    }

    public final void setCodigoUso(final Integer newUso) {
        codigoUso = newUso;
    }

    public final void setDataFinal(final LocalDate newDataFinal) {
        dataFinal = newDataFinal;
    }

    public final void setDataInicial(final LocalDate newDataInicial) {
        dataInicial = newDataInicial;
    }

    public final void setIdIdentificador(final Integer newIdIdentificador) {
        idIdentificador = newIdIdentificador;
    }
}