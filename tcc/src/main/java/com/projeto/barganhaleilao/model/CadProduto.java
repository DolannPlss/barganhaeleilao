package com.projeto.barganhaleilao.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.NumberFormat;

@Entity
public class CadProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Codigo;
	private String Produto;
	
	@NumberFormat(pattern = "#,##0.00")
	private double Preco;
	private String Descricao;
	
	@Enumerated(EnumType.STRING)
	private StatusVenda Status;
	
	public long getCodigo() {
		return Codigo;
	}
	public void setCodigo(long codigo) {
		Codigo = codigo;
	}
	public String getProduto() {
		return Produto;
	}
	public void setProduto(String produto) {
		Produto = produto;
	}
	public double getPreco() {
		return Preco;
	}
	public void setPreco(double preco) {
		Preco = preco;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public StatusVenda getStatus() {
		return Status;
	}
	public void setStatus(StatusVenda status) {
		Status = status;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Codigo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CadProduto other = (CadProduto) obj;
		return Codigo == other.Codigo;
	}

	
}
