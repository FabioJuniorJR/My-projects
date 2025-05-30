package com.backEnd.AtacadoEletronico.entities;


import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class nfItemCompost implements Serializable {

    private Integer numNf;
    private Integer idItem;

    public nfItemCompost() {}

    public nfItemCompost(Integer numNf, Integer idItem) {
        this.numNf = numNf;
        this.idItem = idItem;
    }

    // getters/setters
    public Integer getNumNf() {
        return numNf;
    }

    public void setNumNf(Integer numNf) {
        this.numNf = numNf;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    // equals e hashCode (importante!)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof nfItemCompost)) return false;
        nfItemCompost that = (nfItemCompost) o;
        return Objects.equals(numNf, that.numNf) &&
               Objects.equals(idItem, that.idItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numNf, idItem);
    }
}
