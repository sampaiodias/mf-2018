package com.github.sampaiodias.mf2018.aula7;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateXmlAdapter extends XmlAdapter<String, LocalDate> {

    private static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.BASIC_ISO_DATE;

    @Override
    public LocalDate unmarshal(final String v) throws Exception {
        return LocalDate.parse(v, DATE_FORMATTER);
    }

    @Override
    public String marshal(final LocalDate v) throws Exception {
        return v.format(DATE_FORMATTER);
    }
}