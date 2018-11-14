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
    
    @Test
    public void vinculoXmlSchemaTest() throws 
            IOException, JAXBException, SAXException {
        File resourcesDirectory = new File("src/test/resources");
        File schemaFile = new File(resourcesDirectory.getAbsolutePath() + 
                "/xml-schema/vinculo.xsd");
        Source xmlFile = 
                new StreamSource(new File(resourcesDirectory.getAbsolutePath() +
                        "/xml/Vinculo.xml"));
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