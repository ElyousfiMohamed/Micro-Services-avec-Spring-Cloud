package ma.enset.bankaccountservice.Controller;

import ma.enset.bankaccountservice.Dto.BankAccountDto;
import ma.enset.bankaccountservice.Dto.BankAccountDto2;
import ma.enset.bankaccountservice.Dto.CustomerDto;
import ma.enset.bankaccountservice.Dto.Mapper.BankAccountMapper;
import ma.enset.bankaccountservice.Exception.BankAccountNotFoundException;
import ma.enset.bankaccountservice.Exception.CustomerNotFoundException;
import ma.enset.bankaccountservice.Model.BankAccount;
import ma.enset.bankaccountservice.Model.Customer;
import ma.enset.bankaccountservice.Service.BankAccountService;
import ma.enset.bankaccountservice.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CustomerControllerGraphQL {
    @Autowired
    CustomerService service;
    @Autowired
    BankAccountMapper bankAccountMapper;

    @QueryMapping
    public List<Customer> getAllCustomers() {
        return service.getCustomers();
    }

    @QueryMapping
    public Customer getCustomerById(@Argument String id) throws CustomerNotFoundException {
        return service.getCustomer(id);
    }

    @MutationMapping
    public Customer createCustomer(@Argument String name) {
        return service.saveCustomer(name);
    }

    @MutationMapping
    public CustomerDto updateCustomer(@Argument CustomerDto customerDto, @Argument String id) throws BankAccountNotFoundException,
            CustomerNotFoundException {
        return service.updateCustomer(customerDto,id);
    }

    @MutationMapping
    public void deleteCustomer(@Argument String id) {
        service.deleteCustomer(id);
    }

}
