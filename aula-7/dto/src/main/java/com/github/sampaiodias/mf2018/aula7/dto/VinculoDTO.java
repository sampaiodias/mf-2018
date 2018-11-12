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
public class VinculoDTO {

    private Integer idIdentificador;
    private String relacionamento;
    private LocalDate dataInicio;
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

    public final void setDataFim(final LocalDate newDataFim) {
        dataFim = newDataFim;
    }

    public final void setDataInicio(final LocalDate newDataInicio) {
        dataInicio = newDataInicio;
    }

    public final void setIdIdentificador(final Integer newIdIdentificador) {
        idIdentificador = newIdIdentificador;
    }

    public final void setRelacionamento(final String newRelacionamento) {
        relacionamento = newRelacionamento;
    }
}