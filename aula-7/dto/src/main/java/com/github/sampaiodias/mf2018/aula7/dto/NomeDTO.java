/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula7.dto;

import java.util.List;

/**
 *
 * @author Lucas Sampaio Dias
 */
public class NomeDTO {

    private Integer id;
    private String titulos;
    private String nomes;
    private String sobrenomes;
    private String sufixos;
    private Integer codigoPreferido;
    private Integer codigoUsoCondicional;
    private List<UtilizacaoDTO> utilizacoes;
    private List<RepresentacaoDTO> representacoes;
    
    public final Integer getCodigoPreferido() {
        return codigoPreferido;
    }
    
    public final Integer getCodigoUsoCondicional() {
        return codigoUsoCondicional;
    }

    public final Integer getId() {
        return id;
    }

    public final String getNomes() {
        return nomes;
    }

    public final List<RepresentacaoDTO> getRepresentacoes() {
        return representacoes;
    }

    public final String getSobrenomes() {
        return sobrenomes;
    }

    public final String getSufixos() {
        return sufixos;
    }

    public final String getTitulos() {
        return titulos;
    }

    public final List<UtilizacaoDTO> getUtilizacoes() {
        return utilizacoes;
    }

    public final void setCodigoPreferido(final Integer codigoPreferido) {
        this.codigoPreferido = codigoPreferido;
    }

    public final void setCodigoUsoCondicional(
            final Integer codigoUsoCondicional) {
        this.codigoUsoCondicional = codigoUsoCondicional;
    }

    public final void setId(final Integer id) {
        this.id = id;
    }

    public final void setNomes(final String nomes) {
        this.nomes = nomes;
    }

    public final void setSobrenomes(final String sobrenomes) {
        this.sobrenomes = sobrenomes;
    }

    public final void setSufixos(final String sufixos) {
        this.sufixos = sufixos;
    }

    public final void setTitulos(final String titulos) {
        this.titulos = titulos;
    }

    public final void setUtilizacoes(
            final List<UtilizacaoDTO> utilizacoes) {
        this.utilizacoes = utilizacoes;
    }
    
    public final void setRepresentacoes
        (final List<RepresentacaoDTO> representacoes) {
        this.representacoes = representacoes;
    }
}