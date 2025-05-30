package com.backEnd.AtacadoEletronico.entities;

import jakarta.persistence.*;

@Entity
public class nfItem {

    @EmbeddedId
    private nfItemCompost id;

    @ManyToOne
    @MapsId("numNf") // nome do campo dentro de NfItemId
    @JoinColumn(name = "numNf")
    private nfHeader nfHeader;

    @ManyToOne
    @MapsId("idItem") // nome do campo dentro de NfItemId
    @JoinColumn(name = "idItem")
    private Item item;

    private String codItem;

    // getters/setters
    public nfItemCompost getId() {
        return id;
    }

    public void setId(nfItemCompost id) {
        this.id = id;
    }

    public nfHeader getNfHeader() {
        return nfHeader;
    }

    public void setNfHeader(nfHeader nfHeader) {
        this.nfHeader = nfHeader;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getCodItem() {
        return codItem;
    }

    public void setCodItem(String codItem) {
        this.codItem = codItem;
    }
}

