/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula8;
import java.sql.*;
import java.util.ArrayList;

/**
 * Conecta no banco de dados MySQL do Loinc e disponibiliza uma série de
 * métodos para consulta ao banco.
 * 
 * É necessário inciar o banco antes de utilizar esta aplicação. Para mais
 * informações, leia o README do projeto.
 * @author Lucas Sampaio Dias
 */
public class Loinc {
    
    private final String user;
    private final String password;
    
    public Loinc(String user, String password) {
        this.user = user;
        this.password = password;
    }
    
    private Connection connectToDatabase() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loinc_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", this.user, this.password);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ResultSet query(String mysqlQuery) {
        try {
            Connection conn = connectToDatabase();
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(mysqlQuery);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<LoincObject> getLoincs(ResultSet result) throws SQLException {
        ArrayList<LoincObject> list = new ArrayList<>();
        while(result.next()) {
            list.add(new LoincObject(result));
        }        
        return list;
    }
}
