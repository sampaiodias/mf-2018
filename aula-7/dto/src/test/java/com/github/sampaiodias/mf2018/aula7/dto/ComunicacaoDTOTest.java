/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula7.dto;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Lucas Sampaio Dias
 */
@XmlRootElement(name = "comunicacao")
public class ComunicacaoDTOTest {
    private ComunicacaoDTO getComunicacaoDeTestes() {
        ComunicacaoDTO com = new ComunicacaoDTO();
        com.setCodigoMeio(1234);
        com.setCodigoPreferencia("A");
        com.setCodigoUso(1234);
        com.setDetalhe("...");
        
        return com;
    }
    
    private boolean haveEqualFields(final Object a, final Object b) {
        return EqualsBuilder.reflectionEquals(a, b, false, Object.class, true);
    }

    @Test
    public void individuoToAndFromJsonTest() {
        final ComunicacaoDTO com = getComunicacaoDeTestes();
        final String json = com.toJson();
        final ComunicacaoDTO comObtido = ComunicacaoDTO.fromJson(json);
        Assertions.assertTrue(haveEqualFields(com, comObtido));
    }

    @Test
    public void individuoToAndFromXmlTest() throws JAXBException {
        final ComunicacaoDTO com = getComunicacaoDeTestes();
        final String xml = com.toXml();
        final ComunicacaoDTO comObtido = ComunicacaoDTO.fromXml(xml);
        Assertions.assertTrue(haveEqualFields(com, comObtido));
    }
}