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
public class DadoDemograficoDTOTest {
    private DadoDemograficoDTO getDadoDemograficoDeTestes() {
        DadoDemograficoDTO dado = new DadoDemograficoDTO();
        dado.setCodigoNascimentoOrdem(123);
        dado.setCodigoNascimentoPluraridade(12345);
        dado.setCodigoNascimentoSeguimento("ABC");
        dado.setCodigoObitoFonte(000);
        dado.setCodigoRaca(1);
        dado.setCodigoSexo(0);
        dado.setCodigoSituacaoFamiliar(2);
        dado.setComentario("...");
        dado.setMae("MÃE");
        dado.setPai("PAI");
        
        DataComAcuraciaDTO data = new DataComAcuraciaDTO();
        data.setAcuracia("Acurado");
        data.setData(LocalDate.now());
        dado.setNascimento(data);
        
        NacionalidadeDTO nac = new NacionalidadeDTO();
        nac.setCodigoEstado("MG");
        nac.setCodigoMunicipio(1111);
        nac.setCodigoPais(999);
        nac.setDataEntradaPais(LocalDate.now());
        dado.setNacionalidade(nac);
        
        return dado;
    }
    
        private boolean isEquals(final Object a, final Object b) {
        return EqualsBuilder.reflectionEquals(a, b, false, Object.class, true);
    }

    @Test
    public void dadoDemograficoToAndFromJsonTest() {
        final DadoDemograficoDTO dado = getDadoDemograficoDeTestes();
        final String json = dado.toJson();
        final DadoDemograficoDTO dadoObtido = DadoDemograficoDTO.fromJson(json);
        Assertions.assertTrue(isEquals(dado, dadoObtido));
    }

    @Test
    public void dadoDemograficoToAndFromXmlTest() throws JAXBException {
        final DadoDemograficoDTO dado = getDadoDemograficoDeTestes();
        final String xml = dado.toXml();
        final DadoDemograficoDTO dadoObtido = DadoDemograficoDTO.fromXml(xml);
        Assertions.assertTrue(isEquals(dado, dadoObtido));
    }
    
    @Test
    public void dadoDemograficoXmlSchemaTest() throws 
            IOException, JAXBException, SAXException {
        File resourcesDirectory = new File("src/test/resources");
        File schemaFile = new File(resourcesDirectory.getAbsolutePath() + 
                "/xml-schema/dadodemografico.xsd");
        Source xmlFile = 
                new StreamSource(new File(resourcesDirectory.getAbsolutePath() +
                        "/xml/DadoDemografico.xml"));
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
