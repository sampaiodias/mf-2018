/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula7.dto;

import com.github.sampaiodias.mf2018.aula7.adapters.LocalDateJsonDeserializer;
import com.github.sampaiodias.mf2018.aula7.adapters.LocalDateJsonSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.StringReader;
import java.io.StringWriter;
import java.time.LocalDate;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lucas Sampaio Dias
 */
@XmlRootElement(name = "certidao")
public class CertidaoDTO {
    
    private final static GsonBuilder GSON_BUILDER;
    static {
        GSON_BUILDER = new GsonBuilder();
        GSON_BUILDER.registerTypeAdapter(LocalDate.class,
                new LocalDateJsonSerializer());
        GSON_BUILDER.registerTypeAdapter(LocalDate.class,
                new LocalDateJsonDeserializer());
        GSON_BUILDER.setPrettyPrinting();
    }

    private Integer codigoTipo;
    private String cartorio;
    private Integer livro;
    private Integer folha;
    private Integer termo;
    
    public static CertidaoDTO fromJson(final String json) {
        final Gson gson = GSON_BUILDER.create();
        return gson.fromJson(json, CertidaoDTO.class);
    }

    public static CertidaoDTO fromXml(final String xml) throws JAXBException {
        final JAXBContext context = JAXBContext.newInstance(CertidaoDTO.class);
        final Unmarshaller um = context.createUnmarshaller();
        final StringReader sr = new StringReader(xml);
        return (CertidaoDTO) um.unmarshal(sr);
    }

    public String toJson() {
        final Gson gson = GSON_BUILDER.create();
        return gson.toJson(this);
    }

    public String toXml() throws JAXBException {
        final JAXBContext context = JAXBContext.newInstance(CertidaoDTO.class);
        final Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        final StringWriter sw = new StringWriter();
        m.marshal(this, sw);
        return sw.toString();
    }
    
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
