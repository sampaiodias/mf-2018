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
public class CertidaoDTO {

    private Integer codigoTipo;
    private String cartorio;
    private Integer livro;
    private Integer folha;
    private Integer termo;
    
    public final String getCartorio() {
        return cartorio;
    }

    public final Integer getCodigoTipo() {
        return codigoTipo;
    }

    public final Integer getFolha() {
        return folha;
    }

    public final Integer getLivro() {
        return livro;
    }

    public final Integer getTermo() {
        return termo;
    }

    public final void setCartorio(final String cartorio) {
        this.cartorio = cartorio;
    }

    public final void setCodigoTipo(final Integer newCodigoTipo) {
        this.codigoTipo = newCodigoTipo;
    }

    public final void setFolha(final Integer folha) {
        this.folha = folha;
    }

    public final void setLivro(final Integer livro) {
        this.livro = livro;
    }

    public final void setTermo(final Integer termo) {
        this.termo = termo;
    }
}
