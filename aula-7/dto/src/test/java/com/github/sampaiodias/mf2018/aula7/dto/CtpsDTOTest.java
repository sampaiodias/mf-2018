/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula7.dto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

/**
 *
 * @author Lucas Sampaio Dias
 */
public class CtpsDTOTest {
    private CtpsDTO getCtpsDeTestes() {
        CtpsDTO ctps = new CtpsDTO();
        ctps.setCodigoEstado("GO");
        ctps.setSerie(111);
        return ctps;
    }
    
    private boolean isEquals(final Object a, final Object b) {
        return EqualsBuilder.reflectionEquals(a, b, false, Object.class, true);
    }

    @Test
    public void ctpsToAndFromJsonTest() {
        final CtpsDTO ctps = getCtpsDeTestes();
        final String json = ctps.toJson();
        final CtpsDTO ctpsObtido = CtpsDTO.fromJson(json);
        Assertions.assertTrue(isEquals(ctps, ctpsObtido));
    }

    @Test
    public void ctpsToAndFromXmlTest() throws JAXBException {
        final CtpsDTO ctps = getCtpsDeTestes();
        final String xml = ctps.toXml();
        final CtpsDTO ctpsObtido = CtpsDTO.fromXml(xml);
        Assertions.assertTrue(isEquals(ctps, ctpsObtido));
    }
    
    @Test
    public void ctpsJsonSchemaTest() throws IOException {
        File resourcesDirectory = new File("src/test/resources");
        final String jsonFileName = "CTPS.json";
        try {
            File schemaFile = new File(resourcesDirectory.getAbsolutePath() + 
                "/json-schema/" + jsonFileName);
            BufferedReader brSchema = 
                    new BufferedReader(new FileReader(schemaFile));
            File jsonFile = new File(resourcesDirectory.getAbsolutePath() + 
                "/json/" + jsonFileName);
            BufferedReader brJson = 
                    new BufferedReader(new FileReader(jsonFile));
            
            JSONObject rawSchema = new JSONObject(new JSONTokener(brSchema));
            org.everit.json.schema.Schema schema = 
                    org.everit.json.schema.loader.SchemaLoader.load(rawSchema);
            JSONObject json = new JSONObject(new JSONTokener(brJson));
            schema.validate(json);
            
            Assertions.assertTrue(true);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }
    
    @Test
    public void ctpsXmlSchemaTest() throws 
            IOException, JAXBException, SAXException {
        File resourcesDirectory = new File("src/test/resources");
        File schemaFile = new File(resourcesDirectory.getAbsolutePath() + 
                "/xml-schema/ctps.xsd");
        Source xmlFile = 
                new StreamSource(new File(resourcesDirectory.getAbsolutePath() +
                        "/xml/CTPS.xml"));
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