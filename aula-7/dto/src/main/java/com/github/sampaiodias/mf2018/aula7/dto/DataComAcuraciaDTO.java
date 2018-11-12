/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula7.dto;

import com.github.sampaiodias.mf2018.aula7.LocalDateXmlAdapter;
import java.time.LocalDate;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Lucas Sampaio Dias
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataComAcuraciaDTO {

    @XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
    private LocalDate data;
    private String acuracia;

    public final String getAcuracia() {
        return acuracia;
    }

    public final LocalDate getData() {
        return data;
    }

    public final void setAcuracia(final String newAcuracia) {
        acuracia = newAcuracia;
    }

    public final void setData(final LocalDate newData) {
        data = newData;
    }
}
