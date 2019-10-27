package fr.afcepf.al30.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import fr.afcepf.al30.stock.dto.CommandeDTO;
import fr.afcepf.al30.stock.dto.FournisseurDTO;
import fr.afcepf.al30.stock.dto.LigneCommandeDTO;
import fr.afcepf.al30.stock.dto.ProduitDTO;
import fr.afcepf.al30.stock.dto.UtilisateurDTO;

@WebService(targetNamespace = "http://airbrass.stock.al30.afcepf.fr",
name = "stockIHM")
public interface IGestionStockIHM {
	
	@WebMethod(operationName="getAllProduit")
	@WebResult(name="listeProduit")
	List<ProduitDTO> getAll();
	
	@WebMethod(operationName="ajoutStock")
	@WebResult(name="ajout")
	ProduitDTO ajoutStock(@WebParam(name="produit")ProduitDTO produit, @WebParam(name="quantite") int quantite);
	
	@WebMethod(operationName="trouverUtilisateur")
	@WebResult(name="utilisateur")
	UtilisateurDTO getUtilisateur(@WebParam(name="login")String login, @WebParam(name="password") String password);
	
	@WebMethod(operationName="produitsStockVide")
	@WebResult(name="listeProduitStockVide")
	List<ProduitDTO> getProduitStockVide();
	
	@WebMethod(operationName="getListeCommande")
	@WebResult(name="listeCommande")
	List<CommandeDTO> getCommande();
	
	@WebMethod(operationName="getLigneByCommande")
	@WebResult(name="listeLigneCommande")
	List<LigneCommandeDTO> getLigneByCommande(@WebParam(name="idCommande")int idCommande);
	
	@WebMethod(operationName="getProduitById")
	@WebResult(name="produitDTO")
	ProduitDTO getProduitById(@WebParam(name="idProduit")int idProduit);
	
	@WebMethod(operationName="addCommande")
	@WebResult(name="commandeAjout")
	CommandeDTO addCommande(@WebParam(name="commande") CommandeDTO commande);
	@WebMethod(operationName="addLigne")
	@WebResult(name="ligneAjout")
	LigneCommandeDTO addCommande(@WebParam(name="ligne") LigneCommandeDTO ligne);
	
	@WebMethod(operationName="majCommande")
	@WebResult(name="commandeValide")
	CommandeDTO majCommande(@WebParam(name="commande") CommandeDTO commande);
	
	@WebMethod(operationName="majProduit")
	@WebResult(name="produitModifie")
	ProduitDTO majProduit(@WebParam(name="produit")ProduitDTO prod);

	@WebMethod(operationName="getAllFournisseur")
	@WebResult(name="fournisseurs")
	List<FournisseurDTO> getAllFournisseur();

	@WebMethod(operationName="getProduitByFournisseur")
	@WebResult(name="produits")
	List<ProduitDTO> getProduitByFournisseur(@WebParam(name="idFournisseur")int idFournisseur);

	@WebMethod(operationName="getFournisseurById")
	@WebResult(name="fournisseur")
	FournisseurDTO getFournisseurById(@WebParam(name="idFournisseur") int idFournisseur);
	
	@WebMethod(operationName="getCommandeByStatut")
	@WebResult(name="listCommandeByStatut")
	List<CommandeDTO> getCommandeByStatut(@WebParam(name="statutCommande")String statutCommande);

}
