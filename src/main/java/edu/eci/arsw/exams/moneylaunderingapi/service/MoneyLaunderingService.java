package edu.eci.arsw.exams.moneylaunderingapi.service;

import edu.eci.arsw.exams.moneylaunderingapi.model.SuspectAccount;

import java.util.List;


/**
 * The interface Money laundering service.
 */
public interface MoneyLaunderingService {


    /**
     * Update account status suspect account.
     *
     * @param accountId      the account id
     * @param suspectAccount the suspect account
     * @return the suspect account
     * @throws MoneyLaunderingException the money laundering exception
     */
    SuspectAccount updateAccountStatus(String accountId, SuspectAccount suspectAccount) throws MoneyLaunderingException;

    /**
     * Gets account status.
     *
     * @param accountId the account id
     * @return the account status
     * @throws MoneyLaunderingException the money laundering exception
     */
    SuspectAccount getAccountStatus(String accountId) throws MoneyLaunderingException;

    /**
     * Gets suspect accounts.
     *
     * @return the suspect accounts
     * @throws MoneyLaunderingException the money laundering exception
     */
    List<SuspectAccount> getSuspectAccounts() throws MoneyLaunderingException;

    /**
     * Add suspect account suspect account.
     *
     * @param suspectAccount the suspect account
     * @return the suspect account
     * @throws MoneyLaunderingException the money laundering exception
     */
    SuspectAccount addSuspectAccount(SuspectAccount suspectAccount) throws MoneyLaunderingException;
}
