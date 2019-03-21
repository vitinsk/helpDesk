package com.desk.helpdesk;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.desk.helpdesk.model.Chamado;
import com.desk.helpdesk.model.Mensagem;
import com.desk.helpdesk.model.Servico;
import com.desk.helpdesk.model.Sla;
import com.desk.helpdesk.model.Usuario;
import com.desk.helpdesk.model.enums.Perfil;
import com.desk.helpdesk.repository.ChamadoRepository;
import com.desk.helpdesk.repository.MensagemRepository;
import com.desk.helpdesk.repository.ServicoRepository;
import com.desk.helpdesk.repository.SlaRepository;
import com.desk.helpdesk.repository.UsuarioRepository;

@SpringBootApplication
public class HelpDeskApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(HelpDeskApplication.class, args);
    }

    @Autowired private UsuarioRepository usuarioRepository;
    @Autowired private MensagemRepository mensagemRepository;
    @Autowired private SlaRepository slaRepository;
    @Autowired private ChamadoRepository chamadoRepository;
    @Autowired ServicoRepository servicoRepository;
    @Autowired	private BCryptPasswordEncoder pe;
    
	@Override
	public void run(String... args) throws Exception {
		Usuario usuario = new Usuario("Vitor", "vitinsk@hotmail.com", pe.encode("123"));
		Usuario responsavel = new Usuario("Responsável", "teste@hotmail.com", pe.encode("123"));
		usuario = usuarioRepository.save(usuario);
		
		responsavel.addPerfil(Perfil.RESPONSAVEL);
		responsavel.addPerfil(Perfil.ADMIN);
		responsavel = usuarioRepository.save(responsavel);
		
		Sla sla = new Sla("Bug", 30d, 50d);
		sla = slaRepository.save(sla);
		
		
		Servico servico = new Servico("Financeiro", responsavel, sla);
		servico = servicoRepository.save(servico);
		
		Chamado chamado = new Chamado("Boas vindas", "Mensagem de boas vindas", usuario, servico);
		chamado = chamadoRepository.save(chamado);
				
		Mensagem mensagem = new Mensagem(chamado.getObservacao(), new Date(), chamado);
		mensagemRepository.save(mensagem);
	}

}
