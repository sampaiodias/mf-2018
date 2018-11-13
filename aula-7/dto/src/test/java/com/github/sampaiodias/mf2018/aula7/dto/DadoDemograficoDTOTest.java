/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula7.dto;

import java.time.LocalDate;
import javax.xml.bind.JAXBException;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        System.out.println(json);
        final DadoDemograficoDTO dadoObtido = DadoDemograficoDTO.fromJson(json);
        Assertions.assertTrue(isEquals(dado, dadoObtido));
    }

    @Test
    public void dadoDemograficoToAndFromXmlTest() throws JAXBException {
        final DadoDemograficoDTO dado = getDadoDemograficoDeTestes();
        final String xml = dado.toXml();
        System.out.println(xml);
        final DadoDemograficoDTO dadoObtido = DadoDemograficoDTO.fromXml(xml);
        Assertions.assertTrue(isEquals(dado, dadoObtido));
    }
}
