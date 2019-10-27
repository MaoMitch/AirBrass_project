package fr.afcepf.al30.stock.data;

import java.util.List;

import fr.afcepf.al30.stock.dto.ProduitDTO;

public interface IDaoProduit {
	
	List<ProduitDTO> getAll();
	int getStockByProduit(String refProduit);
	ProduitDTO getProduitByReference(String refProduit);
	ProduitDTO majProduit(ProduitDTO produit);
	List<ProduitDTO> getProduitStockVide();
	ProduitDTO getProduitById(int idProduit);
	List<ProduitDTO> getProduitsByFournisseur(int idFournisseur);

}
