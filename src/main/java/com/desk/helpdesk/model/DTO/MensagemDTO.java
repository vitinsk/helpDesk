package com.desk.helpdesk.model.DTO;

import java.util.Date;

import javax.persistence.ManyToOne;

import com.desk.helpdesk.model.Chamado;
import com.desk.helpdesk.model.Mensagem;
import com.desk.helpdesk.model.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;

public class MensagemDTO {

    private Integer codigo;
    
    private String mensagem;
    
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date data;

    private Integer usuarioCodigo;
    private String usuarioNome;

    private Integer chamadoCodigo;
    private String chamadoTitulo;
    
    
    
    public MensagemDTO(Mensagem msg) {
		super();
		this.codigo = msg.getCodigo();
		this.mensagem = msg.getMensagem();
		this.data = msg.getData();
		this.usuarioCodigo = (msg.getUsuario() == null) ? null : msg.getUsuario().getCodigo();
		this.usuarioNome = (msg.getUsuario() == null) ? null : msg.getUsuario().getNome();
		this.chamadoCodigo = msg.getChamado().getCodigo();
		this.chamadoTitulo = msg.getChamado().getTitulo();
	}

	public MensagemDTO() {
    	
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
	public Integer getUsuarioCodigo() {
		return usuarioCodigo;
	}
	public void setUsuarioCodigo(Integer usuarioCodigo) {
		this.usuarioCodigo = usuarioCodigo;
	}
	public String getUsuarioNome() {
		return usuarioNome;
	}
	public void setUsuarioNome(String usuarioNome) {
		this.usuarioNome = usuarioNome;
	}
	public Integer getChamadoCodigo() {
		return chamadoCodigo;
	}
	public void setChamadoCodigo(Integer chamadoCodigo) {
		this.chamadoCodigo = chamadoCodigo;
	}
	public String getChamadoTitulo() {
		return chamadoTitulo;
	}
	public void setChamadoTitulo(String chamadoTitulo) {
		this.chamadoTitulo = chamadoTitulo;
	}
	
}


