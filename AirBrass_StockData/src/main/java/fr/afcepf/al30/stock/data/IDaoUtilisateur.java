package fr.afcepf.al30.stock.data;

import fr.afcepf.al30.stock.dto.UtilisateurDTO;

@FunctionalInterface
public interface IDaoUtilisateur {
    UtilisateurDTO getUtilisateur(String login, String password);
}
