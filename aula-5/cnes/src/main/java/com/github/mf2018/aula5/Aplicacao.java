/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.mf2018.aula5;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Mais detalhes no tópico "Aula 5" do documento disponível em:
 * https://docs.google.com/document/d/1TTFjo0qcjmuaYkE1okWAiV_qqoyYs9r4FFO3dp7nikI/edit#
 * @author Lucas Sampaio Dias
 */
public class Aplicacao {
    private static final String DEFAULT_URL = 
            "ftp://ftp.datasus.gov.br/cnes/BASE_DE_DADOS_CNES_201809.ZIP";
    private static final String DEFAULT_JSON_NAME = "CNES-estabelecimentos";
    public static void main(String[] args) throws IOException {

        String url = DEFAULT_URL;
        String nomeArquivo = DEFAULT_JSON_NAME;
        if (args.length > 0) {
            url = args[0];
        }
        if (args.length > 1) {
            nomeArquivo = args[1];
        }

        System.out.println("Origem: " + url);
        System.out.println("Destino: " + nomeArquivo + ".json");
        System.out.println("Processando...");
        
        LeitorCSV processador = new LeitorCSV();
        List<Estabelecimento> lista = 
                processador.getEstabelecimentos(url);

        gerarJson(nomeArquivo, lista);
    }

    private static void gerarJson
        (String nomeArquivo, List<Estabelecimento> estabelecimentos) 
                throws IOException {
        Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create();
        String json = gsonBuilder.toJson(estabelecimentos);
        
        BufferedWriter out = 
                new BufferedWriter(new FileWriter(nomeArquivo.concat(".json")));
        try {
            out.write(json);
        }
        catch (IOException e)
        {
            System.out.println(e.toString());
        }
        finally
        {
            out.close();
        }
    }
}
