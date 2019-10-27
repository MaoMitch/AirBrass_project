package fr.afcepf.al30.data;

import fr.afcepf.al30.dto.FormationDTO;
import fr.afcepf.al30.entity.Formation;

import java.util.Date;
import java.util.List;

public interface IDaoFormation {
	/**
	 * Méthode permettant de récupérer la liste de toutes les formations.
	 **/
	List<FormationDTO> getAll();

	/**
	 * Méthode permettant de récupérer la liste de toutes les formations ayant tous les attributs
	 * en commun avec l'objet {@link Formation} reçu par le WS.
	 * @param formation Formation dont on veut trouver des correspondances avec ses attributs
	 * @param seulementDisponible A laisser à True par défaut. N'affiche que les formations disponibles si True.
	 * @return une liste de formations
	 */
	List<FormationDTO> getFormations(Formation formation, boolean seulementDisponible);

	/**
	 * Méthode retournant une liste de toutes les formations à une date donnée.
	 * @param date Date choisie
	 * @param seulementDisponible A laisser à True par défaut. N'affiche que les formations disponibles si True.
	 * @return une liste de formations
	 */
	List<FormationDTO> getDisposByDate(Date date, boolean seulementDisponible);

	/**
	 * Méthode retournant une formation via son indentifiant.
	 * @param id idenitifiant
	 * @return une formation
	 */
	FormationDTO getFormationById(Integer id);

	/**
	 * Méthode vérifiant si la formation est Disponible.
	 * @param formation Formation choisie
	 * @return un boolean
	 */
	boolean verifierDispoFormation(Formation formation);

	/**
	 * Méthode permettant de passer une formation de Disponible à Réservée.
	 * @param formation Formation choisie
	 * @return la formation réservée
	 */
	FormationDTO reserverFormation(FormationDTO formation);

}
