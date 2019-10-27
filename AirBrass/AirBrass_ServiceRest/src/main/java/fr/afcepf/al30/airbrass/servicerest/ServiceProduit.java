package fr.afcepf.al30.airbrass.servicerest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;

import fr.afcepf.al30.airbrass.dto.DTOAvisClient;
import fr.afcepf.al30.airbrass.dto.DTOMarque;
import fr.afcepf.al30.airbrass.dto.DTOProduit;
import fr.afcepf.al30.airbrass.dto.DTOSpecialisationProduit;
import fr.afcepf.al30.airbrass.dto.DTOVues;
import fr.afcepf.al30.airbrass.business.api.IBusinessProduit;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;
import fr.afcepf.al30.airbrass.exceptions.AssembleurException;

import java.util.ArrayList;
import java.util.Arrays;
import javax.ejb.EJB;

@Path("/produit")
public class ServiceProduit {

    @EJB
    private IBusinessProduit buProduit;

    private static Logger log = Logger.getLogger(ServiceProduit.class);

    @GET
    @Path("/listeAllProduits")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DTOProduit> getAllProduits() {
        try {
            return buProduit.getAllProduits();
        } catch (AirBrassException ex) {
            log.error(ex);
        }
        return new ArrayList<>();
    }

    @GET
    @Path("/listeAllGuitares")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DTOProduit> getAllGuitares() {
        try {
            log.fatal(buProduit);
            return buProduit.getAllGuitares();
        } catch (AirBrassException ex) {
            log.error(ex);
        }
        return new ArrayList<>();
    }

    @GET
    @Path("/listeAllAccessoires")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DTOProduit> getAllAccessoires() {
        try {
            return buProduit.getAllAccessoire();
        } catch (AirBrassException ex) {
            log.error(ex);
        }
        return new ArrayList<>();
    }

    @GET
    @Path("listeAllMarques")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DTOMarque> getAllMarques() {
        try {
            return buProduit.getAllMarque();
        } catch (AirBrassException ex) {
            log.error(ex);
        }
        return new ArrayList<>();
    }

    @GET
    @Path("listeAllMarquesGuitare")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DTOMarque> getAllMarquesGuitare() {
        try {
            return buProduit.getAllMarqueGuitare();
        } catch (AirBrassException ex) {
            log.error(ex);
        }
        return new ArrayList<>();
    }

    @GET
    @Path("listeAllMarquesAccessoire")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DTOMarque> getAllMarquesAccessoire() {
        try {
            return buProduit.getAllMarqueAccessoire();
        } catch (AirBrassException ex) {
            log.error(ex);
        }
        return new ArrayList<>();
    }

    @GET
    @Path("listeAllSpecs")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DTOSpecialisationProduit> getAllSpecs() {
        try {
            return buProduit.getAllSpecs();
        } catch (AirBrassException ex) {
            log.error(ex);
        }
        return new ArrayList<>();
    }

    @GET
    @Path("listeAllSpecsGuitare")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DTOSpecialisationProduit> getAllSpecsGuitare() {
        try {
            return buProduit.getAllSpecsGuitare();
        } catch (AirBrassException ex) {
            log.error(ex);
        }
        return new ArrayList<>();
    }

    @GET
    @Path("listeAllSpecsAccessoire")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DTOSpecialisationProduit> getAllSpecsAccessoire() {
        try {
            return buProduit.getAllSpecsAccessoire();
        } catch (AirBrassException ex) {
            log.error(ex);
        }
        return new ArrayList<>();
    }

    @GET
    @Path("listeProduitParOptions/{specs}/{marques}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DTOProduit> getProduitParOptions(@PathParam("specs") String specialisations, @PathParam("marques") String marques) {
        try {
            List<String> listSpe = tabToList(specialisations.split(","));
            List<String> listMarque = null;
            if (marques != null && !"".equals(marques)) {
                listMarque = tabToList(marques.split(","));
            }
            return buProduit.getProduitParOptions(listSpe, listMarque);
        } catch (AirBrassException ex) {
            log.error(ex);
        }
        return new ArrayList<>();
    }

    private List<String> tabToList(String[] tab) {
        return new ArrayList<>(Arrays.asList(tab));
    }

    @GET
    @Path("produit/{ids}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduitById(@PathParam("ids") String param) {
        try {
            DTOProduit dto = buProduit.getProduitById(Integer.parseInt(param));
            return Response.status(200).entity(dto).build();
        } catch (AirBrassException ex) {
            log.error(ex);
            return Response.status(500).entity(ex.getCodeErreur()).build();
        }
    }

    @GET
    @Path("vues/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DTOVues> getVuesByProduit(@PathParam("id") String idProduit) {
        List<DTOVues> list = new ArrayList<>();
        try {
            log.debug("le int" + idProduit);
            int il = Integer.parseInt(idProduit);
            list = buProduit.getVuesByProduit(il);
            return list;
        } catch (AirBrassException e) {
            log.error(e);
        }
        return list;
    }

    public DTOVues addVues(String vues) {
        log.info(vues);
        return null;

    }

    @GET
    @Path("produitsSpec/{spec}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DTOProduit> getProduitBySpec(@PathParam("spec") String specProduit) {
        List<DTOProduit> produits = new ArrayList<>();
        try {
            produits = buProduit.gelAllProduitBySpecialisation(specProduit);
        } catch (AirBrassException e) {
            log.error(e);
        }
        return produits;
    }

    @GET
    @Path("produitsMarque/{marq}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DTOProduit> getProduitByMarque(@PathParam("marq") String intituleMarque) {
        List<DTOProduit> produits = new ArrayList<>();
        try {
            produits = buProduit.getProduitsByMarque(intituleMarque);
        } catch (AssembleurException e) {
            log.error(e);
        }
        return produits;
    }

    @GET
    @Path("avisProduit/{idProduit}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DTOAvisClient> getAvisByProduit(@PathParam("idProduit") String idProduit) {
        int id = Integer.parseInt(idProduit);
        List<DTOAvisClient> avis = new ArrayList<>();
        try {
            avis = buProduit.getAvisByProduit(id);
        } catch (AirBrassException e) {
            log.error(e);
        }
        return avis;
    }

    @GET
    @Path("produitPromotion")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DTOProduit> getProduitPromotion() {
        List<DTOProduit> produits = new ArrayList<>();
        try {
            produits = buProduit.getProduitPromotion();
        } catch (AssembleurException e) {
            log.error(e);
        }
        return produits;
    }

    @GET
    @Path("accessoirePromotion")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DTOProduit> getAccessoirePromotion() {
        List<DTOProduit> produits = new ArrayList<>();
        try {
            produits = buProduit.getAccessoirePromotion();
        } catch (AssembleurException e) {
            log.error(e);
        }
        return produits;
    }

}
