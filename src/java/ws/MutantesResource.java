/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mb.Mutante;
import mb.Usuario;
import mb.Habilidade;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import static jdk.nashorn.internal.objects.NativeError.printStackTrace;
import sql.ConnectionFactory;

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
    public boolean getUsuario(@QueryParam("login") String login, @QueryParam("password") String password){
        try {
            //query select usuario
            Connection conn = ConnectionFactory.getConnection();
            String query = "select * from usuario where login=? and password=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, login);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return(rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(MutantesResource.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    @GET
    @Path("/habilidades") //todas as habilidades
    @Produces(MediaType.APPLICATION_JSON)
    public List<Habilidade> getHabilidades(){
        try{
            List<Habilidade> habilidades = new ArrayList<Habilidade>();
            //preencher a lista de objetos com as linhas da tabela Habilidade
            Connection conn = ConnectionFactory.getConnection();
            String queryAll = "select * from habilidade";
            PreparedStatement stmt = conn.prepareStatement(queryAll);
            ResultSet rs = stmt.executeQuery();
            try{
                while (rs.next()) {
                    Habilidade novo = new Habilidade(rs.getInt("hability_id"), rs.getString("description"));
                    habilidades.add(novo);
                }
                return (habilidades);
            } catch (SQLException e){
                printStackTrace(e);
            }
            
        } catch (SQLException ex){
            Logger.getLogger(MutantesResource.class.getName()).log(Level.SEVERE, null,ex);
            printStackTrace(ex);
        }
        return null;
        
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
    @Path("/mutante")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Integer insertMutante(@FormParam("nome") String nome, @FormParam("user_id") Integer user_id, @FormParam("hability_id") Integer hability_id) {
        try {
            Connection conn = ConnectionFactory.getConnection();
            String insertQuery = "INSERT into mutante(nome, user_id, hability_id) values (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(insertQuery);
            stmt.setString(1, nome);
            stmt.setInt(2, user_id);
            stmt.setInt(2, hability_id);
            return (stmt.executeUpdate());
        } catch (SQLException ex) {
            Logger.getLogger(MutantesResource.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
   
}
