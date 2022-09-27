package ma.enset.bankaccountservice.Service;

import lombok.AllArgsConstructor;
import ma.enset.bankaccountservice.Dto.BankAccountDto;
import ma.enset.bankaccountservice.Dto.BankAccountDto2;
import ma.enset.bankaccountservice.Dto.Mapper.BankAccountMapper;
import ma.enset.bankaccountservice.Exception.BankAccountNotFoundException;
import ma.enset.bankaccountservice.Model.AccountType;
import ma.enset.bankaccountservice.Model.BankAccount;
import ma.enset.bankaccountservice.Repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BankAccountImpl implements BankAccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private BankAccountMapper bankAccountMapper;

    @Override
    public BankAccount saveBankAccount(Double solde, String currency, AccountType accountType){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setId(UUID.randomUUID().toString());
        LocalDateTime ldt = LocalDateTime.now();
        Date out = java.sql.Timestamp.valueOf(ldt);
        bankAccount.setCreatedAt(out);
        bankAccount.setBalance(solde);
        bankAccount.setCurrency(currency);
        bankAccount.setType(accountType);
        return bankAccountRepository.save(bankAccount);
    }

    @Override
    public BankAccountDto getBankAccount(String bankAccountId) throws BankAccountNotFoundException {
        BankAccount bankAccount = bankAccountRepository.findById(bankAccountId).orElseThrow(() -> new BankAccountNotFoundException("BankAccount not found"));
        return bankAccountMapper.toDto(bankAccount);
    }

    @Override
    public List<BankAccountDto> getBankAccounts() {
        return bankAccountMapper.toDtoList(bankAccountRepository.findAll());
    }

    @Override
    public void deleteBankAccount(String id) {
        bankAccountRepository.deleteById(id);
    }

    @Override
    public BankAccountDto updateBankAccount(BankAccountDto2 bankAccountDto, String id) {
        BankAccount bankAccount = bankAccountMapper.toEntity2(bankAccountDto);
        bankAccount.setId(id);
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        return bankAccountMapper.toDto(savedBankAccount);
    }
}
