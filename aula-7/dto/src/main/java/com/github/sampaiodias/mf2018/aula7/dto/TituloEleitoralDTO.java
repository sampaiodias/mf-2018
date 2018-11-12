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
public class TituloEleitoralDTO {

    private Integer zona;
    private Integer sessao;
    
    public final Integer getSessao() {
        return sessao;
    }

    public final Integer getZona() {
        return zona;
    }

    public final void setSessao(final Integer newSessao) {
        sessao = newSessao;
    }

    public final void setZona(final Integer newZona) {
        zona = newZona;
    }
}