package fr.afcepf.al30.airbrass.dao.api;

import java.util.List;

import fr.afcepf.al30.airbrass.dto.DTOVues;
import fr.afcepf.al30.airbrass.exceptions.AssembleurException;

public interface IDAOVues {
	
	List<DTOVues> getVuesByProduit(int idProduit) throws AssembleurException;

	DTOVues addVues(DTOVues dto) throws AssembleurException;

}
