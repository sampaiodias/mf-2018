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
        loinc = new Loinc("root", "123456");
    }
    
    @Test
    public void testTodosOsLoincs() throws Exception {
        ArrayList<LoincObject> list = loinc.getTodosOsLoincs();
        assertEquals(list.size(), 87863);
    }
    
    @Test
    public void testProcurarPeloNumero() throws Exception {
        ArrayList<LoincObject> actual = loinc.procurarPeloNumero("12345");
        
        ArrayList<LoincObject> expected = new ArrayList<>();
        expected.add(new LoincObject("12345-5", "", "", "", "", "", "", "", 0, "", "", "", "", "", ""));
        
        assertEquals(actual.get(0).number, expected.get(0).number);
    }
    
    @Test
    public void testProcurarPeloComponente() throws Exception {
        ArrayList<LoincObject> actual = loinc.procurarPeloComponente("R wave duration.lead A");
        
        ArrayList<LoincObject> expected = new ArrayList<>();
        expected.add(new LoincObject("", "R wave duration.lead AVR", "", "", "", "", "", "", 0, "", "", "", "", "", ""));
        
        assertEquals(actual.get(0).component, expected.get(0).component);
    }
    
}
