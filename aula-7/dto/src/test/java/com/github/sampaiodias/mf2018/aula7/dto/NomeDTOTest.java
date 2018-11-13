/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula7.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBException;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}