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
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lucas Sampaio Dias
 */
@XmlRootElement(name = "tituloeleitoral")
public class TituloEleitoralDTO {
    
    private final static GsonBuilder GSON_BUILDER;
    static {
        GSON_BUILDER = new GsonBuilder();
        GSON_BUILDER.registerTypeAdapter(LocalDate.class,
                new LocalDateJsonSerializer());
        GSON_BUILDER.registerTypeAdapter(LocalDate.class,
                new LocalDateJsonDeserializer());
        GSON_BUILDER.setPrettyPrinting();
    }

    private Integer zona;
    private Integer sessao;
    
    public static TituloEleitoralDTO fromJson(final String json) {
        final Gson gson = GSON_BUILDER.create();
        return gson.fromJson(json, TituloEleitoralDTO.class);
    }

    public static TituloEleitoralDTO fromXml(final String xml) 
            throws JAXBException {
        final JAXBContext context = 
                JAXBContext.newInstance(TituloEleitoralDTO.class);
        final Unmarshaller um = context.createUnmarshaller();
        final StringReader sr = new StringReader(xml);
        return (TituloEleitoralDTO) um.unmarshal(sr);
    }

    public String toJson() {
        final Gson gson = GSON_BUILDER.create();
        return gson.toJson(this);
    }

    public String toXml() throws JAXBException {
        final JAXBContext context = 
                JAXBContext.newInstance(TituloEleitoralDTO.class);
        final Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        final StringWriter sw = new StringWriter();
        m.marshal(this, sw);
        return sw.toString();
    }
    
    public final Integer getSessao() {
        return sessao;
    }

    public final Integer getZona() {
        return zona;
    }

    public final void setSessao(final Integer sessao) {
        this.sessao = sessao;
    }

    public final void setZona(final Integer zona) {
        this.zona = zona;
    }
}