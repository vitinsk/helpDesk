package com.desk.helpdesk.model.enums;

public enum Status {

	FINALIZADO(1, "Finalizado"),
	PENDENTE(2, "Pendente"),
	TRABALHANDO(3, "Trabalhando"),
	AGUARDANDO(4, "Aguardando"),
	ABERTO(5, "Aberto");
	
	
	private int cod;
	private String descricao;

	private Status(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static Status toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(Status x: Status.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
	throw new IllegalArgumentException("ID Inválido: "+ cod);
	}
	
}
