package edu.eci.arsw.exams.moneylaunderingapi.service;

import edu.eci.arsw.exams.moneylaunderingapi.model.SuspectAccount;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class MoneyLaunderingServiceStub implements MoneyLaunderingService {
    private CopyOnWriteArrayList<SuspectAccount> suspectAccounts;
    public MoneyLaunderingServiceStub(){
        suspectAccounts = new CopyOnWriteArrayList<SuspectAccount>();
        generateStub();
    }
    @Override
    public SuspectAccount updateAccountStatus(String accountId, SuspectAccount suspectAccount) throws MoneyLaunderingException {
        for (SuspectAccount sp: suspectAccounts){
            if(sp.getAccountId().equals(accountId)){
                int actualTransactions = sp.getAmountOfSmallTransactions();
                sp.setAmountOfSmallTransactions(actualTransactions + suspectAccount.getAmountOfSmallTransactions());
                return suspectAccount;
            }
        }throw new MoneyLaunderingException(MoneyLaunderingException.NO_EXISTE_CUENTA);
    }
    @Override
    public SuspectAccount getAccountStatus(String accountId) throws MoneyLaunderingException{
        for (SuspectAccount suspectAccount: suspectAccounts){
            if(suspectAccount.getAccountId().equals(accountId)){
                return suspectAccount;
            }
        }throw new MoneyLaunderingException(MoneyLaunderingException.NO_EXISTE_CUENTA);

    }
    @Override
    public List<SuspectAccount> getSuspectAccounts() throws MoneyLaunderingException {
        if (suspectAccounts != null){
            return suspectAccounts;
        }throw new MoneyLaunderingException(MoneyLaunderingException.SIN_CUENTAS);

    }

    @Override
    public SuspectAccount addSuspectAccount(SuspectAccount suspectAccount) throws MoneyLaunderingException {
        for(SuspectAccount sa:suspectAccounts){
            if (sa.getAccountId().equals(suspectAccount.getAccountId())){
                throw new MoneyLaunderingException(MoneyLaunderingException.CUENTA_REPETIDA);
            }
        }
        suspectAccounts.add(suspectAccount);
        return  suspectAccount;
    }

    private void generateStub(){
        for(int i=0; i<6;i++){
            SuspectAccount aux = new SuspectAccount("Account-abcd" + i,325);
            suspectAccounts.add(aux);
        }
    }
}
