/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class CtpsDTOTest {
    private CtpsDTO getCtpsDeTestes() {
        CtpsDTO ctps = new CtpsDTO();
        ctps.setCodigoEstado("GO");
        ctps.setSerie(111);
        return ctps;
    }
    
    private boolean haveEqualFields(final Object a, final Object b) {
        return EqualsBuilder.reflectionEquals(a, b, false, Object.class, true);
    }

    @Test
    public void ctpsToAndFromJsonTest() {
        final CtpsDTO ctps = getCtpsDeTestes();
        final String json = ctps.toJson();
        final CtpsDTO ctpsObtido = CtpsDTO.fromJson(json);
        Assertions.assertTrue(haveEqualFields(ctps, ctpsObtido));
    }

    @Test
    public void ctpsToAndFromXmlTest() throws JAXBException {
        final CtpsDTO ctps = getCtpsDeTestes();
        final String xml = ctps.toXml();
        final CtpsDTO ctpsObtido = CtpsDTO.fromXml(xml);
        Assertions.assertTrue(haveEqualFields(ctps, ctpsObtido));
    }
}