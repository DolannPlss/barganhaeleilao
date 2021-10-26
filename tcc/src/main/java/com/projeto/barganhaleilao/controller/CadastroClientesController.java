package com.projeto.barganhaleilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.barganhaleilao.model.Clientes;
import com.projeto.barganhaleilao.repository.ClientesInterface;

@Controller
public class CadastroClientesController {
	
	@Autowired
	private ClientesInterface clientesInterface;
	
	@RequestMapping("/cadastro/cliente")
	public String novo() {
		return "CadastroClientes";
	}

	@RequestMapping(value="/cadastro/cliente", method=RequestMethod.POST)
	public ModelAndView salvar(Clientes clientes) {
		ModelAndView mv = new ModelAndView("CadastroClientes");
		clientesInterface.save(clientes);
		mv.addObject("mensagem", "Cliente cadastrado com sucesso!");
		return mv;
	}
	
	
	
	
	
	
	@RequestMapping(value="/pesquisa", method=RequestMethod.GET)
	public ModelAndView pesquisaCliente(Clientes clientes) {
		ModelAndView mv = new ModelAndView("PesquisaClientes");
		List<Clientes> todosClientes = clientesInterface.findAll();
		mv.addObject("clientes", todosClientes);
		return mv;
	}
}