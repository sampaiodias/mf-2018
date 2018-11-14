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
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

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
    
    @Test
    public void linhaXmlSchemaTest() throws 
            IOException, JAXBException, SAXException {
        File resourcesDirectory = new File("src/test/resources");
        File schemaFile = new File(resourcesDirectory.getAbsolutePath() + 
                "/xml-schema/enderecolinha.xsd");
        Source xmlFile = 
                new StreamSource(new File(resourcesDirectory.getAbsolutePath() +
                        "/xml/EnderecoLinha.xml"));
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