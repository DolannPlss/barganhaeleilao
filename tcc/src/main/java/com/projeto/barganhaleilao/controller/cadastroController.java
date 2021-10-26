package com.projeto.barganhaleilao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.barganhaleilao.model.CadProduto;
import com.projeto.barganhaleilao.repository.Produtos;

@Controller
public class cadastroController {
	
	@Autowired
	private Produtos produtos;
	
	@RequestMapping("/cadastroObjeto/novo")
	public String novo() {
		return "CadastroObjeto";
	}
	
	@RequestMapping(value="/cadastroObjeto", method = RequestMethod.POST)
	public ModelAndView salvar(CadProduto cadProduto) {
		ModelAndView mv =new ModelAndView("CadastroObjeto");
		produtos.save(cadProduto);
		mv.addObject("mensagem", "Produto salvo com sucesso!");
		return mv;
	}

}
