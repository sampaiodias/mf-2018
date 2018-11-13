/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula7.dto;

import javax.xml.bind.JAXBException;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Lucas Sampaio Dias
 */
public class TituloEleitoralDTOTest {
    private TituloEleitoralDTO getTituloDeTestes() {
        TituloEleitoralDTO t = new TituloEleitoralDTO();
        t.setSessao(1);
        t.setZona(2);
        return t;
    }
    
    private boolean isEquals(final Object a, final Object b) {
        return EqualsBuilder.reflectionEquals(a, b, false, Object.class, true);
    }

    @Test
    public void tituloToAndFromJsonTest() {
        final TituloEleitoralDTO titulo = getTituloDeTestes();
        final String json = titulo.toJson();
        final TituloEleitoralDTO tituloObtido = 
                TituloEleitoralDTO.fromJson(json);
        Assertions.assertTrue(isEquals(titulo, tituloObtido));
    }

    @Test
    public void tituloToAndFromXmlTest() throws JAXBException {
        final TituloEleitoralDTO titulo = getTituloDeTestes();
        final String xml = titulo.toXml();
        final TituloEleitoralDTO tituloObtido = TituloEleitoralDTO.fromXml(xml);
        Assertions.assertTrue(isEquals(titulo, tituloObtido));
    }
}
