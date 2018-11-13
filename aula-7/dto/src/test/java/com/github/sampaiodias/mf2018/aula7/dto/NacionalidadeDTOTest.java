/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula7.dto;

import java.time.LocalDate;
import javax.xml.bind.JAXBException;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Lucas Sampaio Dias
 */
public class NacionalidadeDTOTest {
    private NacionalidadeDTO getNacionalidadeDeTestes() {
        final NacionalidadeDTO nac = new NacionalidadeDTO();
        nac.setCodigoEstado("GO");
        nac.setCodigoMunicipio(1234);
        nac.setCodigoPais(55);
        nac.setDataEntradaPais(LocalDate.now());
        return nac;
    }
    
    private boolean isEquals(final Object a, final Object b) {
        return EqualsBuilder.reflectionEquals(a, b, false, Object.class, true);
    }

    @Test
    public void nacionalidadeToAndFromJsonTest() {
        final NacionalidadeDTO nac = getNacionalidadeDeTestes();
        final String json = nac.toJson();
        final NacionalidadeDTO nacObtido = NacionalidadeDTO.fromJson(json);
        Assertions.assertTrue(isEquals(nac, nacObtido));
    }

    @Test
    public void nacionalidadeToAndFromXmlTest() throws JAXBException {
        final NacionalidadeDTO nac = getNacionalidadeDeTestes();
        final String xml = nac.toXml();
        final NacionalidadeDTO nacObtido = NacionalidadeDTO.fromXml(xml);
        Assertions.assertTrue(isEquals(nac, nacObtido));
    }
}