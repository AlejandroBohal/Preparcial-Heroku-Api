package edu.eci.arsw.exams.moneylaunderingapi.service;

/**
 * The type Money laundering exception.
 */
public class MoneyLaunderingException extends Exception {
    /**
     * The constant CUENTA_REPETIDA.
     */
    public static final String CUENTA_REPETIDA = "Esta cuenta ya existe";
    /**
     * The constant NO_EXISTE_CUENTA.
     */
    public static final String NO_EXISTE_CUENTA = "Esta cuenta no existe";
    /**
     * The constant SIN_CUENTAS.
     */
    public static final String SIN_CUENTAS = "No hay cuentas";

    /**
     * Instantiates a new Money laundering exception.
     *
     * @param message the message
     */
    public MoneyLaunderingException(String message){
        super(message);
    }
}
