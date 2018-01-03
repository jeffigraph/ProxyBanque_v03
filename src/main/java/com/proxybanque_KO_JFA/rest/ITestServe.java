package com.proxybanque_KO_JFA.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.proxybanque_KO_JFA.entity.Client;
import com.proxybanque_KO_JFA.entity.Conseiller;

@Path("/Services")
public interface ITestServe {
	
	@GET
	@Path("/clients/{idcli}")
	@Produces(MediaType.APPLICATION_JSON)
	public Client getClientById(@PathParam (value="id=Cli") Long idCli);
	
	@GET
	@Path("/clients")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> listClient();
	
	@GET
	@Path("/conseiller/{login}/{psw}")
	@Produces(MediaType.APPLICATION_JSON)
	public Conseiller login(@PathParam("login") String login, @PathParam("psw") String psw);
}
