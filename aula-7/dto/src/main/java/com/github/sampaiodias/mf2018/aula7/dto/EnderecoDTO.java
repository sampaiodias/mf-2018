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
public class EnderecoDTO {

    private Integer id;
    private String bairro;
    private String distrito;
    private String cep;
    private String caixaPostal;
    private Integer codigoMunicipio;
    private String codigoEstado;
    private Integer codigoPais;
    private Integer codigoTipo;
    private DataComAcuraciaDTO dataInicio;
    private DataComAcuraciaDTO dataFim;
    private List<EnderecoLinhaDTO> linhas;

    public final String getBairro() {
        return bairro;
    }

    public final String getCaixaPostal() {
        return caixaPostal;
    }

    public final String getCep() {
        return cep;
    }

    public final String getCodigoEstado() {
        return codigoEstado;
    }

    public final Integer getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public final Integer getCodigoPais() {
        return codigoPais;
    }

    public final Integer getCodigoTipo() {
        return codigoTipo;
    }

    public final DataComAcuraciaDTO getDataFim() {
        return dataFim;
    }

    public final DataComAcuraciaDTO getDataInicio() {
        return dataInicio;
    }

    public final String getDistrito() {
        return distrito;
    }

    public final Integer getId() {
        return id;
    }

    public final List<EnderecoLinhaDTO> getLinhas() {
        return linhas;
    }

    public final void setBairro(final String newBairro) {
        bairro = newBairro;
    }

    public final void setCaixaPostal(final String newCaixaPostal) {
        caixaPostal = newCaixaPostal;
    }

    public final void setCep(final String newCep) {
        cep = newCep;
    }

    public final void setCodigoEstado(final String newCodigoEstado) {
        codigoEstado = newCodigoEstado;
    }

    public final void setCodigoMunicipio(final Integer newCodigoMunicipio) {
        codigoMunicipio = newCodigoMunicipio;
    }

    public final void setCodigoPais(final Integer newCódigoPais) {
        codigoPais = newCódigoPais;
    }

    public final void setCodigoTipo(final Integer newCodigoTipo) {
        codigoTipo = newCodigoTipo;
    }

    public final void setDataFim(final DataComAcuraciaDTO newDataFim) {
        dataFim = newDataFim;
    }

    public final void setDataInicio(
            final DataComAcuraciaDTO newDataInicio) {
        dataInicio = newDataInicio;
    }

    public final void setDistrito(final String newDistrito) {
        distrito = newDistrito;
    }

    public final void setId(final Integer newId) {
        id = newId;
    }

    public final void setLinhas(final List<EnderecoLinhaDTO> newLinhas) {
        linhas = newLinhas;
    }
}