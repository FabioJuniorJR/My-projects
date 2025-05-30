package com.backEnd.AtacadoEletronico.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

//Colocamos @Embeddable pois marca uma classe que será usado como parte de outra entidade, ou seja, nao vira uma tabela sozinha mas é inserida(embutida) dentro de outra tabela.
//Usamos isso para CHAVE COMPOSTA(2 FKs viram uma PK)
@Embeddable
public class ItemsOrderCompost implements Serializable {
	private int idItem;
	private int numOrder;
	
	public ItemsOrderCompost() {}

	public ItemsOrderCompost(int idItem, int numOrder) {
		super();
		this.idItem = idItem;
		this.numOrder = numOrder;
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdIte(int idItem) {
		this.idItem = idItem;
	}

	public int getNumOrder() {
		return numOrder;
	}

	public void setNumOrder(int numOrder) {
		this.numOrder = numOrder;
	}
	
	// equals e hashCode (importante!)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemsOrderCompost)) return false;
        ItemsOrderCompost that = (ItemsOrderCompost) o;
        return Objects.equals(idItem, that.idItem) &&
               Objects.equals(numOrder, that.numOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idItem, numOrder);
    }
	
	
	
}
