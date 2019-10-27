package fr.afcepf.al30.airbrass.servicerest;

import fr.afcepf.al30.airbrass.serviceentities.Utilisateur;
import fr.afcepf.al30.airbrass.serviceentities.Credentials;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;

import fr.afcepf.al30.airbrass.dto.DTOPersonne;
import fr.afcepf.al30.airbrass.business.api.IBusinessUtilisateur;
import fr.afcepf.al30.airbrass.dto.DTOAdresse;
import fr.afcepf.al30.airbrass.dto.DTOPays;
import fr.afcepf.al30.airbrass.dto.DTOVille;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

@Path("clients")
public class ServiceUtilisateur {

    @EJB
    private IBusinessUtilisateur buUtilisateur;

    private static Logger log = Logger.getLogger(ServiceUtilisateur.class);

    @POST
    @Path("connect")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response connect(Credentials cred) {
        try {
            DTOPersonne pers = buUtilisateur.connectClient(cred.getLogin(), cred.getPassword());
            return Response.status(201).entity(pers).build();
        } catch (AirBrassException ex) {
            log.error(ex);
            return Response.status(500).entity("utilisateur inconnu").build();
        }
    }

    @POST
    @Path("newUser")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUser(Utilisateur utilisateur) {
        if (utilisateur.getMdp().equals(utilisateur.getMdpConfirm())) {
            try {
                DTOPays pays = new DTOPays("France");
                DTOVille ville = new DTOVille(utilisateur.getVille(), utilisateur.getCp(), pays);
                DTOAdresse adresse = new DTOAdresse(Integer.parseInt(utilisateur.getNumRue()), utilisateur.getRue(), utilisateur.getComplement(), ville);
                List<DTOAdresse> adresses = new ArrayList<>();
                adresses.add(adresse);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                DTOPersonne pers = new DTOPersonne(utilisateur.getNom(), utilisateur.getPrenom(), sdf.parse(utilisateur.getDateNaissance()), utilisateur.getEmail(), utilisateur.getTelephone(), utilisateur.getMdp(), adresses);
                pers = buUtilisateur.createNewClient(pers);
                return Response.status(201).entity(pers).build();
            } catch (AirBrassException | ParseException ex) {
                log.error(ex);
                return Response.status(500).entity(ex.getMessage()).build();
            }
        } else {
            log.error("Mot de passe et confirmation non égaux");
            return Response.status(500).entity("Mot de passe et confirmation non égaux").build();
        }
    }

}
