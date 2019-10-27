package fr.afcepf.al30.airbrass.servicerest;

import fr.afcepf.al30.airbrass.serviceentities.LigneComParam;
import fr.afcepf.al30.airbrass.serviceentities.PanierParam;
import fr.afcepf.al30.airbrass.serviceentities.IdParam;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.afcepf.al30.airbrass.dto.DTOCommande;
import fr.afcepf.al30.airbrass.business.api.IBusinessCommande;
import fr.afcepf.al30.airbrass.business.api.IBusinessProduit;
import fr.afcepf.al30.airbrass.business.api.IBusinessUtilisateur;
import fr.afcepf.al30.airbrass.dto.DTOCB;
import fr.afcepf.al30.airbrass.dto.DTOLigneCommande;
import fr.afcepf.al30.airbrass.dto.DTOPersonne;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;
import fr.afcepf.al30.airbrass.serviceentities.CarteAvecUser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 * La Class exposant les services de gestion d'une commande.
 */
@Path("commandes")
public class ServiceCommande {

    @EJB
    private IBusinessCommande buCommande;

    @EJB
    private IBusinessUtilisateur buPersonne;

    @EJB
    private IBusinessProduit buProduit;

    private static Logger log = Logger.getLogger(ServiceCommande.class);

    /**
     * Methode d'obtention des commandes d'un utilisateur.
     *
     * @param param l'{@link IdParam} de l'utilisateur.
     * @return la liste des commande de l'utilisateur.
     */
    @POST
    @Path("byUserID")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCommandesByUserId(IdParam param) {

        List<DTOCommande> commandesDTO = null;
        try {
            commandesDTO = buCommande.getCommandesByUser(buPersonne.getClientById(Integer.parseInt(param.getId())));
        } catch (AirBrassException ex) {
            log.error(ex);
        }
        if (commandesDTO != null) {
            for (DTOCommande dTOCommande : commandesDTO) {
                try {
                    dTOCommande.setDtoLigneCommandes(buCommande.getLigneByCommande(dTOCommande));
                } catch (AirBrassException ex) {
                    log.error(ex);
                }
            }
            return Response.status(201).entity(commandesDTO).build();

        } else {
            return Response.status(500).entity("Aucune commande").build();
        }
    }

    @POST
    @Path("byCommandeID")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public double getPrixByCommande(IdParam param) {
        try {
            return buCommande.getPrixByCommande(buCommande.getCommandeById(Integer.parseInt(param.getId())));
        } catch (AirBrassException ex) {
            log.error(ex);
        }
        return 0;
    }

    @POST
    @Path("order")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveCommande(PanierParam panier) {
        try {
            DTOCommande commande = new DTOCommande();
            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
            commande.setDtoPersonne(buPersonne.getClientById(panier.getIdPers()));
            commande.setDate(sdf.parse(panier.getDateCommande()));
            commande.setNumero("CMD" + panier.getIdPers() + "-" + panier.getDateCommande());
            commande.setDtoLigneCommandes(new ArrayList<>());
            commande.setDtoCb(panier.getCb());
            commande.setPrixLivraison(panier.getPrixLivraison());

            log.fatal(panier.getPanier());
            for (LigneComParam ligne : panier.getPanier()) {
                DTOLigneCommande ligneCom = new DTOLigneCommande();

                ligneCom.setDtoProduit(buProduit.getProduitById(ligne.getId()));
                ligneCom.setQuantite(ligne.getQuantite());
                commande.getDtoLigneCommandes().add(ligneCom);
            }

            buCommande.addCommande(commande);
            panier.setPanier(new ArrayList<>());
            return Response.status(201).build();
        } catch (AirBrassException ex) {
            log.error(ex);
            return Response.status(500).entity(ex.getCodeErreur()).build();
        } catch (ParseException ex) {
            log.error(ex);
            return Response.status(500).entity(ex.getMessage()).build();
        }
    }

    @POST
    @Path("getCarteByUser")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public Response getCarteByUser(String id) {
        try {
            List<DTOCB> cartes = buCommande.getCBByClient(Integer.parseInt(id));
            return Response.status(201).entity(cartes).build();
        } catch (AirBrassException ex) {
            log.error(ex);
            return Response.status(500).entity(ex.getCodeErreur()).build();
        }

    }

    @POST
    @Path("ajouterCarte")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ajouterCarte(CarteAvecUser carteAvecUser) {
        try {
            DTOPersonne personne = buPersonne.getClientById(Integer.parseInt(carteAvecUser.getUserId()));
            DTOCB dtoCb = carteAvecUser.getCb();
            dtoCb.setDtoPersonne(personne);
            DTOCB carte = buCommande.ajouterCarte(dtoCb);
            return Response.status(201).entity(carte).build();
        } catch (AirBrassException ex) {
            log.error(ex);
            return Response.status(500).entity(ex.getCodeErreur()).build();
        }

    }

    @POST
    @Path("majCarte")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response majCarte(DTOCB dtoCb) {
        try {
            DTOCB carte = buCommande.majCarte(dtoCb);
            return Response.status(201).entity(carte).build();
        } catch (AirBrassException ex) {
            log.error(ex);
            return Response.status(500).entity(ex.getCodeErreur()).build();
        }

    }

    @POST
    @Path("suprCarte")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response suprCarte(DTOCB dtoCb) {
        try {
            Boolean bool = buCommande.suprCarte(dtoCb);
            return Response.status(201).entity(bool).build();
        } catch (AirBrassException ex) {
            log.error(ex);
            return Response.status(500).entity(ex.getCodeErreur()).build();
        }

    }
}
