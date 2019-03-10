package com.desk.helpdesk.model.DTO;

public class ChamadoDTO {

	private String titulo;
	private String observacao;
	private String mensagem;
	private Integer servico;
	private Integer usuario;
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public Integer getServico() {
		return servico;
	}
	public void setServico(Integer servico) {
		this.servico = servico;
	}
	public Integer getUsuario() {
		return usuario;
	}
	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
	
	
	
}
