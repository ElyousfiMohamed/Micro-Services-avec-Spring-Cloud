package ma.enset.bankaccountservice;

import ma.enset.bankaccountservice.Dto.BankAccountDto;
import ma.enset.bankaccountservice.Dto.Mapper.BankAccountMapper;
import ma.enset.bankaccountservice.Exception.BankAccountNotFoundException;
import ma.enset.bankaccountservice.Model.AccountType;
import ma.enset.bankaccountservice.Model.BankAccount;
import ma.enset.bankaccountservice.Repository.BankAccountRepository;
import ma.enset.bankaccountservice.Service.BankAccountService;
import ma.enset.bankaccountservice.Service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BankAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountService bankAccountService,
                            CustomerService customerService,
                            BankAccountMapper bankAccountMapper,
                            BankAccountRepository bankAccountRepository) {
        return args -> {
            customerService.saveCustomer("Mohamed");
            customerService.saveCustomer("Ahmed");
            customerService.saveCustomer("Ali");
            customerService.saveCustomer("Youssef");
            customerService.getCustomers().stream().forEach(c -> {
                for (int i = 0; i < 10; i++) {
                    BankAccount bankAccount = bankAccountService.saveBankAccount(Math.random() * 10000, "MAD", Math.random() > 0.5 ? AccountType.CURRENT : AccountType.SAVINGS);
                    bankAccount.setCustomerId(c);
                    bankAccountRepository.save(bankAccount);
                }
            });
        };
    }
}
