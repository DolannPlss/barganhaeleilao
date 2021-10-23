package com.projeto.barganhaleilao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.barganhaleilao.model.CadProduto;

public interface Produtos extends JpaRepository<CadProduto, Long>{
	
}
