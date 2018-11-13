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
public class VinculoDTOTest {
    private VinculoDTO getVinculoDeTestes() {
        VinculoDTO v = new VinculoDTO();
        v.setIdIdentificador(123);
        v.setRelacionamento("RELACIONAMENTO TESTE");
        v.setDataInicio(LocalDate.now());
        v.setDataFim(LocalDate.now());
        return v;
    }
    
    private boolean isEquals(final Object a, final Object b) {
        return EqualsBuilder.reflectionEquals(a, b, false, Object.class, true);
    }

    @Test
    public void vinculoToAndFromJsonTest() {
        final VinculoDTO vinculo = getVinculoDeTestes();
        final String json = vinculo.toJson();
        final VinculoDTO vinculoObtido = VinculoDTO.fromJson(json);
        Assertions.assertTrue(isEquals(vinculo, vinculoObtido));
    }

    @Test
    public void vinculoToAndFromXmlTest() throws JAXBException {
        final VinculoDTO vinculo = getVinculoDeTestes();
        final String xml = vinculo.toXml();
        final VinculoDTO vinculoObtido = VinculoDTO.fromXml(xml);
        Assertions.assertTrue(isEquals(vinculo, vinculoObtido));
    }
}