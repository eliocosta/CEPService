package br.edu.utfpr.cep.service;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.utfpr.cep.dao.EstadoDAO;
import br.edu.utfpr.cep.model.Estado;

@Path("/estados")
public class EstadoService {

	@GET // utilizando apenas o verbo GET, ou seja, vou apenas ler o recurso
	@Produces(MediaType.APPLICATION_JSON) // define qual tipo MIME é retornado para o cliente
	@Path("/listar")
	public List<Estado> listarEstados(){
		try {
			return new EstadoDAO().listar();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
