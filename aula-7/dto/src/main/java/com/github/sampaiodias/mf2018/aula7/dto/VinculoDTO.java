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
public class VinculoDTO {

    private Integer idIdentificador;
    private String relacionamento;
    @XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
    private LocalDate dataInicio;
    @XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
    private LocalDate dataFim;

    public final LocalDate getDataFim() {
        return dataFim;
    }

    public final LocalDate getDataInicio() {
        return dataInicio;
    }

    public final Integer getIdIdentificador() {
        return idIdentificador;
    }

    public final String getRelacionamento() {
        return relacionamento;
    }

    public final void setDataFim(final LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public final void setDataInicio(final LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public final void setIdIdentificador(final Integer idIdentificador) {
        this.idIdentificador = idIdentificador;
    }

    public final void setRelacionamento(final String relacionamento) {
        this.relacionamento = relacionamento;
    }
}