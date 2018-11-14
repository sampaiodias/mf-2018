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
public class DataComAcuraciaDTOTest {
    private DataComAcuraciaDTO getDataDeTestes() {
        DataComAcuraciaDTO data = new DataComAcuraciaDTO();
        data.setAcuracia("Acurado");
        data.setData(LocalDate.now());
        return data;
    }
    
    private boolean isEquals(final Object a, final Object b) {
        return EqualsBuilder.reflectionEquals(a, b, false, Object.class, true);
    }
    
    @Test
    public void dataToAndFromJsonTest() {
        final DataComAcuraciaDTO data = getDataDeTestes();
        final String json = data.toJson();
        final DataComAcuraciaDTO dataObtido = DataComAcuraciaDTO.fromJson(json);
        Assertions.assertTrue(isEquals(data, dataObtido));
    }

    @Test
    public void dataToAndFromXmlTest() throws JAXBException {
        final DataComAcuraciaDTO data = getDataDeTestes();
        final String xml = data.toXml();
        final DataComAcuraciaDTO dataObtido = DataComAcuraciaDTO.fromXml(xml);
        Assertions.assertTrue(isEquals(data, dataObtido));
    }
    
    @Test
    public void dataXmlSchemaTest() throws 
            IOException, JAXBException, SAXException {
        File resourcesDirectory = new File("src/test/resources");
        File schemaFile = new File(resourcesDirectory.getAbsolutePath() + 
                "/xml-schema/datacomacuracia.xsd");
        Source xmlFile = 
                new StreamSource(new File(resourcesDirectory.getAbsolutePath() +
                        "/xml/DataComAcuracia.xml"));
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