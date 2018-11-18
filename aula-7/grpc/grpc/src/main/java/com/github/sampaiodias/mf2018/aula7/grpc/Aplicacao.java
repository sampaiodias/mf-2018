/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula7.grpc;

/**
 *
 * @author Lucas Sampaio Dias
 */
public class Aplicacao {
    public static void main(String[] args) {
        IdentificadorOuterClass.Identificador id = buildIdentificador();
        System.out.println(id.getAllFields());
    }
    
    private static IdentificadorOuterClass.Identificador buildIdentificador() {
        IdentificadorOuterClass.Identificador.Certidao c = 
                IdentificadorOuterClass.Identificador.Certidao.newBuilder()
                    .setCartorio("A")
                    .build();
        
        IdentificadorOuterClass.Identificador.TituloEleitoral t = 
                IdentificadorOuterClass.Identificador.TituloEleitoral.
                        newBuilder()
                            .setSessao(1)
                            .setZona(2)
                            .build();
        
        IdentificadorOuterClass.Identificador id = IdentificadorOuterClass.
                Identificador.newBuilder()
                .setCodigoArea(12345)
                .setCodigoTipo("TIPO")
                .setData("20180101")
                .setDesignacao("DESIGNACAO")
                .setEmissor("EMISSOR")
                .setId(1234)
                .setIdIndividuo(123)
                .setCertidao(c)
                .setTituloEleitoral(t)
                .build();
        
        return id;
    }
}