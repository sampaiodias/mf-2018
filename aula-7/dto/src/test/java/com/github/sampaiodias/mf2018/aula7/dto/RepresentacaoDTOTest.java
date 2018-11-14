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
public class RepresentacaoDTOTest {
    private RepresentacaoDTO getRepresentacaoDeTestes() {
        RepresentacaoDTO rep = new RepresentacaoDTO();
        rep.setAlternativa("A");
        rep.setUtilizacao("B");
        return rep;
    }
    
    private boolean isEquals(final Object a, final Object b) {
        return EqualsBuilder.reflectionEquals(a, b, false, Object.class, true);
    }

    @Test
    public void representacaoToAndFromJsonTest() {
        final RepresentacaoDTO rep = getRepresentacaoDeTestes();
        final String json = rep.toJson();
        final RepresentacaoDTO repObtido = RepresentacaoDTO.fromJson(json);
        Assertions.assertTrue(isEquals(rep, repObtido));
    }

    @Test
    public void representacaoToAndFromXmlTest() throws JAXBException {
        final RepresentacaoDTO rep = getRepresentacaoDeTestes();
        final String xml = rep.toXml();
        final RepresentacaoDTO repObtido = RepresentacaoDTO.fromXml(xml);
        Assertions.assertTrue(isEquals(rep, repObtido));
    }
}