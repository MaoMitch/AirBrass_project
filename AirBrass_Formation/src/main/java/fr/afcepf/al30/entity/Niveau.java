package fr.afcepf.al30.entity;

public enum Niveau {
    DEBUTANT("débutant"),
    CONFIRME("confirmé"),
    EXPERT("expert"),
    TOUTNIVEAU("tout niveau");

    private String niveauDePratique;

    private Niveau(String niveau) {
        this.niveauDePratique = niveau;
    }

    public String getNiveauDePratique() {
        return niveauDePratique;
    }

}
