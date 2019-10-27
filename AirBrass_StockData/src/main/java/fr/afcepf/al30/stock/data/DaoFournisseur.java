package fr.afcepf.al30.stock.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import fr.afcepf.al30.stock.assembleur.AssembleurDTO;
import fr.afcepf.al30.stock.dto.FournisseurDTO;
import fr.afcepf.al30.stock.entity.Fournisseur;
@Component
public class DaoFournisseur implements IDaoFournisseur {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	@Override
	public List<FournisseurDTO> getAll() {
		TypedQuery<Fournisseur> typedQuery = em.createQuery("SELECT f FROM Fournisseur f", Fournisseur.class);
		List<FournisseurDTO> dtoFournisseurs = new ArrayList<>();
		List<Fournisseur> fournisseurs = typedQuery.getResultList();
		for (Fournisseur fournisseur : fournisseurs) {
			FournisseurDTO dto = AssembleurDTO.fournisseurToFournisseurDTO(fournisseur);
			dtoFournisseurs.add(dto);
		}
		return dtoFournisseurs;
	}
	
	@Transactional
	@Override
	public FournisseurDTO getFournisseurById(int idFournisseur) {
		TypedQuery<Fournisseur> typedQuery = em.createQuery("SELECT f from Fournisseur f WHERE f.id = :idFournisseur", Fournisseur.class).setParameter("idFournisseur", idFournisseur);
		Fournisseur fournisseur = typedQuery.getSingleResult();
		return AssembleurDTO.fournisseurToFournisseurDTO(fournisseur);
	}

}
