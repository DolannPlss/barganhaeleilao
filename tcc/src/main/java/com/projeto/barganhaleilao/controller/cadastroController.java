package com.projeto.barganhaleilao.controller;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	public ModelAndView salvar( CadProduto cadProduto, @RequestParam ("imagem") MultipartFile file) {
		ModelAndView mv =new ModelAndView("CadastroObjeto");

		try {
			FileUploadUtil.saveFile("C:\\upload",file.getOriginalFilename(),file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cadProduto.setCaminho("C:\\upload\\"+file.getOriginalFilename());
		produtos.save(cadProduto);
		mv.addObject("mensagem", "Produto salvo com sucesso!");
		return mv;
	}

}
