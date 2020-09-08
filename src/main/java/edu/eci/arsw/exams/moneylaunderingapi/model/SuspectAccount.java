package edu.eci.arsw.exams.moneylaunderingapi.model;

/**
 * The type Suspect account.
 */
public class SuspectAccount {
    /**
     * The Account id.
     */
    public String accountId;
    /**
     * The Amount of small transactions.
     */
    public int amountOfSmallTransactions;

    /**
     * Instantiates a new Suspect account.
     *
     * @param accountId                 the account id
     * @param amountOfSmallTransactions the amount of small transactions
     */
    public SuspectAccount(String accountId,int amountOfSmallTransactions){
        this.accountId = accountId;
        this.amountOfSmallTransactions = amountOfSmallTransactions;
    }

    /**
     * Gets account id.
     *
     * @return the account id
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Sets account id.
     *
     * @param accountId the account id
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * Gets amount of small transactions.
     *
     * @return the amount of small transactions
     */
    public int getAmountOfSmallTransactions() {
        return amountOfSmallTransactions;
    }

    /**
     * Sets amount of small transactions.
     *
     * @param amountOfSmallTransactions the amount of small transactions
     */
    public void setAmountOfSmallTransactions(int amountOfSmallTransactions) {
        this.amountOfSmallTransactions = amountOfSmallTransactions;
    }
}
