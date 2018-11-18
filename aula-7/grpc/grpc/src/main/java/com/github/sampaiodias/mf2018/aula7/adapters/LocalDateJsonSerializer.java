package com.github.sampaiodias.mf2018.aula7.adapters;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class LocalDateJsonSerializer implements JsonSerializer<LocalDate> {

    private static final DateTimeFormatter DATE_FORMATTER = 
            DateTimeFormatter.BASIC_ISO_DATE;

    @Override
    public JsonElement serialize(final LocalDate src, final Type typeOfSrc,
            final JsonSerializationContext context) {

        final String dateText = src.format(DATE_FORMATTER);
        return context.serialize(dateText);
    }

}