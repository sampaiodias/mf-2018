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
@XmlRootElement(name = "vinculo")
public class VinculoDTO {
    
    private final static GsonBuilder GSON_BUILDER;
    static {
        GSON_BUILDER = new GsonBuilder();
        GSON_BUILDER.registerTypeAdapter(LocalDate.class,
                new LocalDateJsonSerializer());
        GSON_BUILDER.registerTypeAdapter(LocalDate.class,
                new LocalDateJsonDeserializer());
        GSON_BUILDER.setPrettyPrinting();
    }

    private Integer idIdentificador;
    private String relacionamento;
    @XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
    private LocalDate dataInicio;
    @XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
    private LocalDate dataFim;
    
    public static VinculoDTO fromJson(final String json) {
        final Gson gson = GSON_BUILDER.create();
        return gson.fromJson(json, VinculoDTO.class);
    }

    public static VinculoDTO fromXml(final String xml) throws JAXBException {
        final JAXBContext context = JAXBContext.newInstance(VinculoDTO.class);
        final Unmarshaller um = context.createUnmarshaller();
        final StringReader sr = new StringReader(xml);
        return (VinculoDTO) um.unmarshal(sr);
    }

    public String toJson() {
        final Gson gson = GSON_BUILDER.create();
        return gson.toJson(this);
    }

    public String toXml() throws JAXBException {
        final JAXBContext context = JAXBContext.newInstance(VinculoDTO.class);
        final Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        final StringWriter sw = new StringWriter();
        m.marshal(this, sw);
        return sw.toString();
    }

    public final LocalDate getDataFim() {
        return dataFim;
    }

    public final LocalDate getDataInicio() {
        return dataInicio;
    }

    public final Integer getIdIdentificador() {
        return idIdentificador;
    }

    public final String getRelacionamento() {
        return relacionamento;
    }

    public final void setDataFim(final LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public final void setDataInicio(final LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public final void setIdIdentificador(final Integer idIdentificador) {
        this.idIdentificador = idIdentificador;
    }

    public final void setRelacionamento(final String relacionamento) {
        this.relacionamento = relacionamento;
    }
}