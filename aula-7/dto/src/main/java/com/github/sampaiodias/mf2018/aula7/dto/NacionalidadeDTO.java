/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula7.dto;

import com.github.sampaiodias.mf2018.aula7.LocalDateJsonDeserializer;
import com.github.sampaiodias.mf2018.aula7.LocalDateJsonSerializer;
import com.github.sampaiodias.mf2018.aula7.LocalDateXmlAdapter;
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
@XmlRootElement(name = "nacionalidade")
public class NacionalidadeDTO {
    
    private final static GsonBuilder GSON_BUILDER;
    static {
        GSON_BUILDER = new GsonBuilder();
        GSON_BUILDER.registerTypeAdapter(LocalDate.class,
                new LocalDateJsonSerializer());
        GSON_BUILDER.registerTypeAdapter(LocalDate.class,
                new LocalDateJsonDeserializer());
        GSON_BUILDER.setPrettyPrinting();
    }

    private Integer codigoMunicipio;
    private String codigoEstado;
    private Integer codigoPais;
    @XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
    private LocalDate dataEntradaPais;
    
    public static NacionalidadeDTO fromJson(final String json) {
        final Gson gson = GSON_BUILDER.create();
        return gson.fromJson(json, NacionalidadeDTO.class);
    }

    public static NacionalidadeDTO fromXml(final String xml) 
            throws JAXBException {
        final JAXBContext context = 
                JAXBContext.newInstance(NacionalidadeDTO.class);
        final Unmarshaller um = context.createUnmarshaller();
        final StringReader sr = new StringReader(xml);
        return (NacionalidadeDTO) um.unmarshal(sr);
    }

    public String toJson() {
        final Gson gson = GSON_BUILDER.create();
        return gson.toJson(this);
    }

    public String toXml() throws JAXBException {
        final JAXBContext context = 
                JAXBContext.newInstance(NacionalidadeDTO.class);
        final Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        final StringWriter sw = new StringWriter();
        m.marshal(this, sw);
        return sw.toString();
    }
    
    public final Integer getCodigoMunicipio() {
        return codigoMunicipio;
    }
    
    public final String getCodigoEstado() {
        return codigoEstado;
    }

    public final Integer getCodigoPais() {
        return codigoPais;
    }

    public final LocalDate getDataEntradaPais() {
        return dataEntradaPais;
    }

    public final void setCodigoMunicipio(final Integer codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }
    
    public final void setCodigoEstado(final String codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public final void setCodigoPais(final Integer codigoPais) {
        this.codigoPais = codigoPais;
    }

    public final void setDataEntradaPais(
            final LocalDate dataEntradaPais) {
        this.dataEntradaPais = dataEntradaPais;
    }
}