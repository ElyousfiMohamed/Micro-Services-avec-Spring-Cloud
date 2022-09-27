package ma.enset.bankaccountservice.Model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    @javax.persistence.Id
    private String Id;

    private String name;

    @OneToMany( mappedBy = "customerId")
    private List<BankAccount> accounts;

}