// TODO: eliminar los comentarios por defecto
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.habitaciones.resources;

import co.edu.uniandes.csw.habitaciones.dtos.MultaDTO;
import co.edu.uniandes.csw.habitaciones.ejbs.MultaLogic;
import co.edu.uniandes.csw.habitaciones.entities.MultaEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
// TODO: eliminar los import que no se usan
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/multas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MultaResource {
    
    @Inject private MultaLogic multaLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("limit") private Integer maxRecords;
    
    private List<MultaDTO> listEntity2DTO (List<MultaEntity> entityList){
        List<MultaDTO> list= new ArrayList<>();
        for (MultaEntity entity : entityList){
            list.add(new MultaDTO(entity));
        }    
        return list;
    }

    // TODO: implementar un constructor por defecto
    // TODO: implementar los métodos del recurso
    
}