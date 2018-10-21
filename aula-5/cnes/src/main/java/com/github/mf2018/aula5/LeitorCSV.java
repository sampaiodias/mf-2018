/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.mf2018.aula5;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Mais detalhes no tópico "Aula 5" do documento disponível em:
 * https://docs.google.com/document/d/1TTFjo0qcjmuaYkE1okWAiV_qqoyYs9r4FFO3dp7nikI/edit#
 * @author Lucas Sampaio Dias
 */
public class LeitorCSV {

    private final String SPLITTER = ";";
    private final int COD_ESTABELECIMENTO = 1;
    private final int RAZAO_SOCIAL = 5;
    private final int LATITUDE = 39;
    private final int LONGITUDE = 40;

    public List<Estabelecimento> getEstabelecimentos
        (String caminhoArquivo) throws IOException {
        try(ZipInputStream is = new ZipInputStream
        (new URL(caminhoArquivo).openConnection().getInputStream())) {
            List<Estabelecimento> lista = new ArrayList();
            ZipEntry arquivoCsvObtido;

            while((arquivoCsvObtido = is.getNextEntry()) != null) {
                String fileName = arquivoCsvObtido.getName();
                if(fileName.startsWith("tbEstabelecimento")) {
                    processarCSV(is, lista);
                    return lista;
                }
            }

            is.closeEntry();
            is.close();
            return lista;
        } 
        catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }

    private void processarCSV(ZipInputStream is, List<Estabelecimento> lista) 
            throws IOException {
        InputStreamReader reader = new InputStreamReader(is);

        try(BufferedReader bufferReader = new BufferedReader(reader)) {
            bufferReader.readLine();
            leiaLinha(lista, bufferReader);
        } 
        catch(IOException e) {
            throw new IOException(e.getMessage());
        }
    }

    private void leiaLinha(List<Estabelecimento> lista, 
            BufferedReader bufferReader) throws IOException {
        String linha;
        while ((linha = bufferReader.readLine()) != null) {

            Estabelecimento estabelecimento = new Estabelecimento();
            StringTokenizer tokenizer = 
                    new StringTokenizer(linha, SPLITTER, true);
            processarLinha(estabelecimento, tokenizer);
            lista.add(estabelecimento);
        }
    }

    private void processarLinha(Estabelecimento estabelecimento, 
            StringTokenizer linhaSplit) {
        if (linhaSplit.hasMoreTokens()) {
            preenchaEstabelecimento(estabelecimento, linhaSplit);
        }
    }

    private void preenchaEstabelecimento(Estabelecimento estabelecimento, 
            StringTokenizer linhaSplit) {
            linhaSplit.nextToken();
            String codigo = pegueValor(linhaSplit, COD_ESTABELECIMENTO);
            estabelecimento.setCodigoEstabelecimento(codigo);

            String razao = pegueValor(linhaSplit, 
                    RAZAO_SOCIAL - COD_ESTABELECIMENTO);
            estabelecimento.setRazaoSocial(razao);

            String latitude = pegueValor(linhaSplit, 
                    LATITUDE - RAZAO_SOCIAL);
            estabelecimento.setLatitude(latitude);

            String longitude = pegueValor(linhaSplit, 
                    LONGITUDE - LATITUDE);
            estabelecimento.setLongitude(longitude);
    }

    private String pegueValor(StringTokenizer st, int indexToken) {

        String value = "";

        while(indexToken > 0) {
            value = st.nextToken();
            if(!SPLITTER.equals(value)) {
                indexToken--;
            }
        }

        if("".equals(value)) {
            value = st.nextToken();
        }

        if (SPLITTER.equals(value))
            value = null;
        else if (st.hasMoreTokens())
            st.nextToken();

        return value.replace("\"", "");
    }
}
