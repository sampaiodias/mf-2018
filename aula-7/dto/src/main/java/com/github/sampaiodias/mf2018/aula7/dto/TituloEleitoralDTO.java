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
@XmlRootElement(name = "tituloeleitoral")
public class TituloEleitoralDTO {

    private Integer zona;
    private Integer sessao;
    
    public final Integer getSessao() {
        return sessao;
    }

    public final Integer getZona() {
        return zona;
    }

    public final void setSessao(final Integer sessao) {
        this.sessao = sessao;
    }

    public final void setZona(final Integer zona) {
        this.zona = zona;
    }
}