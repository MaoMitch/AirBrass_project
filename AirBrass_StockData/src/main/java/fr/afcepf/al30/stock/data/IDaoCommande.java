package fr.afcepf.al30.stock.data;

import java.util.List;

import fr.afcepf.al30.stock.dto.CommandeDTO;
import fr.afcepf.al30.stock.dto.LigneCommandeDTO;

public interface IDaoCommande {

	List<CommandeDTO> getAllCommande();
	List<LigneCommandeDTO> getLigneByCommande(int idCommande);
	CommandeDTO addCommande(CommandeDTO commande);
	LigneCommandeDTO addLigneCommande(LigneCommandeDTO ligne);
	CommandeDTO maj(CommandeDTO commande);
	List<CommandeDTO> getCommandeByStatutCommande(String statutCommande);
}
