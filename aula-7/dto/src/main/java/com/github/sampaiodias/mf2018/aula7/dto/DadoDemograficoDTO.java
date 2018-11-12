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
public class DadoDemograficoDTO {

    private Integer codigoSexo;
    private Integer codigoRaca;
    private NacionalidadeDTO nacionalidade;
    private String mae;
    private String pai;
    private Integer codigoSituacaoFamiliar;
    private DataComAcuraciaDTO nascimento;
    private Integer codigoNascimentoPluraridade;
    private Integer codigoNascimentoOrdem;
    private String codigoNascimentoSeguimento;
    private DataComAcuraciaDTO obito;
    private Integer codigoObitoFonte;
    private String comentario;
    
    public final Integer getCodigoNascimentoOrdem() {
        return codigoNascimentoOrdem;
    }

    public final Integer getCodigoNascimentoPluraridade() {
        return codigoNascimentoPluraridade;
    }

    public final String getCodigoNascimentoSeguimento() {
        return codigoNascimentoSeguimento;
    }

    public final Integer getCodigoObitoFonte() {
        return codigoObitoFonte;
    }

    public final Integer getCodigoRaca() {
        return codigoRaca;
    }

    public final Integer getCodigoSexo() {
        return codigoSexo;
    }

    public final Integer getCodigoSituacaoFamiliar() {
        return codigoSituacaoFamiliar;
    }

    public final String getComentario() {
        return comentario;
    }

    public final String getMae() {
        return mae;
    }

    public final NacionalidadeDTO getNacionalidade() {
        return nacionalidade;
    }

    public final DataComAcuraciaDTO getNascimento() {
        return nascimento;
    }

    public final DataComAcuraciaDTO getObito() {
        return obito;
    }

    public final String getPai() {
        return pai;
    }

    public final void setCodigoNascimentoOrdem(
            final Integer codigoNascimentoOrdem) {
        this.codigoNascimentoOrdem = codigoNascimentoOrdem;
    }

    public final void setCodigoNascimentoPluraridade(
            final Integer codigoNascimentoPluraridade) {
        this.codigoNascimentoPluraridade = codigoNascimentoPluraridade;
    }

    public final void setCodigoNascimentoSeguimento(
            final String codigoNascimentoSeguimento) {
        this.codigoNascimentoSeguimento = codigoNascimentoSeguimento;
    }

    public final void setCodigoObitoFonte(
            final Integer codigoObitoFonte) {
        this.codigoObitoFonte = codigoObitoFonte;
    }

    public final void setCodigoRaca(final Integer codigoRaca) {
        this.codigoRaca = codigoRaca;
    }

    public final void setCodigoSexo(final Integer codigoSexo) {
        this.codigoSexo = codigoSexo;
    }

    public final void setCodigoSituacaoFamiliar(
            final Integer codigoSituacaoFamiliar) {
        this.codigoSituacaoFamiliar = codigoSituacaoFamiliar;
    }

    public final void setComentario(final String comentario) {
        this.comentario = comentario;
    }

    public final void setMae(final String mae) {
        this.mae = mae;
    }

    public final void setNacionalidade(
            final NacionalidadeDTO nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public final void setNascimento(
            final DataComAcuraciaDTO nascimento) {
        this.nascimento = nascimento;
    }

    public final void setObito(final DataComAcuraciaDTO obito) {
        this.obito = obito;
    }

    public final void setPai(final String pai) {
        this.pai = pai;
    }
}