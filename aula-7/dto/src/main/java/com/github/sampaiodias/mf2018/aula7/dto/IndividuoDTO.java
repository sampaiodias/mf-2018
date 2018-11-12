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
public class IndividuoDTO {

    private Long id;
    private List<Nome> nomes;
    private List<IdentificadorDTO> identificadores;
    private List<VinculoDTO> vinculos;
    private List<EnderecoDTO> enderecos;
    private DadoDemograficoDTO dadoDemografico;
    private List<Comunicacao> comunicacoes;

    public final List<Comunicacao> getComunicacoes() {
        return comunicacoes;
    }

    public final DadoDemograficoDTO getDadoDemografico() {
        return dadoDemografico;
    }

    public final List<EnderecoDTO> getEnderecos() {
        return enderecos;
    }

    public final Long getId() {
        return id;
    }

    public final List<IdentificadorDTO> getIdentificadores() {
        return identificadores;
    }

    public final List<Nome> getNomes() {
        return nomes;
    }

    public final List<VinculoDTO> getVinculos() {
        return vinculos;
    }

    public final void setComunicacoes(final List<Comunicacao> newComunicacoes) {
        comunicacoes = newComunicacoes;
    }

    public final void setDadoDemografico(
            final DadoDemograficoDTO newDadoDemografico) {
        dadoDemografico = newDadoDemografico;
    }

    public final void setEnderecos(final List<EnderecoDTO> newEnderecos) {
        enderecos = newEnderecos;
    }

    public final void setId(final Long newId) {
        id = newId;
    }

    public final void setIdentificadores(
            final List<IdentificadorDTO> newIdentificadores) {
        identificadores = newIdentificadores;
    }

    public final void setNomes(final List<Nome> newNomes) {
        nomes = newNomes;
    }

    public final void setVinculos(final List<VinculoDTO> newVinculos) {
        vinculos = newVinculos;
    }
}