package ma.enset.bankaccountservice;

import ma.enset.bankaccountservice.Model.AccountType;
import ma.enset.bankaccountservice.Model.BankAccount;
import ma.enset.bankaccountservice.Service.BankAccountService;
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
	CommandLineRunner start(BankAccountService bankAccountService) {
		return args -> {
			for (int i = 0; i < 10; i++) {
				bankAccountService.saveBankAccount(
						new Date(),
						Math.random() * 10000,
						"USD",
						Math.random() < 0.5 ? AccountType.CURRENT : AccountType.SAVINGS
				);
			}
		};
	}
}
