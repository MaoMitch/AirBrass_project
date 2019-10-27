package fr.afcepf.al30.airbrass.dto;

import java.io.Serializable;
import java.util.Date;

import fr.afcepf.al30.airbrass.enums.DTOEnumPromotion;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class DTOPromotion implements Serializable {

		private int id;
		private Date dateDebut;
		private Date dateFin;
		private DTOEnumPromotion dtoEnumPromotion;

		public DTOPromotion() {
			super();
		}

		public DTOPromotion(Date dateDebut, Date dateFin) {
			
			this.dateDebut = dateDebut;
			this.dateFin = dateFin;
		}
}
