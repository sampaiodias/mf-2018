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
public class Nome {

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

    public final void setCodigoPreferido(final Integer newCodigoPreferido) {
        codigoPreferido = newCodigoPreferido;
    }

    public final void setCodigoUsoCondicional(
            final Integer newCodigoUsoCondicional) {
        codigoUsoCondicional = newCodigoUsoCondicional;
    }

    public final void setId(final Integer newId) {
        id = newId;
    }

    public final void setNomes(final String newNomes) {
        nomes = newNomes;
    }

    public final void setRepresentacoes
        (final List<RepresentacaoDTO> newRepresentacoes) {
        representacoes = newRepresentacoes;
    }

    public final void setSobrenomes(final String newSobrenomes) {
        sobrenomes = newSobrenomes;
    }

    public final void setSufixos(final String newSufixos) {
        sufixos = newSufixos;
    }

    public final void setTitulos(final String newTitulos) {
        titulos = newTitulos;
    }

    public final void setUtilizacoes(
            final List<UtilizacaoDTO> newUtilizacoes) {
        utilizacoes = newUtilizacoes;
    }
}