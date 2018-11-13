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
public class UtilizacaoDTOTest {
    private UtilizacaoDTO getUtilizacaoDeTestes() {
        UtilizacaoDTO u = new UtilizacaoDTO();
        u.setCodigoUso(123);
        u.setIdIdentificador(1234);
        u.setDataFinal(LocalDate.now());
        u.setDataInicial(LocalDate.now());
        return u;
    }
    
    private boolean isEquals(final Object a, final Object b) {
        return EqualsBuilder.reflectionEquals(a, b, false, Object.class, true);
    }

    @Test
    public void utilizacaoToAndFromJsonTest() {
        final UtilizacaoDTO utilizacao = getUtilizacaoDeTestes();
        final String json = utilizacao.toJson();
        final UtilizacaoDTO utilizacaoObtido = UtilizacaoDTO.fromJson(json);
        Assertions.assertTrue(isEquals(utilizacao, utilizacaoObtido));
    }

    @Test
    public void utilizacaoToAndFromXmlTest() throws JAXBException {
        final UtilizacaoDTO utilizacao = getUtilizacaoDeTestes();
        final String xml = utilizacao.toXml();
        final UtilizacaoDTO utilizacaoObtido = UtilizacaoDTO.fromXml(xml);
        Assertions.assertTrue(isEquals(utilizacao, utilizacaoObtido));
    }
}