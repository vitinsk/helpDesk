package com.desk.helpdesk;

import java.util.Arrays;
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
		Usuario usuario1 = new Usuario("Igor", "igorhenrioli@gmail.com", pe.encode("123"));
		Usuario responsavel = new Usuario("Responsável", "teste@hotmail.com", pe.encode("123"));
		usuario = usuarioRepository.save(usuario);
		usuarioRepository.saveAll(Arrays.asList(usuario1));
		responsavel.addPerfil(Perfil.RESPONSAVEL);
		responsavel.addPerfil(Perfil.ADMIN);
		responsavel = usuarioRepository.save(responsavel);
		
		Sla sla = new Sla("Bug", 30d, 50d);
		sla = slaRepository.save(sla);
		
		
		Servico servico = new Servico("Análise de Erros", responsavel, sla);
		Servico servico1 = new Servico("Análise de Performace", responsavel, sla);
		Servico servico2 = new Servico("Backup de Banco de Dados", responsavel, sla);
		Servico servico3 = new Servico("Conceder/Alterar Permissões", responsavel, sla);
		Servico servico4 = new Servico("Criação de Banco de Dados", responsavel, sla);
		Servico servico5 = new Servico("Criação de Monitoramento", responsavel, sla);
		Servico servico6 = new Servico("Criação de Usuários", responsavel, sla);
		Servico servico7 = new Servico("Criação/Configuração de Instâncias", responsavel, sla);
		Servico servico8 = new Servico("Deletar Banco de Dados", responsavel, sla);
		Servico servico9 = new Servico("Deletar Instância", responsavel, sla);
		Servico servico10 = new Servico("Executar Script", responsavel, sla);
		Servico servico11 = new Servico("Otimizar Queries", responsavel, sla);
		Servico servico12 = new Servico("Otimização de Recursos", responsavel, sla);
		Servico servico13 = new Servico("Restore de Banco de Dados", responsavel, sla);
		servico = servicoRepository.save(servico);
		servicoRepository.saveAll(Arrays.asList(servico,servico2,servico3,servico4,servico5,servico6,servico7,servico8,servico9,servico10,servico11,servico12,servico13));
		
		Chamado chamado = new Chamado("Boas vindas", "Mensagem de boas vindas", usuario, servico);
		chamado = chamadoRepository.save(chamado);
				
		Mensagem mensagem = new Mensagem(chamado.getObservacao(), new Date(), chamado);
		mensagemRepository.save(mensagem);
	}

}
