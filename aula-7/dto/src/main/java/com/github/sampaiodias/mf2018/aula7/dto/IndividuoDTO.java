/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula7.dto;

import com.github.sampaiodias.mf2018.aula7.LocalDateJsonDeserializer;
import com.github.sampaiodias.mf2018.aula7.LocalDateJsonSerializer;
import java.io.StringReader;
import java.io.StringWriter;
import java.time.LocalDate;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author Lucas Sampaio Dias
 */
@XmlRootElement(name = "individuo")
@XmlAccessorType(XmlAccessType.FIELD)
public class IndividuoDTO {

    private final static GsonBuilder GSON_BUILDER;
    static {
        GSON_BUILDER = new GsonBuilder();
        GSON_BUILDER.registerTypeAdapter(LocalDate.class,
                new LocalDateJsonSerializer());
        GSON_BUILDER.registerTypeAdapter(LocalDate.class,
                new LocalDateJsonDeserializer());
        GSON_BUILDER.setPrettyPrinting();
    }

    private Long id;
    private List<Nome> nomes;
    private List<IdentificadorDTO> identificadores;
    private List<VinculoDTO> vinculos;
    private List<EnderecoDTO> enderecos;
    private DadoDemograficoDTO dadoDemografico;
    private List<Comunicacao> comunicacoes;

    public static IndividuoDTO fromJson(final String json) {
        final Gson gson = GSON_BUILDER.create();
        return gson.fromJson(json, IndividuoDTO.class);
    }

    public static IndividuoDTO fromXml(final String xml) throws JAXBException {
        final JAXBContext context = JAXBContext.newInstance(IndividuoDTO.class);
        final Unmarshaller um = context.createUnmarshaller();
        final StringReader sr = new StringReader(xml);
        return (IndividuoDTO) um.unmarshal(sr);
    }

    public String toJson() {
        final Gson gson = GSON_BUILDER.create();
        return gson.toJson(this);
    }

    public String toXml() throws JAXBException {
        final JAXBContext context = JAXBContext.newInstance(IndividuoDTO.class);
        final Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        final StringWriter sw = new StringWriter();
        m.marshal(this, sw);
        return sw.toString();
    }

    public final List<Comunicacao> getComunicacoes() {
        return comunicacoes;
    }

    public final DadoDemograficoDTO getDadoDemografico() {
        return dadoDemografico;
    }

    public final List<EnderecoDTO> getEnderecos() {
        return enderecos;
    }

    public final Long getId() {
        return id;
    }

    public final List<IdentificadorDTO> getIdentificadores() {
        return identificadores;
    }

    public final List<Nome> getNomes() {
        return nomes;
    }

    public final List<VinculoDTO> getVinculos() {
        return vinculos;
    }

    public final void setComunicacoes(final List<Comunicacao> newComunicacoes) {
        comunicacoes = newComunicacoes;
    }

    public final void setDadoDemografico(
            final DadoDemograficoDTO newDadoDemografico) {
        dadoDemografico = newDadoDemografico;
    }

    public final void setEnderecos(final List<EnderecoDTO> newEnderecos) {
        enderecos = newEnderecos;
    }

    public final void setId(final Long newId) {
        id = newId;
    }

    public final void setIdentificadores(
            final List<IdentificadorDTO> newIdentificadores) {
        identificadores = newIdentificadores;
    }

    public final void setNomes(final List<Nome> newNomes) {
        nomes = newNomes;
    }

    public final void setVinculos(final List<VinculoDTO> newVinculos) {
        vinculos = newVinculos;
    }
}