package com.desk.helpdesk.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



import com.desk.helpdesk.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "tb_chamado")
public class Chamado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private String titulo;
    private Date data;
    @Column(name = "data_fim")
    private Date dataFim;
    private String observacao;
   
   
   @Enumerated(EnumType.STRING)
    private Status status;
   
    @ManyToOne
    private Usuario usuario;
   
    @ManyToOne
    private Servico servico;
	
    @JsonIgnore
	@OneToMany(mappedBy = "chamado")
    List<Mensagem> mensagens = new ArrayList<>();

    public Chamado() {}
    
    
    
	public Chamado(String titulo, String observacao, Usuario usuario,
			Servico servico) {
		super();
		this.titulo = titulo;
		this.data = new Date();
		this.observacao = observacao;
		this.status = Status.ABERTO;
		this.usuario = usuario;
		this.servico = servico;
	}



	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public List<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
    
    
    
    
    
}
