package fr.afcepf.al30.airbrass.exceptions;

/**
 * Les erreurs généré par le DAO.
 */
public class DaoException extends AirBrassException {

    public DaoException(ExceptionEnum codeErreur, String message) {
        super(codeErreur, message);
    }
}