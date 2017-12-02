package br.edu.utfpr.cep.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.utfpr.cep.model.Cidade;
import br.edu.utfpr.cep.model.Estado;
import br.edu.utfpr.cep.model.Zone;

public class ZoneDAO {
	
	public List<Zone> zonePorEstado(String sigla) throws SQLException{
		Statement stmt = Conexao.getInstance().getConexao().createStatement();
		ResultSet rs = stmt.executeQuery("SELECT zone.iso, zone.title FROM zone JOIN state ON state.id=zone.id_state WHERE state.letter='" + sigla + "'");
		List<Zone> list = new ArrayList<Zone>();
		
		while(rs.next()){
			Zone e = new Zone();
			
			e.setCode(rs.getString("iso"));
			e.setTitle(rs.getString("title"));			
			list.add(e);
		}
		
		return list;
	}
	
	public List<Cidade> cidadePorCodigo(String codigo) throws SQLException{
		Statement stmt = Conexao.getInstance().getConexao().createStatement();
		ResultSet rs = stmt.executeQuery("SELECT title FROM city WHERE iso_ddd='" + codigo + "'");
		List<Cidade> list = new ArrayList<Cidade>();
		
		while(rs.next()){
			Cidade e = new Cidade();
			e.setNome(rs.getString("title"));			
			list.add(e);
		}
		
		return list;
	}
}
