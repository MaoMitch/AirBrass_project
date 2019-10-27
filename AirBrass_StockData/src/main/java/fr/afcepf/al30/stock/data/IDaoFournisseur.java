package fr.afcepf.al30.stock.data;

import java.util.List;

import fr.afcepf.al30.stock.dto.FournisseurDTO;

public interface IDaoFournisseur {
	
	List<FournisseurDTO> getAll();

	FournisseurDTO getFournisseurById(int idFournisseur);

}
