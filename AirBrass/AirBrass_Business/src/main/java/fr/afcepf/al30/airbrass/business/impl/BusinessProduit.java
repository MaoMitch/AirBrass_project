package fr.afcepf.al30.airbrass.business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.afcepf.al30.airbrass.dao.api.IDAOAvisClient;
import fr.afcepf.al30.airbrass.dao.api.IDAOMarque;
import fr.afcepf.al30.airbrass.dao.api.IDAOProduit;
import fr.afcepf.al30.airbrass.dao.api.IDAOSpecialisationProduit;
import fr.afcepf.al30.airbrass.dao.api.IDAOVues;
import fr.afcepf.al30.airbrass.dto.DTOAvisClient;
import fr.afcepf.al30.airbrass.dto.DTOMarque;
import fr.afcepf.al30.airbrass.dto.DTOProduit;
import fr.afcepf.al30.airbrass.dto.DTOSpecialisationProduit;
import fr.afcepf.al30.airbrass.dto.DTOVues;
import fr.afcepf.al30.airbrass.business.api.IBusinessProduit;
import fr.afcepf.al30.airbrass.enums.DTOTypeProduit;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;
import fr.afcepf.al30.airbrass.exceptions.AssembleurException;

import javax.ejb.Remote;

/**
 * Implementation de l'{@link IBusinessProduit}.
 */
@Remote(IBusinessProduit.class)
@Stateless
public class BusinessProduit implements IBusinessProduit {

    /**
     * le dao d'accès aux produits.
     */
    @EJB
    private IDAOProduit daoProduit;
    /**
     * le dao d'accès aux marques.
     */
    @EJB
    private IDAOMarque daoMarque;
    /**
     * le dao d'accès aux spécialisations.
     */
    @EJB
    private IDAOSpecialisationProduit daoSpecialisationProduit;
    
    @EJB
    private IDAOVues daoVues;
    
    @EJB
    private IDAOAvisClient daoAvisClient;

    @Override
    public List<DTOProduit> getAllProduits() throws AirBrassException {
        return daoProduit.getAll();
    }

    @Override
    public List<DTOMarque> getAllMarque() throws AirBrassException {
        return daoMarque.getAll();
    }

    @Override
    public List<DTOSpecialisationProduit> getAllSpecs() throws AirBrassException {
        return daoSpecialisationProduit.getAll();
    }

    @Override
    public List<DTOProduit> getProduitParOptions(List<String> specialisations, List<String> marques) throws AirBrassException {
        List<DTOProduit> liste = new ArrayList<>();
        for (DTOProduit produit : daoProduit.getAll()) {
            if (specialisations.contains(produit.getDtoSpecialisationProduit().getIntitule()) && (marques == null || marques.contains(produit.getDtoMarque().getIntitule()))) {
                liste.add(produit);
            }
        }
        return liste;
    }

    @Override
    public DTOProduit getProduitById(int idProduit) throws AirBrassException {
        return daoProduit.getArticleById(idProduit);
    }

    @Override
    public List<DTOProduit> getAllGuitares() throws AirBrassException {
        return getByTypeProduit(DTOTypeProduit.GUITARE);
    }
    
    private List<DTOProduit> getByTypeProduit(DTOTypeProduit typeProduit) throws AirBrassException {
        List<DTOProduit> result = new ArrayList<>();
        List<DTOProduit> allGuitares = daoProduit.getAll();
        for (DTOProduit guitare : allGuitares) {
            if(guitare.getDtoSpecialisationProduit().getDtoTypeProduit() == typeProduit)
                result.add(guitare);
        }
        return result;
    }

    @Override
    public List<DTOProduit> getAllAccessoire() throws AirBrassException {
        return getByTypeProduit(DTOTypeProduit.ACCESSOIRE);
    }

    /**
     * Methode d'obtention de la totalité des {@link DTOMarque} correspondant au
     * {@link DTOTypeProduit} présent dans la base de données.
     *
     * @param typeProduit le {@link DTOTypeProduit} souhaité.
     * @return la liste des {@link DTOMarque}
     * @throws AirBrassException <ul>
     * <li>Si le {@link DAOMarque} remonte une erreur</li>
     * </ul>
     */
    private List<DTOMarque> getAllMarqueByType(DTOTypeProduit typeProduit) throws AirBrassException {
        return daoMarque.getMarqueByTypeProduit(typeProduit);
    }

    /**
     * Methode d'obtention de la totalité des {@link DTOSpecialisationProduit}
     * correspondant au {@link DTOTypeProduit} présent dans la base de données.
     *
     * @param typeProduit le {@link DTOTypeProduit} souhaité.
     * @return la liste des {@link DTOSpecialisationProduit}
     * @throws AirBrassException <ul>
     * <li>Si le {@link DAOSpecialisationProduit} remonte une erreur</li>
     * </ul>
     */
    private List<DTOSpecialisationProduit> getAllSpecsByType(DTOTypeProduit typeProduit) throws AirBrassException {
        return daoSpecialisationProduit.getSpecialisationProduitByTypeProduit(typeProduit);
    }

    @Override
    public List<DTOMarque> getAllMarqueGuitare() throws AirBrassException {
        return getAllMarqueByType(DTOTypeProduit.GUITARE);
    }

    @Override
    public List<DTOMarque> getAllMarqueAccessoire() throws AirBrassException {
        return getAllMarqueByType(DTOTypeProduit.ACCESSOIRE);
    }

    @Override
    public List<DTOSpecialisationProduit> getAllSpecsGuitare() throws AirBrassException {
        return getAllSpecsByType(DTOTypeProduit.GUITARE);
    }

    @Override
    public List<DTOSpecialisationProduit> getAllSpecsAccessoire() throws AirBrassException {
        return getAllSpecsByType(DTOTypeProduit.ACCESSOIRE);
    }

	@Override
	public List<DTOVues> getVuesByProduit(int idProduit) throws AirBrassException {
		return daoVues.getVuesByProduit(idProduit);
	}
	
	@Override
	public DTOVues addVues(DTOVues dto) throws AssembleurException {
		return daoVues.addVues(dto);
	}
	
	@Override
	public List<DTOProduit> gelAllProduitBySpecialisation(String specialisationProduit) throws AirBrassException {
		return daoProduit.getAllArticleBySpecialisation(specialisationProduit);
	}
	
	@Override
	public List<DTOProduit> getProduitsByMarque(String intituleMarque) throws AssembleurException {
		return daoProduit.getProduitByMarque(intituleMarque);
	}
	
	@Override
	public List<DTOAvisClient> getAvisByProduit(int idProduit) throws AirBrassException {
		return daoAvisClient.getAvisClientByProduit(idProduit);
	}
	
	@Override
	public List<DTOProduit> getProduitPromotion() throws AssembleurException {
		return daoProduit.getProduitPromotion();
	}
	
	@Override
	public List<DTOProduit> getAccessoirePromotion() throws AssembleurException {
		return daoProduit.getAccessoiretPromotion();
	}
	
}
