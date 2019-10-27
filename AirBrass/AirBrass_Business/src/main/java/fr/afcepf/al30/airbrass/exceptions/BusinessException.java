package fr.afcepf.al30.airbrass.exceptions;

/**
 * Les erreurs généré par le business.
 */
public class BusinessException extends AirBrassException {

    public BusinessException(ExceptionEnum codeErreur, String message) {
        super(codeErreur, message);
    }
}
