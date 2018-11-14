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
import java.util.ArrayList;
import java.util.List;
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
public class NomeDTOTest {
    private NomeDTO getNomeDeTestes() {
        final NomeDTO nome = new NomeDTO();
        final List<RepresentacaoDTO> representacoes = new ArrayList<>();
        final RepresentacaoDTO representacao = new RepresentacaoDTO();
        representacao.setAlternativa("JOÃO NINGUÉM");
        representacao.setUtilizacao("A");
        representacoes.add(representacao);

        final List<UtilizacaoDTO> utilizacoes = new ArrayList<>();
        final UtilizacaoDTO utilizacao = new UtilizacaoDTO();
        utilizacao.setDataFinal(LocalDate.now());
        utilizacao.setDataInicial(LocalDate.now());
        utilizacao.setIdIdentificador(1234);
        utilizacao.setCodigoUso(1);
        utilizacoes.add(utilizacao);

        nome.setCodigoPreferido(1);
        nome.setCodigoUsoCondicional(3);
        nome.setId(1234);
        nome.setNomes("JOAO");
        nome.setRepresentacoes(representacoes);
        nome.setSobrenomes("NINGUÉM");
        nome.setSufixos("SR.");
        nome.setTitulos("DR.");
        nome.setUtilizacoes(utilizacoes);
        
        return nome;
    }
    
    private boolean isEquals(final Object a, final Object b) {
        return EqualsBuilder.reflectionEquals(a, b, false, Object.class, true);
    }

    @Test
    public void nomeToAndFromJsonTest() {
        final NomeDTO nome = getNomeDeTestes();
        final String json = nome.toJson();
        final NomeDTO nomeObtido = NomeDTO.fromJson(json);
        Assertions.assertTrue(isEquals(nome, nomeObtido));
    }

    @Test
    public void nomeToAndFromXmlTest() throws JAXBException {
        final NomeDTO nome = getNomeDeTestes();
        final String xml = nome.toXml();
        final NomeDTO nomeObtido = NomeDTO.fromXml(xml);
        Assertions.assertTrue(isEquals(nome, nomeObtido));
    }
    
    @Test
    public void nomeJsonSchemaTest() throws IOException {
        File resourcesDirectory = new File("src/test/resources");
        final String jsonFileName = "Nome.json";
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
    public void nomeXmlSchemaTest() throws 
            IOException, JAXBException, SAXException {
        File resourcesDirectory = new File("src/test/resources");
        File schemaFile = new File(resourcesDirectory.getAbsolutePath() + 
                "/xml-schema/nome.xsd");
        Source xmlFile = 
                new StreamSource(new File(resourcesDirectory.getAbsolutePath() +
                        "/xml/Nome.xml"));
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