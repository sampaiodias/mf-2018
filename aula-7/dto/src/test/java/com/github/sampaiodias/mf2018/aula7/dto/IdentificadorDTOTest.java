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
import java.time.LocalDate;
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
public class IdentificadorDTOTest {
    private IdentificadorDTO getIdentificadorDeTestes() {
        IdentificadorDTO id = new IdentificadorDTO();
        id.setCodigoArea(12345);
        id.setCodigoTipo("TIPO");
        id.setData(LocalDate.now());
        id.setDesignacao("DESIGNACAO");
        id.setEmissor("EMISSOR");
        id.setId(1234);
        id.setIdIndividuo(123);
        
        CertidaoDTO c = new CertidaoDTO();
        c.setCartorio("A");
        id.setCertidao(c);
        
        TituloEleitoralDTO t = new TituloEleitoralDTO();
        t.setSessao(1);
        t.setZona(2);
        id.setTituloEleitoral(t);
        
        return id;
    }
    
    private boolean isEquals(final Object a, final Object b) {
        return EqualsBuilder.reflectionEquals(a, b, false, Object.class, true);
    }

    @Test
    public void idToAndFromJsonTest() {
        final IdentificadorDTO id = getIdentificadorDeTestes();
        final String json = id.toJson();
        final IdentificadorDTO idObtido = IdentificadorDTO.fromJson(json);
        Assertions.assertTrue(isEquals(id, idObtido));
    }

    @Test
    public void idToAndFromXmlTest() throws JAXBException {
        final IdentificadorDTO id = getIdentificadorDeTestes();
        final String xml = id.toXml();
        final IdentificadorDTO idObtido = IdentificadorDTO.fromXml(xml);
        Assertions.assertTrue(isEquals(id, idObtido));
    }
    
    @Test
    public void identificadorJsonSchemaTest() throws IOException {
        File resourcesDirectory = new File("src/test/resources");
        final String jsonFileName = "Identificador.json";
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
    public void identificadorXmlSchemaTest() throws 
            IOException, JAXBException, SAXException {
        File resourcesDirectory = new File("src/test/resources");
        File schemaFile = new File(resourcesDirectory.getAbsolutePath() + 
                "/xml-schema/identificador.xsd");
        Source xmlFile = 
                new StreamSource(new File(resourcesDirectory.getAbsolutePath() +
                        "/xml/Identificador.xml"));
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