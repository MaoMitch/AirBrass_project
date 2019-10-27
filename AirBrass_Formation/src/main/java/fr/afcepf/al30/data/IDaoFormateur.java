package fr.afcepf.al30.data;

import java.util.List;

import fr.afcepf.al30.dto.FormateurDTO;

@FunctionalInterface
public interface IDaoFormateur{
	List<FormateurDTO> getAll();
}
