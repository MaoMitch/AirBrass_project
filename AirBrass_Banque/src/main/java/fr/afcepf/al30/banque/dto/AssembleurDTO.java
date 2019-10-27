package fr.afcepf.al30.banque.dto;

import org.springframework.beans.BeanUtils;

import fr.afcepf.al30.banque.entity.CarteBanquaire;
import fr.afcepf.al30.banque.entity.CompteBanquaire;

/**
 * Classe pour convertir les entitités en data object transfert simplifié ou
 * l'inverse.
 *
 * @author Stagiaire
 *
 */
public final class AssembleurDTO {

    private AssembleurDTO() {
    }
    /**
     * Entite {@link CarteBanquaire} vers DTO {@link CarteBanquaireDTO}.
     *
     * @param entity
     * @return DTO
     */
    public static CarteBanquaireDTO entityToDto(CarteBanquaire entity) {
        CarteBanquaireDTO carteDto = new CarteBanquaireDTO();
        BeanUtils.copyProperties(entity, carteDto);
        if (entity.getCompte() != null) {
            carteDto.setCompteDto(entityToDto(entity.getCompte()));
        }
        return carteDto;
    }

    /**
     * DTO {@link CarteBanquaireDTO} vers Entite {@link CarteBanquaire}.
     *
     * @param dto
     * @return entite
     */
    public static CarteBanquaire dtoToEntity(CarteBanquaireDTO dto) {
        CarteBanquaire carte = new CarteBanquaire();
        BeanUtils.copyProperties(dto, carte);
        if (dto.getCompteDto() != null) {
            carte.setCompte(dtoToEntity(dto.getCompteDto()));
        }
        return carte;
    }

    /**
     * Entite {@link CompteBanquaire} vers DTO {@link CompteBanquaireDTO}.
     *
     * @param entity
     * @return DTO
     */
    public static CompteBanquaireDTO entityToDto(CompteBanquaire entity) {
        CompteBanquaireDTO dto = new CompteBanquaireDTO();
        BeanUtils.copyProperties(entity, dto);
        
        return dto;
    }

    /**
     * DTO {@link CompteBanquaireDTO} vers Entite {@link CompteBanquaire}.
     *
     * @param dto
     * @return entite
     */
    public static CompteBanquaire dtoToEntity(CompteBanquaireDTO dto) {
        CompteBanquaire compte = new CompteBanquaire();
        BeanUtils.copyProperties(dto, compte);
        return compte;
    }
    
}
