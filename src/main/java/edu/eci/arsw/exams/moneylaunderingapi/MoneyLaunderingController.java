package edu.eci.arsw.exams.moneylaunderingapi;


import edu.eci.arsw.exams.moneylaunderingapi.model.SuspectAccount;
import edu.eci.arsw.exams.moneylaunderingapi.service.MoneyLaunderingException;
import edu.eci.arsw.exams.moneylaunderingapi.service.MoneyLaunderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Money laundering controller.
 */
@RestController("/")
public class MoneyLaunderingController
{
    /**
     * The Money laundering service.
     */
    @Autowired
    MoneyLaunderingService moneyLaunderingService;

    /**
     * Offending accounts response entity.
     *
     * @return the response entity
     */
    @RequestMapping( value = "/fraud-bank-accounts",method = RequestMethod.GET)
    public ResponseEntity<?> offendingAccounts() {
        try{
            List<SuspectAccount> data = moneyLaunderingService.getSuspectAccounts();
            return new ResponseEntity<>(data, HttpStatus.OK);
        }catch (MoneyLaunderingException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Add offending account response entity.
     *
     * @param suspectAccount the suspect account
     * @return the response entity
     */
    @RequestMapping( value = "/fraud-bank-accounts",method = RequestMethod.POST)
    public ResponseEntity<?> addOffendingAccount(@RequestBody SuspectAccount suspectAccount) {
        try{
            moneyLaunderingService.addSuspectAccount(suspectAccount);
            return new ResponseEntity<>(suspectAccount, HttpStatus.CREATED);
        }catch (MoneyLaunderingException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.FORBIDDEN);
        }
    }

    /**
     * Gets offending accounts by id.
     *
     * @param accountId the account id
     * @return the offending accounts by id
     */
    @RequestMapping( value = "/fraud-bank-account/{accountId}",method = RequestMethod.GET)
    public ResponseEntity<?> getOffendingAccountsById(@PathVariable String accountId) {
        try{
            SuspectAccount data = moneyLaunderingService.getAccountStatus(accountId);
            return new ResponseEntity<>(data, HttpStatus.OK);
        }catch (MoneyLaunderingException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Update offending accounts by id response entity.
     *
     * @param accountId      the account id
     * @param suspectAccount the suspect account
     * @return the response entity
     */
    @RequestMapping( value = "/fraud-bank-account/{accountId}",method = RequestMethod.PUT)
    public ResponseEntity<?> updateOffendingAccountsById(@PathVariable String accountId, @RequestBody SuspectAccount suspectAccount) {
        try{
            moneyLaunderingService.updateAccountStatus(accountId,suspectAccount);
            return new ResponseEntity<>(suspectAccount, HttpStatus.ACCEPTED);
        }catch (MoneyLaunderingException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.FORBIDDEN);
        }
    }

}
