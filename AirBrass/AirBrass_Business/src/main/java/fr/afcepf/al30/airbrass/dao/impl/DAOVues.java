package fr.afcepf.al30.airbrass.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.afcepf.al30.airbrass.assembleur.AssembleurDTO;
import fr.afcepf.al30.airbrass.dao.api.IDAOVues;
import fr.afcepf.al30.airbrass.dto.DTOVues;
import fr.afcepf.al30.airbrass.entities.Vues;
import fr.afcepf.al30.airbrass.exceptions.AssembleurException;
@Stateless
public class DAOVues implements IDAOVues {

	@PersistenceContext(unitName = "AirBrass_PU")
	private EntityManager em;
	
	@Override
	public List<DTOVues> getVuesByProduit(int idProduit) throws AssembleurException {
		TypedQuery<Vues> typedQuery = em.createQuery("SELECT v FROM Vues v WHERE v.produit.id = :idProduit",Vues.class).setParameter("idProduit", idProduit);
		List<DTOVues> vuesDTO = new ArrayList<>();
		List<Vues> vues = typedQuery.getResultList();
		for (Vues vues2 : vues) {
			DTOVues vueDTO = AssembleurDTO.entityToDTO(vues2);
			vuesDTO.add(vueDTO);
		}
		return vuesDTO;
	}
	
	@Override
	public DTOVues addVues(DTOVues dto) throws AssembleurException {
		em.persist(AssembleurDTO.dtoToEntity(dto));
		return dto;
	}

}
