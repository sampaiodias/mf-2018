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
public class CertidaoDTOTest {
    private CertidaoDTO getCertidaoDeTestes() {
        final CertidaoDTO certidao = new CertidaoDTO();
        certidao.setCartorio("CARTÓRIO A");
        certidao.setCodigoTipo(1234);
        certidao.setFolha(1);
        certidao.setLivro(2);
        certidao.setTermo(3);
        
        return certidao;
    }
    
    private boolean haveEqualFields(final Object a, final Object b) {
        return EqualsBuilder.reflectionEquals(a, b, false, Object.class, true);
    }
    
    @Test
    public void certidaoToAndFromJsonTest() {
        final CertidaoDTO certidao = getCertidaoDeTestes();
        final String json = certidao.toJson();
        final CertidaoDTO certidaoObtida = CertidaoDTO.fromJson(json);
        Assertions.assertTrue(haveEqualFields(certidao, certidaoObtida));
    }

    @Test
    public void certidaoToAndFromXmlTest() throws JAXBException {
        final CertidaoDTO certidao = getCertidaoDeTestes();
        final String xml = certidao.toXml();
        final CertidaoDTO certidaoObtida = CertidaoDTO.fromXml(xml);
        Assertions.assertTrue(haveEqualFields(certidao, certidaoObtida));
    }
}