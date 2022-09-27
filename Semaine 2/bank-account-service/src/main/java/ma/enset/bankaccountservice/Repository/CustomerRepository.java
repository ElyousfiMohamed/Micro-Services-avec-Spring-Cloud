package ma.enset.bankaccountservice.Repository;

import ma.enset.bankaccountservice.Model.BankAccount;
import ma.enset.bankaccountservice.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer,String> {
}
