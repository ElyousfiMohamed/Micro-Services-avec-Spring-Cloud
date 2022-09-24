package ma.enset.bankaccountservice.Controller;

import lombok.AllArgsConstructor;
import ma.enset.bankaccountservice.Dto.BankAccountDto;
import ma.enset.bankaccountservice.Dto.Mapper.BankAccountMapper;
import ma.enset.bankaccountservice.Exception.BankAccountNotFoundException;
import ma.enset.bankaccountservice.Service.BankAccountService;
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
    public BankAccountDto saveBankAccount(@RequestBody BankAccountDto bankAccountDto) throws BankAccountNotFoundException {
        return bankAccountService.saveBankAccount(bankAccountDto.getCreatedAt(),bankAccountDto.getBalance(),bankAccountDto.getCurrency(),bankAccountDto.getType());
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccountDto updateBankAccount(@RequestBody BankAccountDto bankAccountDto,
                                            @PathVariable String id) throws BankAccountNotFoundException {
        return bankAccountService.updateBankAccount(bankAccountDto,id);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteBankAccount(@PathVariable String id) {
        bankAccountService.deleteBankAccount(id);
    }


}
