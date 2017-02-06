package br.com.paginacao.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EnviadorEmail {
	
	@Autowired
	private JavaMailSender javaMailSender;
	private final static String SITE = "http://localhost:8080/";
	private final static String EMAIL_PADRAO = "mydocteste@gmail.com";
	
	public void enviarEmailConfirmacaoCadastro(String nome, String emailDestino){
		try {	
			StringBuffer corpo = new StringBuffer();
			corpo.append("Olá Dr(a). ");
			corpo.append(nome);
			corpo.append(", \n");
			corpo.append("Gostaríamos de agradecer o seu interesse em fazer parte do Mydoc! \n");
			corpo.append("O seu cadastro foi enviado para nossa equipe e após a validação ");
			corpo.append("dos pré-requisitos você receberá um novo e-mail com orientações para ");
			corpo.append("continuar a sua ativação. \n");
			corpo.append("Caso necessário, contato telefônico poderá ser feito para esclarecimentos. \n");
			corpo.append("Atenciosamente, \n");
			corpo.append("Equipe Mydoc!");
			
			SimpleMailMessage email = new SimpleMailMessage();
			email.setTo(emailDestino);
			email.setFrom(EMAIL_PADRAO);
			email.setSubject("Confirmacao");
			email.setText(corpo.toString());
			javaMailSender.send(email);
	
	  	} catch (MailException e) {
	  		e.printStackTrace();
	  	}
	}
	public void enviarEmailAtivacao(String nome, String emailDestino,String login, String senha){
		try {	
			StringBuffer corpo = new StringBuffer();
			corpo.append("Olá Dr(a). ");
			corpo.append(nome);
			corpo.append(", \nGostaríamos de informar que seu perfil foi aceito!\n");
			corpo.append("Acesso: ");
			corpo.append(SITE);
			corpo.append("\nLogin: ");
			corpo.append(login);
			corpo.append("\nSenha: ");
			corpo.append(senha);
			corpo.append("\nAtenção, esta senha é temporária. Por favor, altere a mesma assim que possivel.\n");
			corpo.append("Atenciosamente, \nEquipe Mydoc!");
			
			SimpleMailMessage email = new SimpleMailMessage();
			email.setTo(emailDestino);
			email.setFrom(EMAIL_PADRAO);
			email.setSubject("MyDoc");
			email.setText(corpo.toString());
			javaMailSender.send(email);
			
		} catch (MailException e) {
			e.printStackTrace();
		}
	}
}
