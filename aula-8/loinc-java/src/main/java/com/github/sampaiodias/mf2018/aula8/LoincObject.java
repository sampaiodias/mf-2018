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
public class LoincObject {
    public final String num;
    public final String component;
    public final String property;
    public final String timeAspect;
    public final String system;
    public final String scaleType;
    public final String methodType;
    public final String loincClass;
    public final int loincClassType;
    public final String commonName;
    public final String shortName;
    public final String externalCopyrightNotice;
    public final String status;
    public final String versionFirstReleased;
    public final String versionLastChanged;
    
    public LoincObject(
            String num, 
            String component, 
            String property, 
            String timeAspect, 
            String system, 
            String scaleType, 
            String methodType, 
            String loincClass, 
            int loincClassType, 
            String commonName, 
            String shortName, 
            String externalCopyrightNotice, 
            String status, 
            String versionFirstReleased, 
            String versionLastChanged) {
        this.num = num;
        this.component = component;
        this.property = property;
        this.timeAspect = timeAspect;
        this.system = system;
        this.scaleType = scaleType;
        this.methodType = methodType;
        this.loincClass = loincClass;
        this.loincClassType = loincClassType;
        this.commonName = commonName;
        this.shortName = shortName;
        this.externalCopyrightNotice = externalCopyrightNotice;
        this.status = status;
        this.versionFirstReleased = versionFirstReleased;
        this.versionLastChanged = versionLastChanged;
    }
    
    public LoincObject(ResultSet result) throws SQLException {
        this.num = result.getString("LOINC_NUM");
        this.component = result.getString("COMPONENT");
        this.property = result.getString("LOINC_PROPERTY");
        this.timeAspect = result.getString("TIME_ASPCT");
        this.system = result.getString("LOINC_SYSTEM");
        this.scaleType = result.getString("SCALE_TYP");
        this.methodType = result.getString("METHOD_TYP");
        this.loincClass = result.getString("LOINC_CLASS");
        this.loincClassType = result.getInt("LOINC_CLASSTYPE");
        this.commonName = result.getString("LONG_COMMON_NAME");
        this.shortName = result.getString("SHORTNAME");
        this.externalCopyrightNotice = 
                result.getString("EXTERNAL_COPYRIGHT_NOTICE");
        this.status = result.getString("STATUS");
        this.versionFirstReleased = result.getString("VersionFirstReleased");
        this.versionLastChanged = result.getString("VersionLastChanged");
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Number: ");
        builder.append(num);
        builder.append("\n");
        builder.append("Component: ");
        builder.append(component);
        builder.append("\n");
        builder.append("Property: ");
        builder.append(property);
        builder.append("\n");
        builder.append("Time Aspect: ");
        builder.append(timeAspect);
        builder.append("\n");
        builder.append("System: ");
        builder.append(system);
        builder.append("\n");
        builder.append("Scale Type: ");
        builder.append(scaleType);
        builder.append("\n");
        builder.append("Method Type: ");
        builder.append(methodType);
        builder.append("\n");
        builder.append("Class: ");
        builder.append(loincClass);
        builder.append("\n");
        builder.append("Class Type: ");
        builder.append(loincClassType);
        builder.append("\n");
        builder.append("Common Name: ");
        builder.append(commonName);
        builder.append("\n");
        builder.append("Short Name: ");
        builder.append(shortName);
        builder.append("\n");
        builder.append("Copyright: ");
        builder.append(externalCopyrightNotice);
        builder.append("\n");
        builder.append("Status: ");
        builder.append(status);
        builder.append("\n");
        builder.append("First Released Version: ");
        builder.append(versionFirstReleased);
        builder.append("\n");
        builder.append("Last Changed Version: ");
        builder.append(versionLastChanged);
        return builder.toString();
    }
}
