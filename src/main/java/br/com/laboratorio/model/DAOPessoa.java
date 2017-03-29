package br.com.laboratorio.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.laboratorio.util.ConnectionFactory;

public class DAOPessoa extends ConnectionFactory {

	public List<Pessoa> selectAll(){
		List<Pessoa> lsPessoas = null;
		Connection conexao = null;
		PreparedStatement psSelectAll = null;
		ResultSet rsSelectAll = null;
		String sql = "SELECT id, nome, altura, sexo, peso, imc, situacao FROM pessoa";
		
		try {
			conexao = getConnection();
			psSelectAll = conexao.prepareStatement(sql);
			rsSelectAll = psSelectAll.executeQuery();
			lsPessoas = new ArrayList<>();
			while (rsSelectAll.next()){
				Pessoa p = new Pessoa();
				p.setId(rsSelectAll.getLong("id"));
				p.setNome(rsSelectAll.getNString("nome"));
				p.setSexo(rsSelectAll.getNString("sexo"));
				p.setAltura(rsSelectAll.getFloat("altura"));
				p.setPeso(rsSelectAll.getFloat("peso"));
				p.setImc(rsSelectAll.getFloat("imc"));
				p.setSituacao(rsSelectAll.getNString("situacao"));
				lsPessoas.add(p);
			}
			
		}catch (Exception e){
			System.err.println("------------------------------");
			System.err.println("Erro no selectAll: " + e.getMessage());
			e.printStackTrace();
		}
		
		return lsPessoas;
	}
	
	public void insert(Pessoa pessoa){
		Connection conexao = null;
		PreparedStatement psInsert = null;
		String sql = "INSERT INTO pessoa (nome, altura, sexo, peso, imc, situacao) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			conexao = getConnection();
			psInsert = conexao.prepareStatement(sql);
			psInsert.setString(1, pessoa.getNome());
			psInsert.setFloat(2, pessoa.getAltura());
			psInsert.setString(3, pessoa.getSexo());
			psInsert.setFloat(4, pessoa.getPeso());
			psInsert.setFloat(5, pessoa.getImc());
			psInsert.setString(6, pessoa.getSituacao());
			psInsert.executeUpdate();
		} catch (Exception e){
			System.err.println("------------------------------");
			System.err.println("Erro no insert: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
