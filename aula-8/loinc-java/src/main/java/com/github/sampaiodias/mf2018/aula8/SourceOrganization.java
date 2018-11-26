/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula8;

/**
 *
 * @author Lucas Sampaio Dias
 */
public class SourceOrganization {
    public String copyrightId;
    public String name;
    public String copyright;
    public String termsOfUse;
    public String url;
    
    public SourceOrganization(String copyrightId, String name, String copyright, 
            String termsOfUse, String url) {
        this.copyrightId = copyrightId;
        this.name = name;
        this.copyright = copyright;
        this.termsOfUse = termsOfUse;
        this.url = url;
    }
}
