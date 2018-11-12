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
public class UtilizacaoDTO {

    private Integer idIdentificador;
    private Integer codigoUso;
    private LocalDate dataInicial;
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