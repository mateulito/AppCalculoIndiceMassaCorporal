package br.com.laboratorio.model;

public class RNPessoa {
	
	public void gravar(Pessoa pessoa){
		new DAOPessoa().insert(pessoa);
	}

}
