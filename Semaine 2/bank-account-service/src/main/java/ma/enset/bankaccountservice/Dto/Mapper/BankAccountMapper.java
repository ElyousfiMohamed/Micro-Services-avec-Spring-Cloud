package ma.enset.bankaccountservice.Dto.Mapper;

import lombok.AllArgsConstructor;
import ma.enset.bankaccountservice.Dto.BankAccountDto;
import ma.enset.bankaccountservice.Dto.BankAccountDto2;
import ma.enset.bankaccountservice.Dto.CustomerDto;
import ma.enset.bankaccountservice.Model.BankAccount;
import ma.enset.bankaccountservice.Model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class BankAccountMapper {
    public BankAccountDto toDto(BankAccount bankAccount) {
        return BankAccountDto.builder()
                .id(bankAccount.getId())
                .type(bankAccount.getType())
                .balance(bankAccount.getBalance())
                .currency(bankAccount.getCurrency())
                .createdAt(bankAccount.getCreatedAt())
                .build();
    }

    public BankAccount toEntity(BankAccountDto bankAccountDto) {
        return BankAccount.builder()
                .id(bankAccountDto.getId())
                .type(bankAccountDto.getType())
                .balance(bankAccountDto.getBalance())
                .currency(bankAccountDto.getCurrency())
                .createdAt(bankAccountDto.getCreatedAt())
                .build();
    }

    public List<BankAccountDto> toDtoList(List<BankAccount> bankAccounts){
        return bankAccounts.stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<BankAccount> toEntityList(List<BankAccountDto> bankAccountDtos){
        return bankAccountDtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public BankAccountDto2 toDto2(BankAccount bankAccount) {
        return BankAccountDto2.builder()
                .balance(bankAccount.getBalance())
                .currency(bankAccount.getCurrency())
                .type(bankAccount.getType())
                .build();
    }

    public BankAccount toEntity2(BankAccountDto2 bankAccountDto2) {
        return BankAccount.builder()
                .balance(bankAccountDto2.getBalance())
                .currency(bankAccountDto2.getCurrency())
                .type(bankAccountDto2.getType())
                .build();
    }

    public List<BankAccountDto2> toDtoList2(List<BankAccount> bankAccounts){
        return bankAccounts.stream().map(this::toDto2).collect(Collectors.toList());
    }

    public List<BankAccount> toEntityList2(List<BankAccountDto2> bankAccountDtos){
        return bankAccountDtos.stream().map(this::toEntity2).collect(Collectors.toList());
    }

    public CustomerDto toDto(Customer customer) {
        return CustomerDto.builder()
                .name(customer.getName())
                .build();
    }

    public Customer toEntity(CustomerDto customerDto) {
        return Customer.builder()
                .name(customerDto.getName())
                .build();
    }

    public List<CustomerDto> toDtoList3(List<Customer> customers){
        return customers.stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<Customer> toEntityList3(List<CustomerDto> customerDtos){
        return customerDtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

}
