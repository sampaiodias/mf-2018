/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula7.dto;

import com.github.sampaiodias.mf2018.aula7.LocalDateXmlAdapter;
import java.time.LocalDate;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Lucas Sampaio Dias
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class IdentificadorDTO {

    private Integer id;
    private Integer idIndividuo;
    private String designacao;
    private Integer codigoArea;
    private String emissor;
    @XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
    private LocalDate data;
    private String codigoTipo;
    private CtpsDTO ctps;
    private CertidaoDTO certidao;
    private TituloEleitoralDTO tituloEleitoral;
    
    public final CertidaoDTO getCertidao() {
        return certidao;
    }

    public final Integer getCodigoArea() {
        return codigoArea;
    }

    public final String getCodigoTipo() {
        return codigoTipo;
    }

    public final CtpsDTO getCtps() {
        return ctps;
    }

    public final LocalDate getData() {
        return data;
    }

    public final String getDesignacao() {
        return designacao;
    }

    public final String getEmissor() {
        return emissor;
    }

    public final Integer getId() {
        return id;
    }

    public final Integer getIdIndividuo() {
        return idIndividuo;
    }

    public final TituloEleitoralDTO getTituloEleitoral() {
        return tituloEleitoral;
    }

    public final void setCertidao(final CertidaoDTO newCertidao) {
        certidao = newCertidao;
    }

    public final void setCodigoArea(final Integer newCodigoArea) {
        codigoArea = newCodigoArea;
    }

    public final void setCodigoTipo(final String newCodigoTipo) {
        codigoTipo = newCodigoTipo;
    }

    public final void setCtps(final CtpsDTO newCtps) {
        ctps = newCtps;
    }

    public final void setData(final LocalDate newData) {
        data = newData;
    }

    public final void setDesignacao(final String newDesignacao) {
        designacao = newDesignacao;
    }

    public final void setEmissor(final String newEmissor) {
        emissor = newEmissor;
    }

    public final void setId(final Integer newId) {
        id = newId;
    }

    public final void setIdIndividuo(final Integer newIdIndividuo) {
        idIndividuo = newIdIndividuo;
    }

    public final void setTituloEleitoral(
            final TituloEleitoralDTO newTituloEleitoral) {
        tituloEleitoral = newTituloEleitoral;
    }
}