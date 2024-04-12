package com.courseJava.Project.entities.enums;

public enum OrderStatus {
	WAITING_PAYMENT("Aguardando Pagamento"), // Aguardando Pagamento
	PAID("Pago"), // Pago
	SHIPPED("Enviado"), 
	DELIVERED("Entregue"),
	CANCELED("Cancelado"); //Cancelado

	private String code;

	private OrderStatus(String code) {
		this.code = code;
	}

	public String getCode() { //Retorna ID da Ordem de Status
		return code;
	}

	public static OrderStatus value(String code) { // Retorna o valor do tipo de Status utilizando metodo getCode();
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invaliud OrderStatus code");
	}
}
