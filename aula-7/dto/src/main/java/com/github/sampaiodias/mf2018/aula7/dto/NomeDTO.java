/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula7.dto;

import com.github.sampaiodias.mf2018.aula7.LocalDateJsonDeserializer;
import com.github.sampaiodias.mf2018.aula7.LocalDateJsonSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.StringReader;
import java.io.StringWriter;
import java.time.LocalDate;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lucas Sampaio Dias
 */
@XmlRootElement(name = "nome")
public class NomeDTO {
    
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
    private String titulos;
    private String nomes;
    private String sobrenomes;
    private String sufixos;
    private Integer codigoPreferido;
    private Integer codigoUsoCondicional;
    private List<UtilizacaoDTO> utilizacoes;
    private List<RepresentacaoDTO> representacoes;
    
    public static NomeDTO fromJson(final String json) {
        final Gson gson = GSON_BUILDER.create();
        return gson.fromJson(json, NomeDTO.class);
    }

    public static NomeDTO fromXml(final String xml) throws JAXBException {
        final JAXBContext context = JAXBContext.newInstance(NomeDTO.class);
        final Unmarshaller um = context.createUnmarshaller();
        final StringReader sr = new StringReader(xml);
        return (NomeDTO) um.unmarshal(sr);
    }

    public String toJson() {
        final Gson gson = GSON_BUILDER.create();
        return gson.toJson(this);
    }

    public String toXml() throws JAXBException {
        final JAXBContext context = JAXBContext.newInstance(NomeDTO.class);
        final Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        final StringWriter sw = new StringWriter();
        m.marshal(this, sw);
        return sw.toString();
    }
    
    public final Integer getCodigoPreferido() {
        return codigoPreferido;
    }
    
    public final Integer getCodigoUsoCondicional() {
        return codigoUsoCondicional;
    }

    public final Integer getId() {
        return id;
    }

    public final String getNomes() {
        return nomes;
    }

    public final List<RepresentacaoDTO> getRepresentacoes() {
        return representacoes;
    }

    public final String getSobrenomes() {
        return sobrenomes;
    }

    public final String getSufixos() {
        return sufixos;
    }

    public final String getTitulos() {
        return titulos;
    }

    public final List<UtilizacaoDTO> getUtilizacoes() {
        return utilizacoes;
    }

    public final void setCodigoPreferido(final Integer codigoPreferido) {
        this.codigoPreferido = codigoPreferido;
    }

    public final void setCodigoUsoCondicional(
            final Integer codigoUsoCondicional) {
        this.codigoUsoCondicional = codigoUsoCondicional;
    }

    public final void setId(final Integer id) {
        this.id = id;
    }

    public final void setNomes(final String nomes) {
        this.nomes = nomes;
    }

    public final void setSobrenomes(final String sobrenomes) {
        this.sobrenomes = sobrenomes;
    }

    public final void setSufixos(final String sufixos) {
        this.sufixos = sufixos;
    }

    public final void setTitulos(final String titulos) {
        this.titulos = titulos;
    }

    public final void setUtilizacoes(
            final List<UtilizacaoDTO> utilizacoes) {
        this.utilizacoes = utilizacoes;
    }
    
    public final void setRepresentacoes
        (final List<RepresentacaoDTO> representacoes) {
        this.representacoes = representacoes;
    }
}