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
public class RepresentacaoDTO {

    private String utilizacao;
    private String alternativa;

    public final String getAlternativa() {
        return alternativa;
    }

    public final String getUtilizacao() {
        return utilizacao;
    }

    public final void setAlternativa(final String newAlternativa) {
        alternativa = newAlternativa;
    }

    public final void setUtilizacao(final String newUtilizacao) {
        utilizacao = newUtilizacao;
    }
}