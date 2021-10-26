package com.projeto.barganhaleilao.controller;

import java.util.List;

import com.projeto.barganhaleilao.model.CadProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.projeto.barganhaleilao.repository.Produtos;

@Controller



public class pesquisaController {
	
	@Autowired
	private Produtos prod;
    
 
    
//    @RequestMapping("/produto/pesquisa")
//	public String pesquisa() {
//		return "PesquisaClientes";
//	}
    
    
	@RequestMapping(value="/produto/pesquisa")
	public ModelAndView pesquisar() {
		List<CadProduto> todosObjetos = prod.findAll();
		ModelAndView mv = new ModelAndView("PesquisaProdutos");
		mv.addObject("Produtos", todosObjetos);
		return mv;
	}
}
