package ma.enset.bankaccountservice.Dto.Mapper;

import lombok.AllArgsConstructor;
import ma.enset.bankaccountservice.Dto.BankAccountDto;
import ma.enset.bankaccountservice.Model.BankAccount;
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
}
