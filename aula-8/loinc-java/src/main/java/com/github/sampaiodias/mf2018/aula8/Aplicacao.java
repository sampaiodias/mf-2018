/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula8;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Lucas Sampaio Dias
 */
@SpringBootApplication
public class Aplicacao implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Aplicacao.class);

    public static void main(String args[]) {
        SpringApplication.run(Aplicacao.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {
        criarTabelas();
        //popularTabelas();
        popularTabelasDeTeste();
        
        jdbcTemplate.query("SELECT * FROM SourceOrganization",
            (rs, rowNum) -> new SourceOrganization(rs.getString("copyright_id"), rs.getString("name"), "", "", "")
                ).forEach(organization -> log.info(organization.name + " " + organization.copyrightId));
    }

    private void criarTabelas() throws DataAccessException {
        jdbcTemplate.execute(getFile("sql/MySqlDdl.sql"));
    }
    
    private void popularTabelas() {
        jdbcTemplate.execute(getFile("sql/MySqlLoader.sql"));
    }

    private void popularTabelasDeTeste() throws DataAccessException {
        List<Object[]> orgs = new ArrayList<>();
        orgs.add(new Object[]{"1", "Teste A", "www.google.com"});
        orgs.add(new Object[]{"2", "Teste B", "www.google.com"});
        orgs.add(new Object[]{"3", "Teste C", "www.google.com"});
        orgs.add(new Object[]{"4", "Teste D", "www.google.com"});
        
        jdbcTemplate.batchUpdate("INSERT INTO SourceOrganization "
                + "(copyright_id, name, url) VALUES (?, ?, ?)", orgs);
    }
    
    private String getFile(String fileName) {

	StringBuilder result = new StringBuilder("");

	//Get file from resources folder
	ClassLoader classLoader = getClass().getClassLoader();
	File file = new File(classLoader.getResource(fileName).getFile());

	try (Scanner scanner = new Scanner(file)) {

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			result.append(line).append("\n");
		}

		scanner.close();

	} catch (IOException e) {
	}
	
	return result.toString();
    }
}