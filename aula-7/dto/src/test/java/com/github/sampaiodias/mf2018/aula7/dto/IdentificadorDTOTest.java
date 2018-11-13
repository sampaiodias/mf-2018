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
}