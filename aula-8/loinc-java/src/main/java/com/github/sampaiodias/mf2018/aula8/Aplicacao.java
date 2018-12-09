/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula8;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lucas Sampaio Dias
 */
public class Aplicacao {

    public static void main(String args[]) throws SQLException {
        Loinc loinc = new Loinc("root", "123456");
        ResultSet r = loinc.query("select * from LoincCore");
        while(r.next()) {
            System.out.println(r.getString("LOINC_NUM") + " " + 
                    r.getString("COMPONENT"));
        }
    }
}