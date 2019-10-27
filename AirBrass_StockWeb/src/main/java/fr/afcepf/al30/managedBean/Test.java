package fr.afcepf.al30.managedBean;

import java.util.ArrayList;
import java.util.List;

import fr.afcepf.al30.stock.airbrass.FournisseurDTO;
import fr.afcepf.al30.stock.airbrass.GestionStockIHMService;
import fr.afcepf.al30.stock.airbrass.LigneCommandeDTO;
import fr.afcepf.al30.stock.airbrass.ProduitDTO;
import fr.afcepf.al30.stock.airbrass.StockIHM;
import fr.afcepf.al30.stock.airbrass.UtilisateurDTO;

public class Test {


	public static void main(String[] args) {
		StockIHM stock = new GestionStockIHMService().getGestionStockIHMPort();
		UtilisateurDTO user = stock.trouverUtilisateur("manager", "afcepf");
		System.out.println(user.getName());
		ProduitDTO prod = new ProduitDTO();
		prod.setFournisseur(new FournisseurDTO());
		prod.setId(1);
		prod.setPrixFournisseur(12d);
		prod.setRefProduit("REF.001");
		prod.setSeuil(30);
		prod.setStock(2);
		ProduitDTO prod2 = new ProduitDTO();
		prod2.setFournisseur(new FournisseurDTO());
		prod2.setId(1);
		prod2.setPrixFournisseur(12d);
		prod2.setRefProduit("REF.002");
		prod2.setSeuil(30);
		prod2.setStock(2);
		LigneCommandeDTO linge1 = new LigneCommandeDTO();
		linge1.setProduit(prod);
		linge1.setQuantite(32);
		LigneCommandeDTO linge2 = new LigneCommandeDTO();
		linge2.setProduit(prod2);
		linge1.setQuantite(20);


		List<LigneCommandeDTO> lignes = new ArrayList<>();
		lignes.add(linge2);
		lignes.add(linge1);
		boolean check = false;
		//		if("REF.001".)
		LigneCommandeDTO ligne3 = new LigneCommandeDTO();
		ligne3.setProduit(prod2);
		ligne3.setQuantite(1);

		for (LigneCommandeDTO ligneCommandeDTO : lignes) {
			if(ligneCommandeDTO.getProduit().getRefProduit() =="REF.003") {
				System.out.println("coucou");
				ligneCommandeDTO.setQuantite(ligneCommandeDTO.getQuantite() + 2);
				System.out.println(ligneCommandeDTO.getQuantite());
				check = true;
				System.out.println(check);
			}	
			
		}
		if(!check) {
			lignes.add(ligne3);
			
		}
		System.out.println(lignes.size());

	}
}
