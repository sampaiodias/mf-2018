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

    public final void setBairro(final String bairro) {
        this.bairro = bairro;
    }

    public final void setCaixaPostal(final String caixaPostal) {
        this.caixaPostal = caixaPostal;
    }

    public final void setCep(final String cep) {
        this.cep = cep;
    }

    public final void setCodigoEstado(final String codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public final void setCodigoMunicipio(final Integer codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public final void setCodigoPais(final Integer codigoPais) {
        this.codigoPais = codigoPais;
    }

    public final void setCodigoTipo(final Integer codigoTipo) {
        this.codigoTipo = codigoTipo;
    }

    public final void setDataFim(final DataComAcuraciaDTO dataFim) {
        this.dataFim = dataFim;
    }

    public final void setDataInicio(
            final DataComAcuraciaDTO dataInicio) {
        this.dataInicio = dataInicio;
    }

    public final void setDistrito(final String distrito) {
        this.distrito = distrito;
    }

    public final void setId(final Integer Id) {
        this.id = Id;
    }

    public final void setLinhas(final List<EnderecoLinhaDTO> linhas) {
        this.linhas = linhas;
    }
}