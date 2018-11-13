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
@XmlRootElement(name = "ctps")
public class CtpsDTO {
    
    private final static GsonBuilder GSON_BUILDER;
    static {
        GSON_BUILDER = new GsonBuilder();
        GSON_BUILDER.registerTypeAdapter(LocalDate.class,
                new LocalDateJsonSerializer());
        GSON_BUILDER.registerTypeAdapter(LocalDate.class,
                new LocalDateJsonDeserializer());
        GSON_BUILDER.setPrettyPrinting();
    }

    private Integer serie;
    private String codigoEstado;
    
    public static CtpsDTO fromJson(final String json) {
        final Gson gson = GSON_BUILDER.create();
        return gson.fromJson(json, CtpsDTO.class);
    }

    public static CtpsDTO fromXml(final String xml) throws JAXBException {
        final JAXBContext context = JAXBContext.newInstance(CtpsDTO.class);
        final Unmarshaller um = context.createUnmarshaller();
        final StringReader sr = new StringReader(xml);
        return (CtpsDTO) um.unmarshal(sr);
    }

    public String toJson() {
        final Gson gson = GSON_BUILDER.create();
        return gson.toJson(this);
    }

    public String toXml() throws JAXBException {
        final JAXBContext context = JAXBContext.newInstance(CtpsDTO.class);
        final Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        final StringWriter sw = new StringWriter();
        m.marshal(this, sw);
        return sw.toString();
    }

    public final String getCodigoEstado() {
        return codigoEstado;
    }

    public final Integer getSerie() {
        return serie;
    }

    public final void setCodigoEstado(final String codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public final void setSerie(final Integer serie) {
        this.serie = serie;
    }
}
