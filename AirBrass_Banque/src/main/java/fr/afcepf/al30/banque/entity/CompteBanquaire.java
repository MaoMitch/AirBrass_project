package fr.afcepf.al30.banque.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

/**
 * Entite Compte banquaire.
 *
 * @author Stagiaire
 *
 */
@Entity
@Getter
@Setter
public class CompteBanquaire {

    /**
     * Identifiant unique dans l'unité de persistance.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Nom du compte.
     */
    private String nomCompte;
    /**
     * Numero du compte.
     */
    private String numeroCompte;
    /**
     * Solde du compte.
     */
    private double solde;
    /**
     * Liste des {@link CarteBanquaire} du compte.
     */
    @OneToMany(mappedBy = "compte")
    private List<CarteBanquaire> cartesbanquaires;
    /**
     * Liste des opérations où le compte est payeur.
     */
    @OneToMany(mappedBy = "comptePayeur")
    private List<Operation> operationsPaye;
    /**
     * Liste des opérations où le compte est crédité.
     */
    @OneToMany(mappedBy = "compteReceveur")
    private List<Operation> operationsRecu;

    public List<Operation> getOperationsPaye() {
        if (operationsPaye == null) {
            operationsPaye = new ArrayList<>();
        }
        return operationsPaye;
    }
    
    public List<Operation> getOperationsRecu() {
        if (operationsRecu == null) {
            operationsRecu = new ArrayList<>();
        }
        return operationsRecu;
    }
}
