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
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Classe que resolve o Exercício 11 da Aula 3 da disciplina de Métodos e
 * Ferramentas de Software (Semestre 2018-2) de Engenharia de Software.
 * 
 * @author Lucas Sampaio Dias
 */
public class Aplicacao {
    private static final String DEFAULT_URL = "http://repositorio.dados.gov.br/educacao/CADASTRO%20DAS%20IES_2011.csv ";
    private static final int LINES_TO_IGNORE = 11;
    
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
        int currentLineNumber = 0;
        HashMap<String, Integer> amountByState = new HashMap<String, Integer>();
        
        while ((line = br.readLine()) != null) {
            currentLineNumber++;
            if (currentLineNumber > LINES_TO_IGNORE) {
                String[] data = line.split(";");
                if (data != null && data.length > 8 && !data[0].isEmpty()) {
                    amountByState.put(data[8], 
                        amountByState.getOrDefault(data[8], 0) + 1);
                }
            }
        }
        
        Map<String, Integer> sortedMapDesc = 
                sortByComparator(amountByState, false);
        for(Map.Entry<String, Integer> entry : sortedMapDesc.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + ": " + value);
        }
    }
    
    /**
     * Ordena uma estrutura do tipo Map de acordo com o parâmetro order.
     * @param unsortMap
     * @param order Use true para ascendente, false para descendente.
     * @return Map ordenado.
     */
    private static Map<String, Integer> sortByComparator
        (Map<String, Integer> unsortMap, final boolean order)
    {
        List<Entry<String, Integer>> list = 
                new LinkedList<Entry<String, Integer>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Entry<String, Integer>>()
        {
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2)
            {
                if (order)
                {
                    return o1.getValue().compareTo(o2.getValue());
                }
                else
                {
                    return o2.getValue().compareTo(o1.getValue());

                }
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Entry<String, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}
