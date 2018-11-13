/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula7.dto;

import javax.xml.bind.JAXBException;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Lucas Sampaio Dias
 */
public class EnderecoLinhaDTOTest {
    private EnderecoLinhaDTO EnderecoLinhaDeTestes() {
        EnderecoLinhaDTO linha = new EnderecoLinhaDTO();
        linha.setLinha("A");
        linha.setOrdem(123);
        return linha;
    }
}