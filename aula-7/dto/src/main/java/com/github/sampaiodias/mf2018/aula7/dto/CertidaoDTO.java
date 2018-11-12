/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    public final void setCartorio(final String newCartorio) {
        cartorio = newCartorio;
    }

    public final void setCodigoTipo(final Integer newCodigoTipo) {
        codigoTipo = newCodigoTipo;
    }

    public final void setFolha(final Integer newFolha) {
        folha = newFolha;
    }

    public final void setLivro(final Integer newLivro) {
        livro = newLivro;
    }

    public final void setTermo(final Integer newTermo) {
        termo = newTermo;
    }
}
