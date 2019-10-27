package fr.afcepf.al30.assembleur;

import org.springframework.beans.BeanUtils;

import fr.afcepf.al30.dto.FormateurDTO;
import fr.afcepf.al30.dto.FormationDTO;
import fr.afcepf.al30.entity.Formateur;
import fr.afcepf.al30.entity.Formation;

public final class AssembleurDTO {

    private AssembleurDTO() {
    }

    public static Formation dtoToEntity(FormationDTO dto) {
        Formation form = new Formation();
        BeanUtils.copyProperties(dto, form);
        return form;
    }

    public static FormationDTO entityToDTO(Formation entity) {
        FormationDTO formDTO = new FormationDTO();
        BeanUtils.copyProperties(entity, formDTO);
        if (entity.getFormateur() != null) {
            formDTO.setFormateur(entityToDTO(entity.getFormateur()));
        }
        return formDTO;
    }

    public static Formateur dtoToEntity(FormateurDTO dto) {
        Formateur f = new Formateur();
        BeanUtils.copyProperties(dto, f);
        return f;
    }

    public static FormateurDTO entityToDTO(Formateur entity) {
        FormateurDTO fDTO = new FormateurDTO();
        BeanUtils.copyProperties(entity, fDTO);
        return fDTO;
    }
}
