package fr.afcepf.al30.airbrass.exceptions;

/**
 * Les exceptions créer par l'assembleur.
 */
public class AssembleurException extends AirBrassException {

    public AssembleurException(ExceptionEnum codeErreur, String message) {
        super(codeErreur, message);
    }
}
