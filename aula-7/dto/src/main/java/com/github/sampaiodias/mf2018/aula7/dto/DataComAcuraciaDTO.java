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
public class DataComAcuraciaDTO {

    /**
     * Data estimada do acontecimento.
     */
    private LocalDate data;

    /**
     * Acurácia da data estimada.
     */
    private String acuracia;

    /**
     * Obtém o valor atual de acuracia.
     *
     * @return O valor atual de acuracia.
     */
    public final String getAcuracia() {
        return acuracia;
    }

    /**
     * Obtém o valor atual de data.
     *
     * @return O valor atual de data.
     */
    public final LocalDate getData() {
        return data;
    }

    /**
     * Atualiza o valor atual de acuracia.
     *
     * @param newAcuracia O novo valor para acuracia.
     */
    public final void setAcuracia(final String newAcuracia) {
        acuracia = newAcuracia;
    }

    /**
     * Atualiza o valor atual de data.
     *
     * @param newData O novo valor para data.
     */
    public final void setData(final LocalDate newData) {
        data = newData;
    }
}
