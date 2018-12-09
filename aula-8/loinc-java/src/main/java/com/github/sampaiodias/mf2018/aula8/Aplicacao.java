/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula8;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lucas Sampaio Dias
 */
public class Aplicacao {

    public static void main(String args[]) throws SQLException {
        Loinc loinc = new Loinc("root", "123456");
        ArrayList<LoincObject> list = loinc.getTodosOsLoincs();
        for (LoincObject obj : list) {
            System.out.println(obj.number + " " + obj.commonName);
        }
    }
}