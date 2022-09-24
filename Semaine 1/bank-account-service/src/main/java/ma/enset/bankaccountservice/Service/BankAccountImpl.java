package ma.enset.bankaccountservice.Service;

import lombok.AllArgsConstructor;
import ma.enset.bankaccountservice.Dto.BankAccountDto;
import ma.enset.bankaccountservice.Dto.Mapper.BankAccountMapper;
import ma.enset.bankaccountservice.Exception.BankAccountNotFoundException;
import ma.enset.bankaccountservice.Model.AccountType;
import ma.enset.bankaccountservice.Model.BankAccount;
import ma.enset.bankaccountservice.Repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public BankAccountDto saveBankAccount(Date date, Double solde, String currency, AccountType accountType) throws BankAccountNotFoundException {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(date);
        bankAccount.setBalance(solde);
        bankAccount.setCurrency(currency);
        bankAccount.setType(accountType);
        return bankAccountMapper.toDto(bankAccountRepository.save(bankAccount));
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
    public BankAccountDto updateBankAccount(BankAccountDto bankAccountDto, String id) {
        bankAccountDto.setId(id);
        BankAccount bankAccount = bankAccountMapper.toEntity(bankAccountDto);
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        return bankAccountMapper.toDto(savedBankAccount);
    }
}
