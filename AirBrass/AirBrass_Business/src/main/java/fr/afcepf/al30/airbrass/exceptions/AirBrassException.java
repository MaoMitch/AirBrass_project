package fr.afcepf.al30.airbrass.exceptions;

/**
 * Les exceptions lancé par le projet AirBrass.
 * @author Max Michel
 */
public class AirBrassException extends Exception {
    /**
     * Code d'erreur de l'exception. Permet le traitement de celle-ci.
     */
    private final ExceptionEnum codeErreur;

    public AirBrassException(ExceptionEnum codeErreur, String message) {
        super(message);
        this.codeErreur = codeErreur;
    }

    public ExceptionEnum getCodeErreur() {
        return codeErreur;
    }
}
