/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import mb.Mutante;
import mb.Usuario;
import mb.Habilidade;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Michael
 */
@Path("mutantesWS")
public class MutantesResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of MutantesResource
     */
    public MutantesResource() {
    }

    /**
     * Retrieves representation of an instance of ws.MutantesResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    @GET
    @Path("/usuario")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario getUsuario(@QueryParam("login") String login, @QueryParam("password") String password){
        //query select usuario
        Usuario u = new Usuario();
        u.setUser_id(1); //id do banco
        u.setLogin("ana"); //login do banco
        u.setPassword("1234"); //password do banco
        return u;
        //lado cliente pag 84 dos slides
    }

    /**
     * PUT method for updating or creating an instance of MutantesResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mutante insertMutante(Mutante m) {
        m.setNome("Noturno");
        m.setUser_id(1);
        m.setHability_id(1);
        //m.setImage();
        return m;
    }
   
}
