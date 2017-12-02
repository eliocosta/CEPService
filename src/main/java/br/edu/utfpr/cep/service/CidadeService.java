package br.edu.utfpr.cep.service;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.utfpr.cep.dao.CidadeDAO;
import br.edu.utfpr.cep.model.Cidade;

@Path("/cidades")
public class CidadeService {
	
	@GET // utilizando apenas o verbo GET, ou seja, vou apenas ler o recurso
	@Produces(MediaType.APPLICATION_JSON) // define qual tipo MIME é retornado para o cliente
	@Path("/listar")
	public List<Cidade> listarCidades(){
		try {
			return new CidadeDAO().listar();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GET // utilizando apenas o verbo GET, ou seja, vou apenas ler o recurso
	@Produces(MediaType.APPLICATION_JSON) // define qual tipo MIME é retornado para o cliente
	@Path("/listar/porestado/{sigla}")
	public List<Cidade> listarCidadesPorEstado(@PathParam("sigla") String sigla){
		try {
			return new CidadeDAO().listarPorEstado(sigla);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	

}
