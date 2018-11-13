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
@XmlRootElement(name = "endereco")
public class EnderecoDTO {
    
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
    private String bairro;
    private String distrito;
    private String cep;
    private String caixaPostal;
    private Integer codigoMunicipio;
    private String codigoEstado;
    private Integer codigoPais;
    private Integer codigoTipo;
    private DataComAcuraciaDTO dataInicio;
    private DataComAcuraciaDTO dataFim;
    private List<EnderecoLinhaDTO> linhas;
    
    public static EnderecoDTO fromJson(final String json) {
        final Gson gson = GSON_BUILDER.create();
        return gson.fromJson(json, EnderecoDTO.class);
    }

    public static EnderecoDTO fromXml(final String xml) throws JAXBException {
        final JAXBContext context = JAXBContext.newInstance(EnderecoDTO.class);
        final Unmarshaller um = context.createUnmarshaller();
        final StringReader sr = new StringReader(xml);
        return (EnderecoDTO) um.unmarshal(sr);
    }

    public String toJson() {
        final Gson gson = GSON_BUILDER.create();
        return gson.toJson(this);
    }

    public String toXml() throws JAXBException {
        final JAXBContext context = JAXBContext.newInstance(EnderecoDTO.class);
        final Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        final StringWriter sw = new StringWriter();
        m.marshal(this, sw);
        return sw.toString();
    }

    public final String getBairro() {
        return bairro;
    }

    public final String getCaixaPostal() {
        return caixaPostal;
    }

    public final String getCep() {
        return cep;
    }

    public final String getCodigoEstado() {
        return codigoEstado;
    }

    public final Integer getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public final Integer getCodigoPais() {
        return codigoPais;
    }

    public final Integer getCodigoTipo() {
        return codigoTipo;
    }

    public final DataComAcuraciaDTO getDataFim() {
        return dataFim;
    }

    public final DataComAcuraciaDTO getDataInicio() {
        return dataInicio;
    }

    public final String getDistrito() {
        return distrito;
    }

    public final Integer getId() {
        return id;
    }

    public final List<EnderecoLinhaDTO> getLinhas() {
        return linhas;
    }

    public final void setBairro(final String bairro) {
        this.bairro = bairro;
    }

    public final void setCaixaPostal(final String caixaPostal) {
        this.caixaPostal = caixaPostal;
    }

    public final void setCep(final String cep) {
        this.cep = cep;
    }

    public final void setCodigoEstado(final String codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public final void setCodigoMunicipio(final Integer codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public final void setCodigoPais(final Integer codigoPais) {
        this.codigoPais = codigoPais;
    }

    public final void setCodigoTipo(final Integer codigoTipo) {
        this.codigoTipo = codigoTipo;
    }

    public final void setDataFim(final DataComAcuraciaDTO dataFim) {
        this.dataFim = dataFim;
    }

    public final void setDataInicio(
            final DataComAcuraciaDTO dataInicio) {
        this.dataInicio = dataInicio;
    }

    public final void setDistrito(final String distrito) {
        this.distrito = distrito;
    }

    public final void setId(final Integer Id) {
        this.id = Id;
    }

    public final void setLinhas(final List<EnderecoLinhaDTO> linhas) {
        this.linhas = linhas;
    }
}