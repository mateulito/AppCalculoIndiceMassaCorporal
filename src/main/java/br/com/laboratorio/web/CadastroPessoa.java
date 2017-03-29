package br.com.laboratorio.web;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.laboratorio.model.Pessoa;
import br.com.laboratorio.model.RNPessoa;

@ManagedBean(name = "cadastro")
@SessionScoped
public class CadastroPessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	private Pessoa pessoa = new Pessoa();
	
	public CadastroPessoa(){
		System.out.println("###Criando um novo ManagedBean");
	}
	
	public String actionNovo(){
		this.pessoa = new Pessoa();
		return "form_pessoa";
	}
	
	public String actionGravar(){
		new RNPessoa().gravar(pessoa);
		return "lista_pessoa";
	}

	private void definirCondicao(){
		this.pessoa.setImc(this.pessoa.getPeso() / (this.pessoa.getAltura() * pessoa.getAltura()));
				
		if (this.pessoa.getSexo().equals("Feminino")){
			//Condição do IMC para Mulher
			if (this.pessoa.getImc() < 19.1) 
				this.pessoa.setSituacao("Abaixo do peso");
			else if (this.pessoa.getImc() < 25.8)
				this.pessoa.setSituacao("No peso normal");
			else if (this.pessoa.getImc() < 27.3)
				this.pessoa.setSituacao("Marginalmente acima do peso");
			else if (this.pessoa.getImc() < 32.3)
				this.pessoa.setSituacao("Acima do peso ideal");
			else
				this.pessoa.setSituacao("Obeso");
		} else if (this.pessoa.getSexo().equals("Masculino")){
		//Condição do IMC para Homem
			if (this.pessoa.getImc() < 20.7) 
				this.pessoa.setSituacao("Abaixo do peso");
			else if (this.pessoa.getImc() < 26.4)
				this.pessoa.setSituacao("No peso normal");
			else if (this.pessoa.getImc() < 27.8)
				this.pessoa.setSituacao("Marginalmente acima do peso");
			else if (this.pessoa.getImc() < 31.1)
				this.pessoa.setSituacao("Acima do peso ideal");
			else
				this.pessoa.setSituacao("Obeso");
		}
	}
	
	public String actionShowResultado(){
		this.definirCondicao();
		return "show_resultado";
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
