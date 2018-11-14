/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula7.dto;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
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
    
    @Test
    public void utilizacaoXmlSchemaTest() throws 
            IOException, JAXBException, SAXException {
        File resourcesDirectory = new File("src/test/resources");
        File schemaFile = new File(resourcesDirectory.getAbsolutePath() + 
                "/xml-schema/utilizacao.xsd");
        Source xmlFile = 
                new StreamSource(new File(resourcesDirectory.getAbsolutePath() +
                        "/xml/Utilizacao.xml"));
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