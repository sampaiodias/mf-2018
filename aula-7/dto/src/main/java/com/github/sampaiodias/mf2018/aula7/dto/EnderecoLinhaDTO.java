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
public class EnderecoLinhaDTO {

    private String linha;
    private Integer ordem;
    
    public final String getLinha() {
        return linha;
    }
    
    public final Integer getOrdem() {
        return ordem;
    }
    
    public final void setLinha(final String newLinha) {
        linha = newLinha;
    }

    public final void setOrdem(final Integer newOrdem) {
        ordem = newOrdem;
    }
}