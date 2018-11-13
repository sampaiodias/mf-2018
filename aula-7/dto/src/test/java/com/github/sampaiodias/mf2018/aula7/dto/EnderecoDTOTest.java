/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula7.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Lucas Sampaio Dias
 */
public class EnderecoDTOTest {
    private EnderecoDTO getEnderecoDeTestes() {
        EnderecoDTO end = new EnderecoDTO();
        end.setBairro("BAIRRO TESTE");
        end.setCaixaPostal("12345");
        end.setCep("12345-678");
        end.setCodigoEstado("GO");
        end.setCodigoMunicipio(123);
        end.setCodigoPais(55);
        end.setCodigoTipo(1234);
        end.setDistrito("DISTRITO TESTE");
        end.setId(0101);
        
        DataComAcuraciaDTO data = new DataComAcuraciaDTO();
        data.setAcuracia("Acurado");
        data.setData(LocalDate.now());
        end.setDataFim(data);
        end.setDataInicio(data);        
        
        ArrayList<EnderecoLinhaDTO> linhas = new ArrayList<>();
        EnderecoLinhaDTO linha = new EnderecoLinhaDTO();
        linha.setLinha("A");
        linha.setOrdem(123);
        linhas.add(linha);
        end.setLinhas(linhas);
        
        return end;
    }
    
    private boolean isEquals(final Object a, final Object b) {
        return EqualsBuilder.reflectionEquals(a, b, false, Object.class, true);
    }

    @Test
    public void enderecoToAndFromJsonTest() {
        final EnderecoDTO end = getEnderecoDeTestes();
        final String json = end.toJson();
        final EnderecoDTO endObtido = EnderecoDTO.fromJson(json);
        Assertions.assertTrue(isEquals(end, endObtido));
    }

    @Test
    public void enderecoToAndFromXmlTest() throws JAXBException {
        final EnderecoDTO end = getEnderecoDeTestes();
        final String xml = end.toXml();
        final EnderecoDTO endObtido = EnderecoDTO.fromXml(xml);
        Assertions.assertTrue(isEquals(end, endObtido));
    }
}