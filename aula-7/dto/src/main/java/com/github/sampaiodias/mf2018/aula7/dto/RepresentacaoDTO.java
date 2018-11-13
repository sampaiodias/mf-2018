/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula7.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lucas Sampaio Dias
 */
@XmlRootElement(name = "representacao")
public class RepresentacaoDTO {

    private String utilizacao;
    private String alternativa;

    public final String getAlternativa() {
        return alternativa;
    }

    public final String getUtilizacao() {
        return utilizacao;
    }

    public final void setAlternativa(final String alternativa) {
        this.alternativa = alternativa;
    }

    public final void setUtilizacao(final String utilizacao) {
        this.utilizacao = utilizacao;
    }
}