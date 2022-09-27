package ma.enset.bankaccountservice.Service;

import ma.enset.bankaccountservice.Dto.BankAccountDto;
import ma.enset.bankaccountservice.Dto.BankAccountDto2;
import ma.enset.bankaccountservice.Exception.BankAccountNotFoundException;
import ma.enset.bankaccountservice.Model.AccountType;
import ma.enset.bankaccountservice.Model.BankAccount;

import java.util.Date;
import java.util.List;

public interface BankAccountService {
    BankAccount saveBankAccount(Double solde, String currency, AccountType accountType);
    BankAccountDto getBankAccount(String bankAccountId) throws BankAccountNotFoundException;
    List<BankAccountDto> getBankAccounts();
    void deleteBankAccount(String id);
    BankAccountDto updateBankAccount(BankAccountDto2 bankAccount, String id);
}
