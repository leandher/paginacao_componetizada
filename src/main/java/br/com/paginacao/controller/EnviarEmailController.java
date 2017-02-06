package main.java.br.com.paginacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import main.java.br.com.paginacao.util.EnviadorEmail;

@CrossOrigin("*")
@RequestMapping("/enviar-email")
@Controller
public class EnviarEmailController {
	@Autowired
	private EnviadorEmail sender;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<HttpStatus> send(){
		sender.enviarEmailAtivacao("Leandher", "leandher_bessa@hotmail.com", "teste", "teste");
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
