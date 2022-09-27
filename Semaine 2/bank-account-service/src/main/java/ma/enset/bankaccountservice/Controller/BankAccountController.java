package ma.enset.bankaccountservice.Controller;

import lombok.AllArgsConstructor;
import ma.enset.bankaccountservice.Dto.BankAccountDto;
import ma.enset.bankaccountservice.Dto.BankAccountDto2;
import ma.enset.bankaccountservice.Dto.Mapper.BankAccountMapper;
import ma.enset.bankaccountservice.Exception.BankAccountNotFoundException;
import ma.enset.bankaccountservice.Model.BankAccount;
import ma.enset.bankaccountservice.Service.BankAccountService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@AllArgsConstructor
@RequestMapping("/api")
public class BankAccountController {
    private BankAccountService bankAccountService;
    private BankAccountMapper bankAccountMapper;

    @GetMapping("/bankAccounts")
    public List<BankAccountDto> bankAccounts(){
        return bankAccountService.getBankAccounts();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccountDto bankAccount(@PathVariable String id) throws BankAccountNotFoundException {
        return bankAccountService.getBankAccount(id);
    }

    @PostMapping("/bankAccounts")
    public BankAccount saveBankAccount(@RequestBody BankAccountDto bankAccountDto) throws BankAccountNotFoundException {
        return bankAccountService.saveBankAccount(bankAccountDto.getBalance(),bankAccountDto.getCurrency(),bankAccountDto.getType());
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccountDto updateBankAccount(@RequestBody BankAccountDto2 bankAccountDto,
                                            @PathVariable String id) throws BankAccountNotFoundException {
        return bankAccountService.updateBankAccount(bankAccountDto,id);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteBankAccount(@PathVariable String id) {
        bankAccountService.deleteBankAccount(id);
    }
}
