package fr.afcepf.al30.airbrass.enums;

public enum DTOEnumPromotion {

    DIX(0.10),
    VINGT(0.20),
    TRENTE(0.30),
    QUARANTE(0.40),
    CINQUANTE(0.50);

    private final Double value;

    private DTOEnumPromotion(Double value) {
        this.value = value;
    }

    public static DTOEnumPromotion fromValue(Double value) {
        for (DTOEnumPromotion enumPromotion : DTOEnumPromotion.values()) {
            if (enumPromotion.getValue().equals(value)) {
                return enumPromotion;
            }
        }
        return null;
    }

    public Double getValue() {
        return value;
    }

}
