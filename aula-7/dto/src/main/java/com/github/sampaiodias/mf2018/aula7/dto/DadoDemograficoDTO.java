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
            final Integer newCodigoNascimentoOrdem) {
        codigoNascimentoOrdem = newCodigoNascimentoOrdem;
    }

    public final void setCodigoNascimentoPluraridade(
            final Integer newCodigoNascimentoPluraridade) {
        codigoNascimentoPluraridade = newCodigoNascimentoPluraridade;
    }

    public final void setCodigoNascimentoSeguimento(
            final String newCodigoNascimentoSeguimento) {
        codigoNascimentoSeguimento = newCodigoNascimentoSeguimento;
    }

    public final void setCodigoObitoFonte(
            final Integer newCodigoObitoFonte) {
        codigoObitoFonte = newCodigoObitoFonte;
    }

    public final void setCodigoRaca(final Integer newCodigoRaca) {
        codigoRaca = newCodigoRaca;
    }

    public final void setCodigoSexo(final Integer newCodigoSexo) {
        codigoSexo = newCodigoSexo;
    }

    public final void setCodigoSituacaoFamiliar(
            final Integer newCodigoSituacaoFamiliar) {
        codigoSituacaoFamiliar = newCodigoSituacaoFamiliar;
    }

    public final void setComentario(final String newComentario) {
        comentario = newComentario;
    }

    public final void setMae(final String newMae) {
        mae = newMae;
    }

    public final void setNacionalidade(
            final NacionalidadeDTO newNacionalidade) {
        nacionalidade = newNacionalidade;
    }

    public final void setNascimento(
            final DataComAcuraciaDTO newNascimento) {
        nascimento = newNascimento;
    }

    public final void setObito(final DataComAcuraciaDTO newObito) {
        obito = newObito;
    }

    public final void setPai(final String newPai) {
        pai = newPai;
    }
}