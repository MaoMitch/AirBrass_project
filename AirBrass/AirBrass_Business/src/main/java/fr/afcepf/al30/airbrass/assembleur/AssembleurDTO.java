package fr.afcepf.al30.airbrass.assembleur;

import fr.afcepf.al30.airbrass.exceptions.AssembleurException;
import fr.afcepf.al30.airbrass.dto.DTOAdresse;
import fr.afcepf.al30.airbrass.dto.DTOAvisClient;
import fr.afcepf.al30.airbrass.dto.DTOCB;
import fr.afcepf.al30.airbrass.dto.DTOCommande;
import fr.afcepf.al30.airbrass.dto.DTOLigneCommande;
import fr.afcepf.al30.airbrass.dto.DTOMarque;
import fr.afcepf.al30.airbrass.dto.DTOPays;
import fr.afcepf.al30.airbrass.dto.DTOPersonne;
import fr.afcepf.al30.airbrass.dto.DTOProduit;
import fr.afcepf.al30.airbrass.dto.DTOPromotion;
import fr.afcepf.al30.airbrass.dto.DTOSpecialisationProduit;
import fr.afcepf.al30.airbrass.dto.DTOVille;
import fr.afcepf.al30.airbrass.dto.DTOVues;
import fr.afcepf.al30.airbrass.entities.Adresse;
import fr.afcepf.al30.airbrass.entities.AvisClient;
import fr.afcepf.al30.airbrass.entities.CB;
import fr.afcepf.al30.airbrass.entities.Commande;
import fr.afcepf.al30.airbrass.entities.LigneCommande;
import fr.afcepf.al30.airbrass.entities.Marque;
import fr.afcepf.al30.airbrass.entities.Pays;
import fr.afcepf.al30.airbrass.entities.Personne;
import fr.afcepf.al30.airbrass.entities.Produit;
import fr.afcepf.al30.airbrass.entities.Promotion;
import fr.afcepf.al30.airbrass.entities.SpecialisationProduit;
import fr.afcepf.al30.airbrass.entities.Ville;
import fr.afcepf.al30.airbrass.entities.Vues;
import fr.afcepf.al30.airbrass.enums.DTOEnumPromotion;
import fr.afcepf.al30.airbrass.enums.DTOTypeProduit;
import fr.afcepf.al30.airbrass.enums.EnumPromotion;
import fr.afcepf.al30.airbrass.enums.TypeProduit;
import fr.afcepf.al30.airbrass.exceptions.ExceptionEnum;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

/**
 * Cette class permet de passer d'une entité à son DTO.
 */
public final class AssembleurDTO {

    private static Logger log = Logger.getLogger(AssembleurDTO.class);

    /**
     * Le message d'erreur entité null.
     */
    private static final String ERREUR_ENTITE_NULL = "L'entité était null";

    /**
     * Le message d'erreur dto null.
     */
    private static final String ERREUR_DTO_NULL = "Le DTO était null";

    /**
     * Default constructor.
     */
    private AssembleurDTO() {
        //To prevent instantiation.
    }

    /**
     * Passage d'une {@link Adresse} à son {@link DTOAdresse}.
     *
     * @param adresse l'{@link Adresse} dont on veux le {@link DTOAdresse}
     * @return le {@link DTOAdresse} correspondant à l'{@link Adresse}
     * @throws AssembleurException <ul>
     * <li>Si l'objet est null</li>
     * </ul>
     */
    public static DTOAdresse entityToDTO(Adresse adresse) throws AssembleurException {
        if (adresse != null) {
            DTOAdresse dto = new DTOAdresse();
            try {
                BeanUtils.copyProperties(dto, adresse);
                if (adresse.getVille() != null) {
                    dto.setDtoVille(entityToDTO(adresse.getVille()));
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(e);
            }
            return dto;
        } else {
            throw new AssembleurException(ExceptionEnum.ENTITTE_NULL, ERREUR_ENTITE_NULL);
        }

    }

    /**
     * Passage d'une {@link DTOAdresse} à son {@link Adresse}.
     *
     * @param adresseDTO l'{@link DTOAdresse} dont on veux le {@link Adresse}
     * @return l' {@link Adresse} correspondant au {@link DTOAdresse}
     * @throws AssembleurException <ul>
     * <li>Si l'objet est null</li>
     * </ul>
     */
    public static Adresse dtoToEntity(DTOAdresse adresseDTO) throws AssembleurException {
        if (adresseDTO != null) {
            Adresse adresse = new Adresse();
            try {
                BeanUtils.copyProperties(adresse, adresseDTO);
                if (adresseDTO.getDtoVille() != null) {
                    adresse.setVille(AssembleurDTO.dtoToEntity(adresseDTO.getDtoVille()));
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(e);
            }
            return adresse;
        } else {
            throw new AssembleurException(ExceptionEnum.DTO_NULL, ERREUR_DTO_NULL);
        }
    }

    /**
     * Passage d'une {@link AvisClient} à son {@link DTOAvisClient}.
     *
     * @param avis l'{@link AvisClient} dont on veux le {@link DTOAvisClient}
     * @return le {@link DTOAvisClient} correspondant à l'{@link AvisClient}
     * @throws AssembleurException <ul>
     * <li>Si l'objet est null</li>
     * </ul>
     */
    public static DTOAvisClient entityToDTO(AvisClient avis) throws AssembleurException {
        if (avis != null) {
            DTOAvisClient dto = new DTOAvisClient();
            try {
                BeanUtils.copyProperties(dto, avis);
                if (avis.getPersonne() != null) {
                    dto.setDtoPersonne(entityToDTO(avis.getPersonne()));
                }
                if (avis.getProduit() != null) {
                    dto.setDtoProduit(entityToDTO(avis.getProduit()));
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(e);
            }
            return dto;
        } else {
            throw new AssembleurException(ExceptionEnum.ENTITTE_NULL, ERREUR_ENTITE_NULL);
        }
    }

    /**
     * Passage d'une {@link DTOAvisClient} à son {@link AvisClient}.
     *
     * @param avisDTO l'{@link DTOAvisClient} dont on veux le {@link AvisClient}
     * @return le {@link AvisClient} correspondant à l'{@link DTOAvisClient}
     * @throws AssembleurException <ul>
     * <li>Si l'objet est null</li>
     * </ul>
     */
    public static AvisClient dtoToEntity(DTOAvisClient avisDTO) throws AssembleurException {
        if (avisDTO != null) {
            AvisClient avis = new AvisClient();
            try {
                BeanUtils.copyProperties(avis, avisDTO);
                if (avisDTO.getDtoPersonne() != null) {
                    avis.setPersonne(AssembleurDTO.dtoToEntity(avisDTO.getDtoPersonne()));
                }
                if (avisDTO.getDtoProduit() != null) {
                    avis.setProduit(AssembleurDTO.dtoToEntity(avisDTO.getDtoProduit()));
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(e);
            }
            return avis;
        } else {
            throw new AssembleurException(ExceptionEnum.DTO_NULL, ERREUR_DTO_NULL);
        }
    }

    /**
     * Passage d'une {@link CB} à son {@link DTOCB}.
     *
     * @param cb l'{@link CB} dont on veux le {@link DTOCB}
     * @return le {@link DTOCB} correspondant à l'{@link CB}
     * @throws AssembleurException <ul>
     * <li>Si l'objet est null</li>
     * </ul>
     */
    public static DTOCB entityToDTO(CB cb) throws AssembleurException {
        if (cb != null) {
            DTOCB dto = new DTOCB();
            try {
                BeanUtils.copyProperties(dto, cb);
                if (cb.getPersonne() != null) {
                    dto.setDtoPersonne(entityToDTO(cb.getPersonne()));
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(e);
            }
            return dto;
        } else {
            throw new AssembleurException(ExceptionEnum.ENTITTE_NULL, ERREUR_ENTITE_NULL);
        }
    }

    /**
     * Passage d'une {@link DTOCB} à son {@link CB}.
     *
     * @param cbDTO l'{@link DTOCB} dont on veux le {@link CB}
     * @return le {@link CB} correspondant à l'{@link DTOCB}
     * @throws AssembleurException <ul>
     * <li>Si l'objet est null</li>
     * </ul>
     */
    public static CB dtoToEntity(DTOCB cbDTO) throws AssembleurException {
        if (cbDTO != null) {
            CB cb = new CB();
            try {
                BeanUtils.copyProperties(cb, cbDTO);
                if (cbDTO.getDtoPersonne() != null) {
                    cb.setPersonne(AssembleurDTO.dtoToEntity(cbDTO.getDtoPersonne()));
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(e);
            }
            return cb;
        } else {
            throw new AssembleurException(ExceptionEnum.DTO_NULL, ERREUR_DTO_NULL);
        }
    }

    /**
     * Passage d'une {@link Commande} à son {@link DTOCommande}.
     *
     * @param commande l'{@link Commande} dont on veux le {@link DTOCommande}
     * @return le {@link DTOCommande} correspondant à l'{@link Commande}
     * @throws AssembleurException <ul>
     * <li>Si l'objet est null</li>
     * </ul>
     */
    public static DTOCommande entityToDTO(Commande commande) throws AssembleurException {
        if (commande != null) {
            DTOCommande dto = new DTOCommande();
            try {
                BeanUtils.copyProperties(dto, commande);
                if (commande.getPersonne() != null) {
                    dto.setDtoPersonne(entityToDTO(commande.getPersonne()));
                }
                if (commande.getLigneCommandes() != null) {
                    chargerListeDTOLigneCommande(dto, commande);
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(e);
            }
            return dto;
        } else {
            throw new AssembleurException(ExceptionEnum.ENTITTE_NULL, ERREUR_ENTITE_NULL);
        }
    }

    public static void chargerListeDTOLigneCommande(DTOCommande dto, Commande commande) throws AssembleurException {
        dto.setDtoLigneCommandes(new ArrayList<>());
        for (LigneCommande ligneCommande : commande.getLigneCommandes()) {
            dto.getDtoLigneCommandes().add(entityToDTO(ligneCommande));
        }
    }

    /**
     * Passage d'une {@link DTOCommande} à son {@link Commande}.
     *
     * @param commandeDTO l'{@link DTOCommande} dont on veux le {@link Commande}
     * @return le {@link Commande} correspondant à l'{@link DTOCommande}
     * @throws AssembleurException <ul>
     * <li>Si l'objet est null</li>
     * </ul>
     */
    public static Commande dtoToEntity(DTOCommande commandeDTO) throws AssembleurException {
        if (commandeDTO != null) {
            Commande commande = new Commande();
            try {
                BeanUtils.copyProperties(commande, commandeDTO);
                if (commandeDTO.getDtoPersonne() != null) {
                    commande.setPersonne(AssembleurDTO.dtoToEntity(commandeDTO.getDtoPersonne()));
                }
                if (commandeDTO.getDtoLigneCommandes() != null) {
                    chargerListeLigneCommande(commande, commandeDTO);
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(e);
            }
            return commande;
        } else {
            throw new AssembleurException(ExceptionEnum.DTO_NULL, ERREUR_DTO_NULL);
        }
    }

    public static void chargerListeLigneCommande(Commande commande, DTOCommande dto) throws AssembleurException {
        commande.setLigneCommandes(new ArrayList<>());
        for (DTOLigneCommande ligneCommande : dto.getDtoLigneCommandes()) {
            commande.getLigneCommandes().add(dtoToEntity(ligneCommande));
        }
    }

    /**
     * Passage d'une {@link LigneCommande} à son {@link DTOLigneCommande}.
     *
     * @param ligne l'{@link LigneCommande} dont on veux le
     * {@link DTOLigneCommande}
     * @return le {@link DTOLigneCommande} correspondant à
     * l'{@link LigneCommande}
     * @throws AssembleurException <ul>
     * <li>Si l'objet est null</li>
     * </ul>
     */
    public static DTOLigneCommande entityToDTO(LigneCommande ligne) throws AssembleurException {
        if (ligne != null) {
            DTOLigneCommande dto = new DTOLigneCommande();
            try {
                BeanUtils.copyProperties(dto, ligne);
                if (ligne.getProduit() != null) {
                    dto.setDtoProduit(entityToDTO(ligne.getProduit()));
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(e);
            }
            return dto;
        } else {
            throw new AssembleurException(ExceptionEnum.ENTITTE_NULL, ERREUR_ENTITE_NULL);
        }
    }

    /**
     * Passage d'une {@link DTOLigneCommande} à son {@link LigneCommande}.
     *
     * @param ligneDTO l'{@link DTOLigneCommande} dont on veux le
     * {@link LigneCommande}
     * @return le {@link LigneCommande} correspondant à
     * l'{@link DTOLigneCommande}
     * @throws AssembleurException <ul>
     * <li>Si l'objet est null</li>
     * </ul>
     */
    public static LigneCommande dtoToEntity(DTOLigneCommande ligneDTO) throws AssembleurException {
        if (ligneDTO != null) {
            LigneCommande ligneCommande = new LigneCommande();
            try {
                BeanUtils.copyProperties(ligneCommande, ligneDTO);
                if (ligneDTO.getDtoProduit() != null) {
                    ligneCommande.setProduit(AssembleurDTO.dtoToEntity(ligneDTO.getDtoProduit()));
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(e);
            }
            return ligneCommande;
        } else {
            throw new AssembleurException(ExceptionEnum.DTO_NULL, ERREUR_DTO_NULL);
        }
    }

    /**
     * Passage d'une {@link Marque} à son {@link DTOMarque}.
     *
     * @param marque l'{@link Marque} dont on veux le {@link DTOMarque}
     * @return le {@link DTOMarque} correspondant à l'{@link Marque}
     * @throws AssembleurException <ul>
     * <li>Si l'objet est null</li>
     * </ul>
     */
    public static DTOMarque entityToDTO(Marque marque) throws AssembleurException {
        if (marque != null) {
            DTOMarque dto = new DTOMarque();
            try {
                BeanUtils.copyProperties(dto, marque);
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(e);
            }
            return dto;
        } else {
            throw new AssembleurException(ExceptionEnum.ENTITTE_NULL, ERREUR_ENTITE_NULL);
        }
    }

    /**
     * Passage d'une {@link DTOMarque} à son {@link Marque}.
     *
     * @param marqueDTO l'{@link DTOMarque} dont on veux le {@link Marque}
     * @return le {@link Marque} correspondant à l'{@link DTOMarque}
     * @throws AssembleurException <ul>
     * <li>Si l'objet est null</li>
     * </ul>
     */
    public static Marque dtoToEntity(DTOMarque marqueDTO) throws AssembleurException {
        if (marqueDTO != null) {
            Marque marque = new Marque();
            try {
                BeanUtils.copyProperties(marque, marqueDTO);
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(e);
            }
            return marque;
        } else {
            throw new AssembleurException(ExceptionEnum.DTO_NULL, ERREUR_DTO_NULL);
        }
    }

    /**
     * Passage d'une {@link Pays} à son {@link DTOPays}.
     *
     * @param pays l'{@link Pays} dont on veux le {@link DTOPays}
     * @return le {@link DTOPays} correspondant à l'{@link Pays}
     * @throws AssembleurException <ul>
     * <li>Si l'objet est null</li>
     * </ul>
     */
    public static DTOPays entityToDTO(Pays pays) throws AssembleurException {
        if (pays != null) {
            DTOPays dto = new DTOPays();
            try {
                BeanUtils.copyProperties(dto, pays);
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(e);
            }
            return dto;
        } else {
            throw new AssembleurException(ExceptionEnum.ENTITTE_NULL, ERREUR_ENTITE_NULL);
        }
    }

    /**
     * Passage d'une {@link DTOPays} à son {@link Pays}.
     *
     * @param paysDTO l'{@link DTOPays} dont on veux le {@link Pays}
     * @return le {@link Pays} correspondant à l'{@link DTOPays}
     * @throws AssembleurException <ul>
     * <li>Si l'objet est null</li>
     * </ul>
     */
    public static Pays dtoToEntity(DTOPays paysDTO) throws AssembleurException {
        if (paysDTO != null) {
            Pays pays = new Pays();
            try {
                BeanUtils.copyProperties(pays, paysDTO);
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(e);
            }
            return pays;
        } else {
            throw new AssembleurException(ExceptionEnum.DTO_NULL, ERREUR_DTO_NULL);
        }
    }

    /**
     * Passage d'une {@link Personne} à son {@link DTOPersonne}.
     *
     * @param personne l'{@link Personne} dont on veux le {@link DTOPersonne}
     * @return le {@link DTOPersonne} correspondant à l'{@link Personne}
     * @throws AssembleurException <ul>
     * <li>Si l'objet est null</li>
     * </ul>
     */
    public static DTOPersonne entityToDTO(Personne personne) throws AssembleurException {
        if (personne != null) {
            DTOPersonne dto = new DTOPersonne();
            try {
                BeanUtils.copyProperties(dto, personne);
                for (Adresse adresse : personne.getAdresses()) {
                    dto.getDtoAdresses().add(entityToDTO(adresse));
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(e);
            }
            return dto;
        } else {
            throw new AssembleurException(ExceptionEnum.ENTITTE_NULL, ERREUR_ENTITE_NULL);
        }
    }

    /**
     * Passage d'une {@link DTOPersonne} à son {@link Personne}.
     *
     * @param personneDTO l'{@link DTOPersonne} dont on veux le {@link Personne}
     * @return le {@link Personne} correspondant à l'{@link DTOPersonne}
     * @throws AssembleurException <ul>
     * <li>Si l'objet est null</li>
     * </ul>
     */
    public static Personne dtoToEntity(DTOPersonne personneDTO) throws AssembleurException {
        if (personneDTO != null) {
            Personne personne = new Personne();
            try {
                BeanUtils.copyProperties(personne, personneDTO);
                for (DTOAdresse dtoAdresse : personneDTO.getDtoAdresses()) {
                    personne.getAdresses().add(AssembleurDTO.dtoToEntity(dtoAdresse));
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(e);
            }
            return personne;
        } else {
            throw new AssembleurException(ExceptionEnum.DTO_NULL, ERREUR_DTO_NULL);
        }
    }

    /**
     * Passage d'une {@link Produit} à son {@link DTOProduit}.
     *
     * @param produit l'{@link Produit} dont on veux le {@link DTOProduit}
     * @return le {@link DTOProduit} correspondant à l'{@link Produit}
     * @throws AssembleurException <ul>
     * <li>Si l'objet est null</li>
     * </ul>
     */
    public static DTOProduit entityToDTO(Produit produit) throws AssembleurException {
        if (produit != null) {
            DTOProduit dto = new DTOProduit();
            try {
                BeanUtils.copyProperties(dto, produit);
                if (produit.getMarque() != null) {
                    dto.setDtoMarque(entityToDTO(produit.getMarque()));
                }
                if (produit.getSpecialisationProduit() != null) {
                    dto.setDtoSpecialisationProduit(entityToDTO(produit.getSpecialisationProduit()));
                }
                if (produit.getPromotion() != null) {
                    dto.setDtoPromotion(entityToDTO(produit.getPromotion()));
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(e);
            }
            return dto;
        } else {
            throw new AssembleurException(ExceptionEnum.ENTITTE_NULL, ERREUR_ENTITE_NULL);
        }
    }

    /**
     * Passage d'une {@link DTOProduit} à son {@link Produit}.
     *
     * @param produitDTO l'{@link DTOProduit} dont on veux le {@link Produit}
     * @return le {@link Produit} correspondant à l'{@link DTOProduit}
     * @throws AssembleurException <ul>
     * <li>Si l'objet est null</li>
     * </ul>
     */
    public static Produit dtoToEntity(DTOProduit produitDTO) throws AssembleurException {
        if (produitDTO != null) {
            Produit produit = new Produit();
            try {
                BeanUtils.copyProperties(produit, produitDTO);
                if (produitDTO.getDtoMarque() != null) {
                    produit.setMarque(AssembleurDTO.dtoToEntity(produitDTO.getDtoMarque()));
                }
                if (produitDTO.getDtoSpecialisationProduit() != null) {
                    produit.setSpecialisationProduit(AssembleurDTO.dtoToEntity(produitDTO.getDtoSpecialisationProduit()));
                }
                if (produitDTO.getDtoPromotion() != null) {
                    produit.setPromotion(dtoToEntity(produitDTO.getDtoPromotion()));
                }

            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(e);
            }
            return produit;
        } else {
            throw new AssembleurException(ExceptionEnum.DTO_NULL, ERREUR_DTO_NULL);
        }
    }

    /**
     * Passage d'une {@link SpecialisationProduit} à son
     * {@link DTOSpecialisationProduit}.
     *
     * @param speProd l'{@link SpecialisationProduit} dont on veux le
     * {@link DTOSpecialisationProduit}
     * @return le {@link DTOSpecialisationProduit} correspondant à
     * l'{@link SpecialisationProduit}
     * @throws AssembleurException <ul>
     * <li>Si l'objet est null</li>
     * </ul>
     */
    public static DTOSpecialisationProduit entityToDTO(SpecialisationProduit speProd) throws AssembleurException {
        if (speProd != null) {
            DTOSpecialisationProduit dto = new DTOSpecialisationProduit();
            try {
                BeanUtils.copyProperties(dto, speProd);
                dto.setDtoTypeProduit(entityToDTO(speProd.getTypeProduit()));
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(e);
            }
            return dto;
        } else {
            throw new AssembleurException(ExceptionEnum.ENTITTE_NULL, ERREUR_ENTITE_NULL);
        }
    }

    /**
     * Passage d'une {@link DTOSpecialisationProduit} à son
     * {@link SpecialisationProduit}.
     *
     * @param speProdDTO l'{@link DTOSpecialisationProduit} dont on veux le
     * {@link SpecialisationProduit}
     * @return le {@link SpecialisationProduit} correspondant à
     * l'{@link DTOSpecialisationProduit}
     * @throws AssembleurException <ul>
     * <li>Si l'objet est null</li>
     * </ul>
     */
    public static SpecialisationProduit dtoToEntity(DTOSpecialisationProduit speProdDTO) throws AssembleurException {
        if (speProdDTO != null) {
            SpecialisationProduit speProduit = new SpecialisationProduit();
            try {
                BeanUtils.copyProperties(speProduit, speProdDTO);
                speProduit.setTypeProduit(dtoToEntity(speProdDTO.getDtoTypeProduit()));
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(e);
            }
            return speProduit;
        } else {
            throw new AssembleurException(ExceptionEnum.DTO_NULL, ERREUR_DTO_NULL);
        }
    }

    /**
     * Passage d'une {@link TypeProduit} à son {@link DTOTypeProduit}.
     *
     * @param typeProduit l'{@link TypeProduit} dont on veux le
     * {@link DTOTypeProduit}
     * @return le {@link DTOTypeProduit} correspondant à l'{@link TypeProduit}
     */
    public static DTOTypeProduit entityToDTO(TypeProduit typeProduit) {
        return DTOTypeProduit.fromValue(typeProduit.getValue());
    }

    /**
     * Passage d'une {@link DTOTypeProduit} à son {@link TypeProduit}.
     *
     * @param dtoTypeProduit l'{@link DTOTypeProduit} dont on veux le
     * {@link TypeProduit}
     * @return le {@link TypeProduit} correspondant à l'{@link DTOTypeProduit}
     */
    public static TypeProduit dtoToEntity(DTOTypeProduit dtoTypeProduit) {
        return TypeProduit.fromValue(dtoTypeProduit.getValue());
    }

    /**
     * Passage d'une {@link Ville} à son {@link DTOVille}.
     *
     * @param ville l'{@link Ville} dont on veux le {@link DTOVille}
     * @return le {@link DTOVille} correspondant à l'{@link Ville}
     * @throws AssembleurException <ul>
     * <li>Si l'objet est null</li>
     * </ul>
     */
    public static DTOVille entityToDTO(Ville ville) throws AssembleurException {
        if (ville != null) {
            DTOVille dto = new DTOVille();
            try {
                BeanUtils.copyProperties(dto, ville);
                if (ville.getPays() != null) {
                    dto.setDtoPays(entityToDTO(ville.getPays()));
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(e);
            }
            return dto;
        } else {
            throw new AssembleurException(ExceptionEnum.ENTITTE_NULL, ERREUR_ENTITE_NULL);
        }
    }

    /**
     * Passage d'une {@link DTOVille} à son {@link Ville}.
     *
     * @param villeDTO l'{@link DTOVille} dont on veux le {@link Ville}
     * @return le {@link Ville} correspondant à l'{@link DTOVille}
     * @throws AssembleurException <ul>
     * <li>Si l'objet est null</li>
     * </ul>
     */
    public static Ville dtoToEntity(DTOVille villeDTO) throws AssembleurException {
        if (villeDTO != null) {
            Ville ville = new Ville();
            try {
                BeanUtils.copyProperties(ville, villeDTO);
                if (villeDTO.getDtoPays() != null) {
                    ville.setPays(AssembleurDTO.dtoToEntity(villeDTO.getDtoPays()));
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(e);
            }
            return ville;
        } else {
            throw new AssembleurException(ExceptionEnum.DTO_NULL, ERREUR_DTO_NULL);
        }
    }

    public static Vues dtoToEntity(DTOVues vuesDTO) throws AssembleurException {
        if (vuesDTO != null) {
            Vues vues = new Vues();
            try {
                BeanUtils.copyProperties(vues, vuesDTO);
                if (vuesDTO.getDtoProduit() != null) {
                    vues.setProduit(AssembleurDTO.dtoToEntity(vuesDTO.getDtoProduit()));
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(e);
            }
            return vues;
        } else {
            throw new AssembleurException(ExceptionEnum.DTO_NULL, ERREUR_DTO_NULL);
        }
    }

    public static DTOVues entityToDTO(Vues vues) throws AssembleurException {
        if (vues != null) {
            DTOVues vuesDTO = new DTOVues();
            try {
                BeanUtils.copyProperties(vuesDTO, vues);
                if (vues.getProduit() != null) {
                    vuesDTO.setDtoProduit(AssembleurDTO.entityToDTO(vues.getProduit()));
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(e);
            }
            return vuesDTO;
        } else {
            throw new AssembleurException(ExceptionEnum.ENTITTE_NULL, ERREUR_ENTITE_NULL);
        }
    }

    public static DTOEnumPromotion entityToDTO(EnumPromotion enumPromotion) {
        return DTOEnumPromotion.fromValue(enumPromotion.getValue());
    }

    public static EnumPromotion dtoToEntity(DTOEnumPromotion dtoEnumPromotion) {
        return EnumPromotion.fromValue(dtoEnumPromotion.getValue());
    }

    public static DTOPromotion entityToDTO(Promotion promotion) throws AssembleurException {
        if (promotion != null) {
            DTOPromotion promotionDTO = new DTOPromotion();
            try {
                BeanUtils.copyProperties(promotionDTO, promotion);
                promotionDTO.setDtoEnumPromotion(entityToDTO(promotion.getEnumPromo()));

            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(e);
            }
            return promotionDTO;
        } else {
            throw new AssembleurException(ExceptionEnum.ENTITTE_NULL, ERREUR_ENTITE_NULL);
        }
    }

    public static Promotion dtoToEntity(DTOPromotion promotionDTO) throws AssembleurException {
        if (promotionDTO != null) {
            Promotion promotion = new Promotion();
            try {
                BeanUtils.copyProperties(promotion, promotionDTO);
                promotion.setEnumPromo(dtoToEntity(promotionDTO.getDtoEnumPromotion()));

            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(e);
            }
            return promotion;
        } else {
            throw new AssembleurException(ExceptionEnum.DTO_NULL, ERREUR_DTO_NULL);
        }
    }

}
