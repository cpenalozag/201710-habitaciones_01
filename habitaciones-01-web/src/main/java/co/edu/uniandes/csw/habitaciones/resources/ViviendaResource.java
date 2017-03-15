package co.edu.uniandes.csw.habitaciones.resources;


import co.edu.uniandes.csw.habitaciones.dtos.HabitacionDTO;
import co.edu.uniandes.csw.habitaciones.dtos.HabitacionDetailDTO;
import co.edu.uniandes.csw.habitaciones.dtos.ViviendaDTO;
import co.edu.uniandes.csw.habitaciones.dtos.ViviendaDetailDTO;
import co.edu.uniandes.csw.habitaciones.ejbs.AnfitrionLogic;
import co.edu.uniandes.csw.habitaciones.ejbs.HabitacionLogic;
import co.edu.uniandes.csw.habitaciones.ejbs.ViviendaLogic;
import co.edu.uniandes.csw.habitaciones.entities.HabitacionEntity;
import co.edu.uniandes.csw.habitaciones.entities.ViviendaEntity;
import co.edu.uniandes.csw.habitaciones.exceptions.BusinessLogicException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * @author c.penaloza
 * URI: employees/
 * @generated
 */
@Path("/viviendas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ViviendaResource {

    @Inject private ViviendaLogic viviendaLogic;
    @Inject private AnfitrionLogic anfitrionLogic;
    @Inject private HabitacionLogic habitacionLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("limit") private Integer maxRecords;
    
     /**
     * Convierte una lista de ViviendaEntity a una lista de ViviendaDetailDTO.
     *
     * @param entityList Lista de ViviendaEntity a convertir.
     * @return Lista de ViviendaDetailDTO convertida.
     * @generated
     */
    private List<ViviendaDTO> listEntity2DTO(List<ViviendaEntity> entityList){
        List<ViviendaDTO> list = new ArrayList<>();
        for (ViviendaEntity entity : entityList) {
            list.add(new ViviendaDTO(entity));
        }
        return list;
    }


    /**
     * Obtiene la lista de los registros de Vivienda
     * @return Colección de objetos de ViviendaDetailDTO
     * @generated
     */
    @GET
    public List<ViviendaDTO> getViviendas() {
        return listEntity2DTO(viviendaLogic.getViviendas());
    }

    /**
     * Obtiene los datos de una instancia de Vivienda a partir de su ID
     *
     * @param idA
     * @param id Identificador de la instancia a consultar
     * @return Instancia de ViviendaDetailDTO con los datos del Vivienda consultado
     * @generated
     */
    @GET
    @Path("/anfitriones/{idA:\\d+}/viviendas/{id: \\d+}")
    public ViviendaDetailDTO getVivienda(@PathParam("idA") Long idA, @PathParam("id") Long id) {
        return new ViviendaDetailDTO(viviendaLogic.getVivienda(id));
    }

    /**
     * Se encarga de crear un Vivienda en la base de datos
     * @param dto Objeto de ViviendaDetailDTO con los datos nuevos
     * @return Objeto de ViviendaDetailDTOcon los datos nuevos y su ID
     * @throws co.edu.uniandes.csw.habitaciones.exceptions.BusinessLogicException
     * @generated
     */
    @POST
    @Path("/anfitriones/{idA:\\d+}/viviendas/")
    public ViviendaDetailDTO createVivienda(ViviendaDetailDTO dto) throws BusinessLogicException {
        return new ViviendaDetailDTO(viviendaLogic.createVivienda(dto.toEntity()));
    }
    

    /**
     * Elimina una instancia de Vivienda de la base de datos
     *
     * @param id Identificador de la instancia a eliminar
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteVivienda(@PathParam("id") Long id) {
        viviendaLogic.deleteVivienda(id);
    }
    
    @POST
     @Path("{idV:\\d+}/habitaciones/")
    public HabitacionDetailDTO createHabitacion(HabitacionDetailDTO dto, @PathParam("idV") Long idV) throws BusinessLogicException {
        ViviendaEntity v = viviendaLogic.getVivienda(idV);
         List<HabitacionEntity> h = v.getHabitaciones();
         HabitacionEntity nueva = dto.toEntity();
         h.add(nueva);
         viviendaLogic.updateVivienda(v);
        return new HabitacionDetailDTO(nueva);
    }
    
    @PUT
    @Path("{idV:\\d+}/habitaciones/{id}")
    public HabitacionDetailDTO updateHabitacion(@PathParam("idV") Long idV, @PathParam("id") Long id, HabitacionDetailDTO dto) {
       HabitacionEntity entity = dto.toEntity();
        entity.setId(id);
        return new HabitacionDetailDTO();
    }
    
    @GET
     @Path("{idV:\\d+}/habitaciones/")
        public List<HabitacionDTO> getHabitaciones(@PathParam("idV") Long idV) {
        return HabitacionResource.listEntity2DTO(habitacionLogic.getHabitaciones());
    }
    
}
