/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula7.dto;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

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
    
    private boolean isEquals(final Object a, final Object b) {
        return EqualsBuilder.reflectionEquals(a, b, false, Object.class, true);
    }
    
    @Test
    public void certidaoToAndFromJsonTest() {
        final CertidaoDTO certidao = getCertidaoDeTestes();
        final String json = certidao.toJson();
        final CertidaoDTO certidaoObtida = CertidaoDTO.fromJson(json);
        Assertions.assertTrue(isEquals(certidao, certidaoObtida));
    }

    @Test
    public void certidaoToAndFromXmlTest() throws JAXBException {
        final CertidaoDTO certidao = getCertidaoDeTestes();
        final String xml = certidao.toXml();
        final CertidaoDTO certidaoObtida = CertidaoDTO.fromXml(xml);
        Assertions.assertTrue(isEquals(certidao, certidaoObtida));
    }
    
    @Test
    public void certidaoXmlSchemaTest() throws 
            IOException, JAXBException, SAXException {
        File resourcesDirectory = new File("src/test/resources");
        File schemaFile = new File(resourcesDirectory.getAbsolutePath() + 
                "/xml-schema/certidao.xsd");
        Source xmlFile = 
                new StreamSource(new File(resourcesDirectory.getAbsolutePath() +
                        "/xml/Certidao.xml"));
        SchemaFactory schemaFactory = SchemaFactory
            .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        
        try {
            Schema schema = schemaFactory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            validator.validate(xmlFile);
            Assertions.assertTrue(true);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }
}