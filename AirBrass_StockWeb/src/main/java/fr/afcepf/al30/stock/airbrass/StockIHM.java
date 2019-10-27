
package fr.afcepf.al30.stock.airbrass;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "stockIHM", targetNamespace = "http://airbrass.stock.al30.afcepf.fr")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface StockIHM {


    /**
     * 
     * @param idCommande
     * @return
     *     returns java.util.List<fr.afcepf.al30.stock.airbrass.LigneCommandeDTO>
     */
    @WebMethod
    @WebResult(name = "listeLigneCommande", targetNamespace = "")
    @RequestWrapper(localName = "getLigneByCommande", targetNamespace = "http://airbrass.stock.al30.afcepf.fr", className = "fr.afcepf.al30.stock.airbrass.GetLigneByCommande")
    @ResponseWrapper(localName = "getLigneByCommandeResponse", targetNamespace = "http://airbrass.stock.al30.afcepf.fr", className = "fr.afcepf.al30.stock.airbrass.GetLigneByCommandeResponse")
    public List<LigneCommandeDTO> getLigneByCommande(
        @WebParam(name = "idCommande", targetNamespace = "")
        int idCommande);

    /**
     * 
     * @return
     *     returns java.util.List<fr.afcepf.al30.stock.airbrass.ProduitDTO>
     */
    @WebMethod
    @WebResult(name = "listeProduitStockVide", targetNamespace = "")
    @RequestWrapper(localName = "produitsStockVide", targetNamespace = "http://airbrass.stock.al30.afcepf.fr", className = "fr.afcepf.al30.stock.airbrass.ProduitsStockVide")
    @ResponseWrapper(localName = "produitsStockVideResponse", targetNamespace = "http://airbrass.stock.al30.afcepf.fr", className = "fr.afcepf.al30.stock.airbrass.ProduitsStockVideResponse")
    public List<ProduitDTO> produitsStockVide();

    /**
     * 
     * @return
     *     returns java.util.List<fr.afcepf.al30.stock.airbrass.CommandeDTO>
     */
    @WebMethod
    @WebResult(name = "listeCommande", targetNamespace = "")
    @RequestWrapper(localName = "getListeCommande", targetNamespace = "http://airbrass.stock.al30.afcepf.fr", className = "fr.afcepf.al30.stock.airbrass.GetListeCommande")
    @ResponseWrapper(localName = "getListeCommandeResponse", targetNamespace = "http://airbrass.stock.al30.afcepf.fr", className = "fr.afcepf.al30.stock.airbrass.GetListeCommandeResponse")
    public List<CommandeDTO> getListeCommande();

    /**
     * 
     * @param idFournisseur
     * @return
     *     returns fr.afcepf.al30.stock.airbrass.FournisseurDTO
     */
    @WebMethod
    @WebResult(name = "fournisseur", targetNamespace = "")
    @RequestWrapper(localName = "getFournisseurById", targetNamespace = "http://airbrass.stock.al30.afcepf.fr", className = "fr.afcepf.al30.stock.airbrass.GetFournisseurById")
    @ResponseWrapper(localName = "getFournisseurByIdResponse", targetNamespace = "http://airbrass.stock.al30.afcepf.fr", className = "fr.afcepf.al30.stock.airbrass.GetFournisseurByIdResponse")
    public FournisseurDTO getFournisseurById(
        @WebParam(name = "idFournisseur", targetNamespace = "")
        int idFournisseur);

    /**
     * 
     * @param commande
     * @return
     *     returns fr.afcepf.al30.stock.airbrass.CommandeDTO
     */
    @WebMethod
    @WebResult(name = "commandeAjout", targetNamespace = "")
    @RequestWrapper(localName = "addCommande", targetNamespace = "http://airbrass.stock.al30.afcepf.fr", className = "fr.afcepf.al30.stock.airbrass.AddCommande")
    @ResponseWrapper(localName = "addCommandeResponse", targetNamespace = "http://airbrass.stock.al30.afcepf.fr", className = "fr.afcepf.al30.stock.airbrass.AddCommandeResponse")
    public CommandeDTO addCommande(
        @WebParam(name = "commande", targetNamespace = "")
        CommandeDTO commande);

    /**
     * 
     * @param idFournisseur
     * @return
     *     returns java.util.List<fr.afcepf.al30.stock.airbrass.ProduitDTO>
     */
    @WebMethod
    @WebResult(name = "produits", targetNamespace = "")
    @RequestWrapper(localName = "getProduitByFournisseur", targetNamespace = "http://airbrass.stock.al30.afcepf.fr", className = "fr.afcepf.al30.stock.airbrass.GetProduitByFournisseur")
    @ResponseWrapper(localName = "getProduitByFournisseurResponse", targetNamespace = "http://airbrass.stock.al30.afcepf.fr", className = "fr.afcepf.al30.stock.airbrass.GetProduitByFournisseurResponse")
    public List<ProduitDTO> getProduitByFournisseur(
        @WebParam(name = "idFournisseur", targetNamespace = "")
        int idFournisseur);

    /**
     * 
     * @return
     *     returns java.util.List<fr.afcepf.al30.stock.airbrass.FournisseurDTO>
     */
    @WebMethod
    @WebResult(name = "fournisseurs", targetNamespace = "")
    @RequestWrapper(localName = "getAllFournisseur", targetNamespace = "http://airbrass.stock.al30.afcepf.fr", className = "fr.afcepf.al30.stock.airbrass.GetAllFournisseur")
    @ResponseWrapper(localName = "getAllFournisseurResponse", targetNamespace = "http://airbrass.stock.al30.afcepf.fr", className = "fr.afcepf.al30.stock.airbrass.GetAllFournisseurResponse")
    public List<FournisseurDTO> getAllFournisseur();

    /**
     * 
     * @param produit
     * @return
     *     returns fr.afcepf.al30.stock.airbrass.ProduitDTO
     */
    @WebMethod
    @WebResult(name = "produitModifie", targetNamespace = "")
    @RequestWrapper(localName = "majProduit", targetNamespace = "http://airbrass.stock.al30.afcepf.fr", className = "fr.afcepf.al30.stock.airbrass.MajProduit")
    @ResponseWrapper(localName = "majProduitResponse", targetNamespace = "http://airbrass.stock.al30.afcepf.fr", className = "fr.afcepf.al30.stock.airbrass.MajProduitResponse")
    public ProduitDTO majProduit(
        @WebParam(name = "produit", targetNamespace = "")
        ProduitDTO produit);

    /**
     * 
     * @param ligne
     * @return
     *     returns fr.afcepf.al30.stock.airbrass.LigneCommandeDTO
     */
    @WebMethod
    @WebResult(name = "ligneAjout", targetNamespace = "")
    @RequestWrapper(localName = "addLigne", targetNamespace = "http://airbrass.stock.al30.afcepf.fr", className = "fr.afcepf.al30.stock.airbrass.AddLigne")
    @ResponseWrapper(localName = "addLigneResponse", targetNamespace = "http://airbrass.stock.al30.afcepf.fr", className = "fr.afcepf.al30.stock.airbrass.AddLigneResponse")
    public LigneCommandeDTO addLigne(
        @WebParam(name = "ligne", targetNamespace = "")
        LigneCommandeDTO ligne);

    /**
     * 
     * @return
     *     returns java.util.List<fr.afcepf.al30.stock.airbrass.ProduitDTO>
     */
    @WebMethod
    @WebResult(name = "listeProduit", targetNamespace = "")
    @RequestWrapper(localName = "getAllProduit", targetNamespace = "http://airbrass.stock.al30.afcepf.fr", className = "fr.afcepf.al30.stock.airbrass.GetAllProduit")
    @ResponseWrapper(localName = "getAllProduitResponse", targetNamespace = "http://airbrass.stock.al30.afcepf.fr", className = "fr.afcepf.al30.stock.airbrass.GetAllProduitResponse")
    public List<ProduitDTO> getAllProduit();

    /**
     * 
     * @param idProduit
     * @return
     *     returns fr.afcepf.al30.stock.airbrass.ProduitDTO
     */
    @WebMethod
    @WebResult(name = "produitDTO", targetNamespace = "")
    @RequestWrapper(localName = "getProduitById", targetNamespace = "http://airbrass.stock.al30.afcepf.fr", className = "fr.afcepf.al30.stock.airbrass.GetProduitById")
    @ResponseWrapper(localName = "getProduitByIdResponse", targetNamespace = "http://airbrass.stock.al30.afcepf.fr", className = "fr.afcepf.al30.stock.airbrass.GetProduitByIdResponse")
    public ProduitDTO getProduitById(
        @WebParam(name = "idProduit", targetNamespace = "")
        int idProduit);

    /**
     * 
     * @param produit
     * @param quantite
     * @return
     *     returns fr.afcepf.al30.stock.airbrass.ProduitDTO
     */
    @WebMethod
    @WebResult(name = "ajout", targetNamespace = "")
    @RequestWrapper(localName = "ajoutStock", targetNamespace = "http://airbrass.stock.al30.afcepf.fr", className = "fr.afcepf.al30.stock.airbrass.AjoutStock")
    @ResponseWrapper(localName = "ajoutStockResponse", targetNamespace = "http://airbrass.stock.al30.afcepf.fr", className = "fr.afcepf.al30.stock.airbrass.AjoutStockResponse")
    public ProduitDTO ajoutStock(
        @WebParam(name = "produit", targetNamespace = "")
        ProduitDTO produit,
        @WebParam(name = "quantite", targetNamespace = "")
        int quantite);

    /**
     * 
     * @param statutCommande
     * @return
     *     returns java.util.List<fr.afcepf.al30.stock.airbrass.CommandeDTO>
     */
    @WebMethod
    @WebResult(name = "listCommandeByStatut", targetNamespace = "")
    @RequestWrapper(localName = "getCommandeByStatut", targetNamespace = "http://airbrass.stock.al30.afcepf.fr", className = "fr.afcepf.al30.stock.airbrass.GetCommandeByStatut")
    @ResponseWrapper(localName = "getCommandeByStatutResponse", targetNamespace = "http://airbrass.stock.al30.afcepf.fr", className = "fr.afcepf.al30.stock.airbrass.GetCommandeByStatutResponse")
    public List<CommandeDTO> getCommandeByStatut(
        @WebParam(name = "statutCommande", targetNamespace = "")
        String statutCommande);

    /**
     * 
     * @param password
     * @param login
     * @return
     *     returns fr.afcepf.al30.stock.airbrass.UtilisateurDTO
     */
    @WebMethod
    @WebResult(name = "utilisateur", targetNamespace = "")
    @RequestWrapper(localName = "trouverUtilisateur", targetNamespace = "http://airbrass.stock.al30.afcepf.fr", className = "fr.afcepf.al30.stock.airbrass.TrouverUtilisateur")
    @ResponseWrapper(localName = "trouverUtilisateurResponse", targetNamespace = "http://airbrass.stock.al30.afcepf.fr", className = "fr.afcepf.al30.stock.airbrass.TrouverUtilisateurResponse")
    public UtilisateurDTO trouverUtilisateur(
        @WebParam(name = "login", targetNamespace = "")
        String login,
        @WebParam(name = "password", targetNamespace = "")
        String password);

    /**
     * 
     * @param commande
     * @return
     *     returns fr.afcepf.al30.stock.airbrass.CommandeDTO
     */
    @WebMethod
    @WebResult(name = "commandeValide", targetNamespace = "")
    @RequestWrapper(localName = "majCommande", targetNamespace = "http://airbrass.stock.al30.afcepf.fr", className = "fr.afcepf.al30.stock.airbrass.MajCommande")
    @ResponseWrapper(localName = "majCommandeResponse", targetNamespace = "http://airbrass.stock.al30.afcepf.fr", className = "fr.afcepf.al30.stock.airbrass.MajCommandeResponse")
    public CommandeDTO majCommande(
        @WebParam(name = "commande", targetNamespace = "")
        CommandeDTO commande);

}
