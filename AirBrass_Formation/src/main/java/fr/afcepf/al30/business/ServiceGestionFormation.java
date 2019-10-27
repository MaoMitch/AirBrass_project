package fr.afcepf.al30.business;

import fr.afcepf.al30.data.IDaoFormateur;
import fr.afcepf.al30.data.IDaoFormation;
import fr.afcepf.al30.dto.FormateurDTO;
import fr.afcepf.al30.dto.FormationDTO;
import fr.afcepf.al30.entity.Formation;

import javax.jws.WebService;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@WebService(targetNamespace = "http://formations.al30.afcepf.fr",
endpointInterface = "fr.afcepf.al30.business.IServiceGestionFormation",
serviceName="serviceFormation", portName="formport")
@Getter
@Setter
public class ServiceGestionFormation implements IServiceGestionFormation {

	private IDaoFormation daoFormation;
	private IDaoFormateur daoFormateur;
	
	@Override
	public List<FormationDTO> getAllFormations() {
		return daoFormation.getAll();
	}

	@Override
	public List<FormationDTO> getFormations(Formation formation, boolean seulementDispos) {
		return daoFormation.getFormations(formation, seulementDispos);
	}

	@Override
	public List<FormationDTO> getDisposByDate(Date selectedDate, boolean seulementDispos) {
		return daoFormation.getDisposByDate(selectedDate, seulementDispos);
	}

	@Override
	public FormationDTO getFormationById(Integer id) {
		return daoFormation.getFormationById(id);
	}

	@Override
	public boolean verifierDispoFormation(Formation formation) {
		return daoFormation.verifierDispoFormation(formation);
	}
	
	@Override
	public FormationDTO reserverFormation(FormationDTO formation) {
		return daoFormation.reserverFormation(formation);
	}

	@Override
	public List<FormateurDTO> getAllFormateurs() {
		return daoFormateur.getAll();
	}

	
	
}
