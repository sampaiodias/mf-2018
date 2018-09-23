/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula3;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 * Classe que testa o Exercício 11 da Aula 3 da disciplina de Métodos e
 * Ferramentas de Software (Semestre 2018-2) de Engenharia de Software.
 * 
 * @author Lucas Sampaio Dias
 */
public class AplicacaoTest {
    
    @Test
    public void testDefaultUrl() throws MalformedURLException {
        URL urlAplicacao = Aplicacao.getFileURL(null);
        URL expectedURL = new URL(Aplicacao.DEFAULT_URL);
        assertEquals(expectedURL, urlAplicacao);
    }
    
    @Test
    public void testMalformedURL() throws Exception  {
        String[] args = new String[2];
        args[0] = "wwww.";
        assertThrows(MalformedURLException.class,
                () -> Aplicacao.main(args));
    }
    
    @Test
    public void testAmountForDefaultURL() 
            throws MalformedURLException, IOException {
        HashMap<String, Integer> amountByState = Aplicacao.getAmountByState
            (Aplicacao.getFile(Aplicacao.getFileURL(null)), 
                    Aplicacao.LINES_TO_IGNORE);
        int amount = amountByState.get("MINAS GERAIS");
        assertEquals(true, amount > 0);
    }
}
