package ma.enset.bankaccountservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.bankaccountservice.Model.AccountType;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountDto2 {
    private double balance;
    private String currency;
    private AccountType type;
    private CustomerDto customer;
}
