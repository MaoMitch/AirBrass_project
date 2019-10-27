package fr.afcepf.al30.entity;

public enum Disponibilite {
    DISPONIBLE("disponible"),
    RESERVE("réservé"),
    ANNULATION_CLIENT("annulation client"),
    ANNULATION_FORMATEUR("annulation formateur");

    private String dispo;

    private Disponibilite(String dispo) {
        this.dispo = dispo;
    }

    public String getDispo() {
        return dispo;
    }

}
