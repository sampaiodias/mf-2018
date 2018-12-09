/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula8;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Lucas Sampaio Dias
 */
public class LoincTest {
    
    private static Loinc loinc;
    
    public LoincTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        loinc = new Loinc("root", "123456");
    }

    @Test
    public void testQuery() throws SQLException {
        ResultSet r = loinc.query("select * from LoincCore where LOINC_NUM = '10000-8'");
        r.next();
        assertEquals("R wave duration.lead AVR", r.getString("COMPONENT"));
    }
    
    @Test
    public void testGetLoincs() throws SQLException {
        ResultSet r = loinc.query("select * from LoincCore where LOINC_NUM = '10000-8'");
        ArrayList<LoincObject> list = loinc.getLoincs(r);
        assertEquals("R wave duration.lead AVR", list.get(0).component);
    }
    
}
