package com.desk.helpdesk.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tb_sla")
public class Sla  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    
    private String descricao;
    
    @Column(name = "tempo_resposta")
    private Double tempoResposta;
    
    @Column(name = "tempo_finalizacao")
    private Double tempoFinalizacao;

    public Sla() {}
    
    
    
	public Sla(String descricao, Double tempoResposta, Double tempoFinalizacao) {
		super();
		this.descricao = descricao;
		this.tempoResposta = tempoResposta;
		this.tempoFinalizacao = tempoFinalizacao;
	}



	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getTempoResposta() {
		return tempoResposta;
	}

	public void setTempoResposta(Double tempoResposta) {
		this.tempoResposta = tempoResposta;
	}

	public Double getTempoFinalizacao() {
		return tempoFinalizacao;
	}

	public void setTempoFinalizacao(Double tempoFinalizacao) {
		this.tempoFinalizacao = tempoFinalizacao;
	}
    
    
    
}
