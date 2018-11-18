/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula7.dto;

import com.github.sampaiodias.mf2018.aula7.adapters.LocalDateJsonDeserializer;
import com.github.sampaiodias.mf2018.aula7.adapters.LocalDateJsonSerializer;
import com.github.sampaiodias.mf2018.aula7.adapters.LocalDateXmlAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.StringReader;
import java.io.StringWriter;
import java.time.LocalDate;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Lucas Sampaio Dias
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "identificador")
public class IdentificadorDTO {
    
    private final static GsonBuilder GSON_BUILDER;
    static {
        GSON_BUILDER = new GsonBuilder();
        GSON_BUILDER.registerTypeAdapter(LocalDate.class,
                new LocalDateJsonSerializer());
        GSON_BUILDER.registerTypeAdapter(LocalDate.class,
                new LocalDateJsonDeserializer());
        GSON_BUILDER.setPrettyPrinting();
    }

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
    
    public static IdentificadorDTO fromJson(final String json) {
        final Gson gson = GSON_BUILDER.create();
        return gson.fromJson(json, IdentificadorDTO.class);
    }

    public static IdentificadorDTO fromXml(final String xml) 
            throws JAXBException {
        final JAXBContext context = JAXBContext.newInstance(IdentificadorDTO.class);
        final Unmarshaller um = context.createUnmarshaller();
        final StringReader sr = new StringReader(xml);
        return (IdentificadorDTO) um.unmarshal(sr);
    }

    public String toJson() {
        final Gson gson = GSON_BUILDER.create();
        return gson.toJson(this);
    }

    public String toXml() throws JAXBException {
        final JAXBContext context = 
                JAXBContext.newInstance(IdentificadorDTO.class);
        final Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        final StringWriter sw = new StringWriter();
        m.marshal(this, sw);
        return sw.toString();
    }
    
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

    public final void setCertidao(final CertidaoDTO certidao) {
        this.certidao = certidao;
    }

    public final void setCodigoArea(final Integer codigoArea) {
        this.codigoArea = codigoArea;
    }

    public final void setCodigoTipo(final String codigoTipo) {
        this.codigoTipo = codigoTipo;
    }

    public final void setCtps(final CtpsDTO ctps) {
        this.ctps = ctps;
    }

    public final void setData(final LocalDate data) {
        this.data = data;
    }

    public final void setDesignacao(final String designacao) {
        this.designacao = designacao;
    }

    public final void setEmissor(final String emissor) {
        this.emissor = emissor;
    }

    public final void setId(final Integer Id) {
        this.id = Id;
    }

    public final void setIdIndividuo(final Integer idIndividuo) {
        this.idIndividuo = idIndividuo;
    }

    public final void setTituloEleitoral(
            final TituloEleitoralDTO tituloEleitoral) {
        this.tituloEleitoral = tituloEleitoral;
    }
}