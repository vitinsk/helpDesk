package com.desk.helpdesk.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "tb_mensagem")
public class Mensagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    
    private String mensagem;
    
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date data;
    
    @ManyToOne
    private Usuario usuario;
    
    @ManyToOne
    private Chamado chamado;

    public Mensagem() {
    	this.data = new Date();
    }
    
	public Mensagem(String mensagem, Date data, Chamado chamado, Usuario usuario) {
		super();
		this.mensagem = mensagem;
		this.data = data;
		this.chamado = chamado;
		this.usuario = usuario;
	}



	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Chamado getChamado() {
		return chamado;
	}

	public void setChamado(Chamado chamado) {
		this.chamado = chamado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
    
    
    
}
