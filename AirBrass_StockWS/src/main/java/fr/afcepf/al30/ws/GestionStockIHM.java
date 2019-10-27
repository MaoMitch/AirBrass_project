package fr.afcepf.al30.ws;

import java.util.List;

import javax.jws.WebService;

import fr.afcepf.al30.stock.data.IDaoCommande;
import fr.afcepf.al30.stock.data.IDaoFournisseur;
import fr.afcepf.al30.stock.data.IDaoProduit;
import fr.afcepf.al30.stock.data.IDaoUtilisateur;
import fr.afcepf.al30.stock.dto.CommandeDTO;
import fr.afcepf.al30.stock.dto.FournisseurDTO;
import fr.afcepf.al30.stock.dto.LigneCommandeDTO;
import fr.afcepf.al30.stock.dto.ProduitDTO;
import fr.afcepf.al30.stock.dto.UtilisateurDTO;
import lombok.Setter;

@Setter
@WebService(targetNamespace = "http://airbrass.stock.al30.afcepf.fr",
        endpointInterface = "fr.afcepf.al30.ws.IGestionStockIHM")
public class GestionStockIHM implements IGestionStockIHM {

    private IDaoProduit daoProduit;
    private IDaoUtilisateur daoUtilisateur;
    private IDaoCommande daoCommande;
    private IDaoFournisseur daoFournisseur;

    @Override
    public List<LigneCommandeDTO> getLigneByCommande(int idCommande) {
        return daoCommande.getLigneByCommande(idCommande);
    }

    @Override
    public ProduitDTO getProduitById(int idProduit) {
        return daoProduit.getProduitById(idProduit);
    }

    @Override
    public CommandeDTO addCommande(CommandeDTO commande) {
        return daoCommande.addCommande(commande);
    }

    @Override
    public LigneCommandeDTO addCommande(LigneCommandeDTO ligne) {
        return daoCommande.addLigneCommande(ligne);
    }

    @Override
    public CommandeDTO majCommande(CommandeDTO commande) {
        return daoCommande.maj(commande);
    }

    @Override
    public ProduitDTO ajoutStock(ProduitDTO produit, int quantite) {
        produit.setStock(produit.getStock() + quantite);
        daoProduit.majProduit(produit);
        return produit;
    }

    @Override
    public UtilisateurDTO getUtilisateur(String login, String password) {
        return daoUtilisateur.getUtilisateur(login, password);
    }

    @Override
    public List<ProduitDTO> getProduitStockVide() {
        return daoProduit.getProduitStockVide();
    }

    @Override
    public List<CommandeDTO> getCommande() {
        return daoCommande.getAllCommande();
    }

    @Override
    public List<ProduitDTO> getAll() {
        return daoProduit.getAll();
    }

    @Override
    public ProduitDTO majProduit(ProduitDTO prod) {
        return daoProduit.majProduit(prod);
    }

    @Override
    public List<FournisseurDTO> getAllFournisseur() {
        return daoFournisseur.getAll();
    }

    @Override
    public List<ProduitDTO> getProduitByFournisseur(int idFournisseur) {
        return daoProduit.getProduitsByFournisseur(idFournisseur);
    }

    @Override
    public FournisseurDTO getFournisseurById(int idFournisseur) {
        return daoFournisseur.getFournisseurById(idFournisseur);
    }

    @Override
    public List<CommandeDTO> getCommandeByStatut(String statutCommande) {
        return daoCommande.getCommandeByStatutCommande(statutCommande);
    }

}
