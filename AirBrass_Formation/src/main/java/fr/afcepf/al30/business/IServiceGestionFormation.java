package fr.afcepf.al30.business;

import fr.afcepf.al30.dto.FormateurDTO;
import fr.afcepf.al30.dto.FormationDTO;
import fr.afcepf.al30.entity.Formation;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.Date;
import java.util.List;

@WebService(targetNamespace = "http://formations.al30.afcepf.fr", name = "serviceFormation")
public interface IServiceGestionFormation {

	@WebMethod(operationName="getAllFormations")
	@WebResult(name="returnGetAllFormations")
	List<FormationDTO> getAllFormations();
	
	@WebMethod(operationName="getFormations")
	@WebResult(name="returnGetFormations")
	List<FormationDTO> getFormations(@WebParam(name="formation") Formation formation,
									@WebParam(name="seulementDispos") boolean seulementDispos);
	
	@WebMethod(operationName="getFormationsByDate")
	@WebResult(name="returnGetFormationsByDate")
	List<FormationDTO> getDisposByDate(@WebParam(name="dateSelectionnee") Date selectedDate,
			@WebParam(name="seulementDispos") boolean seulementDispos);

	@WebMethod(operationName="getFormationById")
	@WebResult(name="returnGetFormationById")
	FormationDTO getFormationById(@WebParam(name="idFormation") Integer id);

	@WebMethod(operationName="verifierDispoFormation")
	@WebResult(name="returnVerifierDispoFormation")
	boolean verifierDispoFormation(@WebParam(name="formation") Formation formation);
	
	@WebMethod(operationName="reserverFormation")
	@WebResult(name="returnReservationReussie")
	FormationDTO reserverFormation(@WebParam(name="formation") FormationDTO formation);
	
	@WebMethod(operationName="getAllFormateurs")
	@WebResult(name="returnGetAllFormateurs")
	List<FormateurDTO> getAllFormateurs();
}
