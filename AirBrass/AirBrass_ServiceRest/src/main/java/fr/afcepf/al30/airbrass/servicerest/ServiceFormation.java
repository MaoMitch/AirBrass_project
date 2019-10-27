package fr.afcepf.al30.airbrass.servicerest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import fr.afcepf.al30.airbrass.serviceentities.IdParam;
import fr.afcepf.al30.formations.Formateur;
import fr.afcepf.al30.formations.FormateurDTO;
import fr.afcepf.al30.formations.Formation;
import fr.afcepf.al30.formations.FormationDTO;
import fr.afcepf.al30.formations.Niveau;
import fr.afcepf.al30.formations.ServiceFormation_Service;

@Path("/businessFormation")
public class ServiceFormation {

    private fr.afcepf.al30.formations.ServiceFormation proxy = new ServiceFormation_Service().getFormport();

    private static Logger log = Logger.getLogger(ServiceFormation.class);

    @GET
    @Path("/listeAllFormateurs")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FormateurDTO> getAllFormateurs() {
        try {
            return proxy.getAllFormateurs();
        } catch (Exception ex) {
            log.error(ex);
        }
        return new ArrayList<>();
    }

    @GET
    @Path("/listeAllFormations")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FormationDTO> getAllFormations() {
        try {
            return proxy.getAllFormations();
        } catch (Exception ex) {
            log.error(ex);
        }
        return new ArrayList<>();
    }

    @GET
    @Path("listeFormations/{intitule}/{formateur}/{niveau}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FormationDTO> getFormations(@PathParam("intitule") String intitule,
            @PathParam("formateur") String formateur,
            @PathParam("niveau") String niveau) {

        try {
            Formation formation = new Formation();
            if (!"-".equals(intitule)) {
                formation.setIntitule(intitule);
            }

            formation.setFormateur(new Formateur());

            if (!"-".equals(formateur)) {
                formation.getFormateur().setNom(formateur);
            }

            formation.setNiveau(Niveau.fromValue(niveau));

            return proxy.getFormations(formation, true);
        } catch (Exception ex) {
            log.error(ex);
        }
        return new ArrayList<>();
    }

    @POST
    @Path("reserver")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response reserver(IdParam id) {
        FormationDTO dto = proxy.getFormationById(Integer.parseInt(id.getId()));
        proxy.reserverFormation(dto);
        return Response.status(201).entity(dto).build();
    }
}
