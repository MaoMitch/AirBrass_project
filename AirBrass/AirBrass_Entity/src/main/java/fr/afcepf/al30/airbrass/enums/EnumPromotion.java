package fr.afcepf.al30.airbrass.enums;

import lombok.Getter;

@Getter
public enum EnumPromotion {
	DIX(0.10),
	VINGT(0.20),
	TRENTE(0.30),
	QUARANTE(0.40),
	CINQUANTE(0.50);
	
	private final Double value;

	private EnumPromotion(Double value) {
		this.value = value;
	}

	public static EnumPromotion fromValue(Double value) {
		 for (EnumPromotion enumPromotion : EnumPromotion.values()) {
	            if(enumPromotion.getValue().equals(value)) {
	                return enumPromotion;
	            }
	        }
	        return null;
	}
	
	

}
