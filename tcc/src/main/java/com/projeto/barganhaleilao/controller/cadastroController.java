package com.projeto.barganhaleilao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.barganhaleilao.model.CadProduto;
import com.projeto.barganhaleilao.repository.Produtos;

@Controller
@RequestMapping("/cadastroObjeto")
public class cadastroController {
	
	@Autowired
	private Produtos produtos;
	
	@RequestMapping("/novo")
	public String novo() {
		return "CadastroObjeto";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(CadProduto cadProduto) {
		ModelAndView mv =new ModelAndView("cadastroObjeto");
		produtos.save(cadProduto);
		mv.addObject("mensagem", "Produto salvo com sucesso!");
		return mv;
	}

}
