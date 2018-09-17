/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Classe que resolve o Exercício 11 da Aula 3 da disciplina de Métodos e
 * Ferramentas de Software (Semestre 2018-2) de Engenharia de Software.
 * 
 * @author Lucas Sampaio Dias
 */
public class Aplicacao {
    private static final String DEFAULT_URL = "http://repositorio.dados.gov.br/educacao/CADASTRO%20DAS%20IES_2011.csv ";
    
    /**
     * O programa baixa o arquivo CSV conforme uma URL fornecida, lista, em 
     * ordem decrescente, por estado, os totais de instituições de educação 
     * superior, ou seja, teremos possivelmente 27 linhas na saída padrão, 26 
     * estados e o Distrito Federal, cada uma delas com o total de 
     * estabelecimentos na unidade federativa em questão.
     * 
     * O programa ignora as 10 primeiras linhas do arquivo. A décima primeira
     * contém o cabeçalho e a partir da décima segunda seguem os dados.
     * 
     * @param args
     * @throws MalformedURLException
     * @throws IOException 
     */
    public static void main(String[] args) throws MalformedURLException, 
            IOException {
        URL url;
        if (args != null && args.length > 0) {
            url = new URL(args[0]);
        }
        else {
            url = new URL(DEFAULT_URL);
        }
        
        URLConnection urlConn = url.openConnection();
        InputStreamReader inputCSV = new InputStreamReader(
                    ((URLConnection) urlConn).getInputStream());
        BufferedReader br = new BufferedReader(inputCSV);
        
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}
