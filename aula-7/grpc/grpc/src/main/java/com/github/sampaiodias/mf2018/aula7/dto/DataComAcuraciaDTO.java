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
@XmlRootElement(name = "datacomacuracia")
public class DataComAcuraciaDTO {
    
    private final static GsonBuilder GSON_BUILDER;
    static {
        GSON_BUILDER = new GsonBuilder();
        GSON_BUILDER.registerTypeAdapter(LocalDate.class,
                new LocalDateJsonSerializer());
        GSON_BUILDER.registerTypeAdapter(LocalDate.class,
                new LocalDateJsonDeserializer());
        GSON_BUILDER.setPrettyPrinting();
    }

    @XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
    private LocalDate data;
    private String acuracia;
    
    public static DataComAcuraciaDTO fromJson(final String json) {
        final Gson gson = GSON_BUILDER.create();
        return gson.fromJson(json, DataComAcuraciaDTO.class);
    }

    public static DataComAcuraciaDTO fromXml(final String xml) 
            throws JAXBException {
        final JAXBContext context = 
                JAXBContext.newInstance(DataComAcuraciaDTO.class);
        final Unmarshaller um = context.createUnmarshaller();
        final StringReader sr = new StringReader(xml);
        return (DataComAcuraciaDTO) um.unmarshal(sr);
    }

    public String toJson() {
        final Gson gson = GSON_BUILDER.create();
        return gson.toJson(this);
    }

    public String toXml() throws JAXBException {
        final JAXBContext context = 
                JAXBContext.newInstance(DataComAcuraciaDTO.class);
        final Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        final StringWriter sw = new StringWriter();
        m.marshal(this, sw);
        return sw.toString();
    }

    public final String getAcuracia() {
        return acuracia;
    }

    public final LocalDate getData() {
        return data;
    }

    public final void setAcuracia(final String acuracia) {
        this.acuracia = acuracia;
    }

    public final void setData(final LocalDate data) {
        this.data = data;
    }
}
