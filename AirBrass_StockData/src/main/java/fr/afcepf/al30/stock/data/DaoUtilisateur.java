package fr.afcepf.al30.stock.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import fr.afcepf.al30.stock.assembleur.AssembleurDTO;
import fr.afcepf.al30.stock.dto.UtilisateurDTO;
import fr.afcepf.al30.stock.entity.Utilisateur;
@Component
public class DaoUtilisateur implements IDaoUtilisateur {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	@Override
	public UtilisateurDTO getUtilisateur(String login, String password) {
		UtilisateurDTO dto = new UtilisateurDTO();
		
		
		TypedQuery<Utilisateur> query = em.createQuery(
				"SELECT u FROM Utilisateur u WHERE u.login = :login AND u.password = :password",
				Utilisateur.class).setParameter("password", password).setParameter("login", login);
		List<Utilisateur> users = query.getResultList();
		if(!users.isEmpty()) {
			Utilisateur user = users.get(0);
			dto = AssembleurDTO.utilisateurToUtilisateurDTO(user);
		}	
		
		return dto;
	}

}
