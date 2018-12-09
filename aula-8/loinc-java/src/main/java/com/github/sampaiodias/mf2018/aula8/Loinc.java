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
    
    private final String usuario;
    private final String senha;
    private final String url;
    
    /**
     * Cria uma instância válida para utilização do banco de dados Loinc.
     * @param usuario Usuário do MySQL configurado na máquina.
     * @param senha Senha do Usuário informado.
     * @param url URL para o banco de dados (ex.: localhost:3306).
     */
    public Loinc(String usuario, String senha, String url) {
        this.usuario = usuario;
        this.senha = senha;
        this.url = url;
    }
    
    private Connection conectarAoBanco() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://" + url + "/loinc_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", this.usuario, this.senha);
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
        PreparedStatement statement = conectarAoBanco().prepareStatement(sql);
        return Loinc.this.getLoincs(statement.executeQuery());
    }
    
    /**
     * Procura todos os Loincs que correspondam ao número especificado.
     * @param numero
     * @return
     * @throws SQLException 
     */
    public ArrayList<LoincObject> procurarPeloNumero(String numero) throws SQLException {
        String sql = "select * from LoincCore where LOINC_NUM LIKE ?";
        PreparedStatement statement = conectarAoBanco().prepareStatement(sql);
        statement.setString(1, "%" + numero + "%");
        return Loinc.this.getLoincs(statement.executeQuery());
    }
    
    /**
     * Procura todos os Loincs que correspondam ao componente especificado.
     * @param componente
     * @return
     * @throws SQLException 
     */
    public ArrayList<LoincObject> procurarPeloComponente(String componente) throws SQLException {
        String sql = "select * from LoincCore where COMPONENT LIKE ?";
        PreparedStatement statement = conectarAoBanco().prepareStatement(sql);
        statement.setString(1, "%" + componente + "%");
        return Loinc.this.getLoincs(statement.executeQuery());
    }    
    
    /**
     * Procura todos os Loincs que correspondam ao nome especificado.
     * @param nome
     * @return
     * @throws SQLException 
     */
    public ArrayList<LoincObject> procurarPeloNome(String nome) throws SQLException {
        String sql = "select * from LoincCore where LONG_COMMON_NAME LIKE ?";
        PreparedStatement statement = conectarAoBanco().prepareStatement(sql);
        statement.setString(1, "%" + nome + "%");
        return Loinc.this.getLoincs(statement.executeQuery());
    }  
    
}
