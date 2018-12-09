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
    
    /**
     * Obtém todos os Loincs contidos em um ResultSet.
     * @param result
     * @return
     * @throws SQLException 
     */
    public ArrayList<LoincObject> getLoincs(ResultSet result) throws SQLException {
        ArrayList<LoincObject> list = new ArrayList<>();
        while(result.next()) {
            list.add(new LoincObject(result));
        }        
        return list;
    }
    
    /**
     * Obtém todos os Loincs cadastrados no banco de dados.
     * @return
     * @throws SQLException 
     */
    public ArrayList<LoincObject> getTodosOsLoincs() throws SQLException {
        String sql = "select * from LoincCore";
        PreparedStatement statement = connectToDatabase().prepareStatement(sql);
        return Loinc.this.getLoincs(statement.executeQuery());
    }
    
    /**
     * Procura todos os Loincs que correspondam ao número especificado.
     * @param loincNumber
     * @return
     * @throws SQLException 
     */
    public ArrayList<LoincObject> procurarPeloNumero(String loincNumber) throws SQLException {
        String sql = "select * from LoincCore where LOINC_NUM LIKE ?";
        PreparedStatement statement = connectToDatabase().prepareStatement(sql);
        statement.setString(1, "%" + loincNumber + "%");
        return Loinc.this.getLoincs(statement.executeQuery());
    }
    
}
