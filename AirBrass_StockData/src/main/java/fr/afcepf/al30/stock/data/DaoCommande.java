package fr.afcepf.al30.stock.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import fr.afcepf.al30.stock.assembleur.AssembleurDTO;
import fr.afcepf.al30.stock.dto.CommandeDTO;
import fr.afcepf.al30.stock.dto.LigneCommandeDTO;
import fr.afcepf.al30.stock.entity.Commande;
import fr.afcepf.al30.stock.entity.LigneCommande;
@Component
public class DaoCommande implements IDaoCommande {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	@Override
	public List<CommandeDTO> getAllCommande() {
		TypedQuery<Commande> typedQuery = em.createQuery("SELECT c FROM Commande c", Commande.class);
		List<Commande> commandes = typedQuery.getResultList();
		List<CommandeDTO> commandesDTO = new ArrayList<>();
		for (Commande commande : commandes) {
			CommandeDTO dtoCommande = AssembleurDTO.commandeToCommandeDTO(commande);
			commandesDTO.add(dtoCommande);
		}
		
		return commandesDTO;
	}

	@Transactional
	@Override
	public List<LigneCommandeDTO> getLigneByCommande(int idCommande) {
		TypedQuery<LigneCommande> typedQuery = em.createQuery("SELECT l FROM LigneCommande l WHERE l.commande.id = :idCommande", LigneCommande.class).setParameter("idCommande", idCommande);
		List<LigneCommande> ligneCommandes = typedQuery.getResultList();
		List<LigneCommandeDTO> ligneCommandesDTO = new ArrayList<>();
		for (LigneCommande ligneCommande : ligneCommandes) {
			LigneCommandeDTO ligneCommandeDTO = AssembleurDTO.ligneCommandeToLigneCommandeDTO(ligneCommande);
			ligneCommandesDTO.add(ligneCommandeDTO);
		}
		return ligneCommandesDTO;
	}

	@Transactional
	@Override
	public CommandeDTO addCommande(CommandeDTO commandeDTO) {
		Commande commande = AssembleurDTO.commandeDTOToCommande(commandeDTO);
		em.persist(commande);
		return AssembleurDTO.commandeToCommandeDTO(commande);
	}

	@Transactional
	@Override
	public LigneCommandeDTO addLigneCommande(LigneCommandeDTO ligne) {
		LigneCommande entity = AssembleurDTO.ligneCommandeDTOToLigneCommande(ligne);
		em.persist(entity);
		return AssembleurDTO.ligneCommandeToLigneCommandeDTO(entity);
	}

	@Transactional
	@Override
	public CommandeDTO maj(CommandeDTO commande) {
		Commande entity = AssembleurDTO.commandeDTOToCommande(commande);
		em.merge(entity);
		return AssembleurDTO.commandeToCommandeDTO(entity);
	}
	
	@Transactional
	@Override
	public List<CommandeDTO> getCommandeByStatutCommande(String statutCommande) {
		TypedQuery<Commande> typedQuery = em.createQuery("SELECT c FROM Commande c WHERE c.statut = :statutCommande",Commande.class).setParameter("statutCommande", statutCommande);
		List<CommandeDTO> commandesDTO = new ArrayList<>();
		List<Commande> commandes = typedQuery.getResultList();
		for (Commande commande : commandes) {
			CommandeDTO dto = AssembleurDTO.commandeToCommandeDTO(commande);
			commandesDTO.add(dto);
		}
		return commandesDTO;
	}
	
	

}
