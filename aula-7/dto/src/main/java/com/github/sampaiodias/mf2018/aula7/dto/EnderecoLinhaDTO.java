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
@XmlRootElement(name = "enderecolinha")
public class EnderecoLinhaDTO {

    private String linha;
    private Integer ordem;
    
    public final String getLinha() {
        return linha;
    }
    
    public final Integer getOrdem() {
        return ordem;
    }
    
    public final void setLinha(final String linha) {
        this.linha = linha;
    }

    public final void setOrdem(final Integer ordem) {
        this.ordem = ordem;
    }
}