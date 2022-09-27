package ma.enset.bankaccountservice.Controller;

import ma.enset.bankaccountservice.Dto.BankAccountDto;
import ma.enset.bankaccountservice.Dto.BankAccountDto2;
import ma.enset.bankaccountservice.Exception.BankAccountNotFoundException;
import ma.enset.bankaccountservice.Model.BankAccount;
import ma.enset.bankaccountservice.Repository.BankAccountRepository;
import ma.enset.bankaccountservice.Service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountControllerGraphQL {
    @Autowired
    BankAccountService bankAccountService;

    @QueryMapping
    public List<BankAccountDto> getAllAccounts(){
        return bankAccountService.getBankAccounts();
    }

    @QueryMapping
    public BankAccountDto getAccountById(@Argument String id) throws BankAccountNotFoundException {
        return bankAccountService.getBankAccount(id);
    }

    @MutationMapping
    public BankAccount createAccount(@Argument BankAccountDto2 bankAccountDto) throws BankAccountNotFoundException {
        return bankAccountService.saveBankAccount(bankAccountDto.getBalance(),bankAccountDto.getCurrency(),bankAccountDto.getType());
    }

    @MutationMapping
    public BankAccountDto updateAccount(@Argument BankAccountDto2 bankAccount, @Argument String id) throws BankAccountNotFoundException {
        return bankAccountService.updateBankAccount(bankAccount,id);
    }

    @MutationMapping
    public void deleteAccount(@Argument String id) {
        bankAccountService.deleteBankAccount(id);
    }

}
