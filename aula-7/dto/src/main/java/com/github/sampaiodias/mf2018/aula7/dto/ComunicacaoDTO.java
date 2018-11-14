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
@XmlRootElement(name = "comunicacao")
public class ComunicacaoDTO {
    
    private final static GsonBuilder GSON_BUILDER;
    static {
        GSON_BUILDER = new GsonBuilder();
        GSON_BUILDER.registerTypeAdapter(LocalDate.class,
                new LocalDateJsonSerializer());
        GSON_BUILDER.registerTypeAdapter(LocalDate.class,
                new LocalDateJsonDeserializer());
        GSON_BUILDER.setPrettyPrinting();
    }

    private Integer codigoMeio;
    private String codigoPreferencia;
    private Integer codigoUso;
    private String detalhe;
    
    public static ComunicacaoDTO fromJson(final String json) {
        final Gson gson = GSON_BUILDER.create();
        return gson.fromJson(json, ComunicacaoDTO.class);
    }

    public static ComunicacaoDTO fromXml(final String xml) throws JAXBException {
        final JAXBContext context = JAXBContext.newInstance(ComunicacaoDTO.class);
        final Unmarshaller um = context.createUnmarshaller();
        final StringReader sr = new StringReader(xml);
        return (ComunicacaoDTO) um.unmarshal(sr);
    }

    public String toJson() {
        final Gson gson = GSON_BUILDER.create();
        return gson.toJson(this);
    }

    public String toXml() throws JAXBException {
        final JAXBContext context = JAXBContext.newInstance(ComunicacaoDTO.class);
        final Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        final StringWriter sw = new StringWriter();
        m.marshal(this, sw);
        return sw.toString();
    }
    
    public final Integer getCodigoMeio() {
        return codigoMeio;
    }
    
    public final String getCodigoPreferencia() {
        return codigoPreferencia;
    }

    public final Integer getCodigoUso() {
        return codigoUso;
    }

    public final String getDetalhe() {
        return detalhe;
    }

    public final void setCodigoMeio(final Integer codigoMeio) {
        this.codigoMeio = codigoMeio;
    }

    public final void setCodigoPreferencia(final String codigoPreferencia) {
        this.codigoPreferencia = codigoPreferencia;
    }

    public final void setCodigoUso(final Integer codigoUso) {
        this.codigoUso = codigoUso;
    }

    public final void setDetalhe(final String detalhe) {
        this.detalhe = detalhe;
    }
}
