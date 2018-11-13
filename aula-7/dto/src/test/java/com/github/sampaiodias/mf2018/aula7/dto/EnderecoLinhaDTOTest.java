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
public class EnderecoLinhaDTOTest {
    private EnderecoLinhaDTO getEnderecoLinhaDeTestes() {
        EnderecoLinhaDTO linha = new EnderecoLinhaDTO();
        linha.setLinha("A");
        linha.setOrdem(123);
        return linha;
    }
    
    private boolean isEquals(final Object a, final Object b) {
        return EqualsBuilder.reflectionEquals(a, b, false, Object.class, true);
    }

    @Test
    public void linhaToAndFromJsonTest() {
        final EnderecoLinhaDTO linha = getEnderecoLinhaDeTestes();
        final String json = linha.toJson();
        final EnderecoLinhaDTO linhaObtida = EnderecoLinhaDTO.fromJson(json);
        Assertions.assertTrue(isEquals(linha, linhaObtida));
    }

    @Test
    public void linhaToAndFromXmlTest() throws JAXBException {
        final EnderecoLinhaDTO linha = getEnderecoLinhaDeTestes();
        final String xml = linha.toXml();
        final EnderecoLinhaDTO linhaObtida = EnderecoLinhaDTO.fromXml(xml);
        Assertions.assertTrue(isEquals(linha, linhaObtida));
    }
}