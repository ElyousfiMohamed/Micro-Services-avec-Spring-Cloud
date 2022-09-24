package ma.enset.bankaccountservice.Service;

import ma.enset.bankaccountservice.Dto.BankAccountDto;
import ma.enset.bankaccountservice.Exception.BankAccountNotFoundException;
import ma.enset.bankaccountservice.Model.AccountType;
import ma.enset.bankaccountservice.Model.BankAccount;

import java.util.Date;
import java.util.List;

public interface BankAccountService {
    BankAccountDto saveBankAccount(Date date, Double solde, String currency, AccountType accountType) throws BankAccountNotFoundException;
    BankAccountDto getBankAccount(String bankAccountId) throws BankAccountNotFoundException;
    List<BankAccountDto> getBankAccounts();
    void deleteBankAccount(String id);
    BankAccountDto updateBankAccount(BankAccountDto bankAccountDto, String id) throws BankAccountNotFoundException;
}
