/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula8;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
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
        loinc = new Loinc("root", "123456", "localhost:3306");
    }
    
    @Test
    public void testTodosOsLoincs() throws Exception {
        ArrayList<LoincObject> list = loinc.getTodosOsLoincs();
        assertEquals(87863, list.size());
    }
    
    @Test
    public void testProcurarPeloNumero() throws Exception {
        ArrayList<LoincObject> actual = loinc.procurarPeloNumero("12345");
        
        ArrayList<LoincObject> expected = new ArrayList<>();
        expected.add(new LoincObject("12345-5", "", "", "", "", "", "", "", 0, "", "", "", "", "", ""));
        
        assertEquals(expected.get(0).number, actual.get(0).number);
    }
    
    @Test
    public void testProcurarPeloComponente() throws Exception {
        ArrayList<LoincObject> actual = loinc.procurarPeloComponente("R wave duration.lead A");
        
        ArrayList<LoincObject> expected = new ArrayList<>();
        expected.add(new LoincObject("", "R wave duration.lead AVR", "", "", "", "", "", "", 0, "", "", "", "", "", ""));
        
        assertEquals(expected.get(0).component, actual.get(0).component);
    }
    
    @Test
    public void testProcurarPeloNome() throws Exception {
        ArrayList<LoincObject> list = loinc.procurarPeloNome("CD10 cells/100 cells in");
        
        assertEquals(8, list.size());
    }
    
    @Test
    public void testProcurarPeloNomeCurto() throws Exception {
        ArrayList<LoincObject> list = loinc.procurarPeloNomeCurto("CD10 Cells NFr");
        
        assertEquals(6, list.size());
    }
    
}
