package br.edu.utfpr.cep.service;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.utfpr.cep.dao.ZoneDAO;
import br.edu.utfpr.cep.model.Cidade;
import br.edu.utfpr.cep.model.Zone;

@Path("/zones")
public class ZoneService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listar/porestado/{sigla}")
	public List<Zone> listarCidades(@PathParam("sigla") String sigla){
		try {
			return new ZoneDAO().zonePorEstado(sigla);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listar/cidadesporcodigo/{codigo}")
	public List<Cidade> listarCidadesPorCodigo(@PathParam("codigo") String codigo){
		try {
			return new ZoneDAO().cidadePorCodigo(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
