package com.github.sampaiodias.mf2018.aula7;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

public class LocalDateJsonDeserializer implements JsonDeserializer<LocalDate> {

    private static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.BASIC_ISO_DATE;

    @Override
    public LocalDate deserialize(final JsonElement json, final Type date,
            final JsonDeserializationContext context) {

        return LocalDate.parse(json.getAsString(), DATE_FORMATTER);
    }

}