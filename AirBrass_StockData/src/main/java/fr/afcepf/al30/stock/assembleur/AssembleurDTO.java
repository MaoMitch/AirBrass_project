package fr.afcepf.al30.stock.assembleur;

import org.springframework.beans.BeanUtils;

import fr.afcepf.al30.stock.dto.CommandeDTO;
import fr.afcepf.al30.stock.dto.FournisseurDTO;
import fr.afcepf.al30.stock.dto.LigneCommandeDTO;
import fr.afcepf.al30.stock.dto.ProduitDTO;
import fr.afcepf.al30.stock.dto.UtilisateurDTO;
import fr.afcepf.al30.stock.entity.Commande;
import fr.afcepf.al30.stock.entity.Fournisseur;
import fr.afcepf.al30.stock.entity.LigneCommande;
import fr.afcepf.al30.stock.entity.Produit;
import fr.afcepf.al30.stock.entity.Utilisateur;

public final class AssembleurDTO {
	
	private AssembleurDTO(){
		
	}
	
	public static ProduitDTO produitToProduitDTO(Produit entity) {
		ProduitDTO dto = new ProduitDTO();
		if(entity.getFournisseur() != null) {
			dto.setFournisseur(fournisseurToFournisseurDTO(entity.getFournisseur()));
		}
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	public static Produit produitDTOToProduit(ProduitDTO dto) {
		Produit entity = new Produit();
		if(dto.getFournisseur() != null) {
			entity.setFournisseur(fournisseurDTOToFournisseur(dto.getFournisseur()));
		}
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
	
	public static UtilisateurDTO utilisateurToUtilisateurDTO(Utilisateur entity) {
		UtilisateurDTO dto = new UtilisateurDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	public static Utilisateur utilisateurDTOToUtilisateur(UtilisateurDTO dto) {
		Utilisateur entity = new Utilisateur();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
	
	public static CommandeDTO commandeToCommandeDTO(Commande entity) {
		CommandeDTO dto = new CommandeDTO();
		if(entity.getUser() != null) {
			dto.setUser(utilisateurToUtilisateurDTO(entity.getUser()));
		}
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	public static Commande commandeDTOToCommande(CommandeDTO dto) {
		Commande entity = new Commande();
		BeanUtils.copyProperties(dto, entity);
		if(dto.getUser() != null) {
			entity.setUser(utilisateurDTOToUtilisateur(dto.getUser()));
		}
		return entity;
	}
	
	public static FournisseurDTO fournisseurToFournisseurDTO(Fournisseur entity) {
		FournisseurDTO dto = new FournisseurDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	public static Fournisseur fournisseurDTOToFournisseur(FournisseurDTO dto) {
		Fournisseur entity = new Fournisseur();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
	
	public static LigneCommandeDTO ligneCommandeToLigneCommandeDTO(LigneCommande entity) {
		LigneCommandeDTO dto = new LigneCommandeDTO();
		BeanUtils.copyProperties(entity, dto);
		if (entity.getCommande() != null) {
            dto.setCommande(commandeToCommandeDTO(entity.getCommande()));
        }
		if(entity.getProduit() != null) {
			dto.setProduit(produitToProduitDTO(entity.getProduit()));
		}
			
		
		return dto;
	}
	
	public static LigneCommande ligneCommandeDTOToLigneCommande(LigneCommandeDTO dto) {
		LigneCommande entity = new LigneCommande();
		BeanUtils.copyProperties(dto, entity);
		if(dto.getCommande() != null) {
			entity.setCommande(commandeDTOToCommande(dto.getCommande()));
		}
		if(dto.getProduit() != null) {
			entity.setProduit(produitDTOToProduit(dto.getProduit()));
		}
		
		return entity;
	}

}
