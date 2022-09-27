package ma.enset.bankaccountservice.Service;

import ma.enset.bankaccountservice.Dto.BankAccountDto;
import ma.enset.bankaccountservice.Dto.BankAccountDto2;
import ma.enset.bankaccountservice.Dto.CustomerDto;
import ma.enset.bankaccountservice.Exception.BankAccountNotFoundException;
import ma.enset.bankaccountservice.Exception.CustomerNotFoundException;
import ma.enset.bankaccountservice.Model.AccountType;
import ma.enset.bankaccountservice.Model.Customer;

import java.util.List;
public interface CustomerService {
    Customer saveCustomer(String name);
    Customer getCustomer(String id) throws CustomerNotFoundException;
    List<Customer> getCustomers();
    void deleteCustomer(String id);
    CustomerDto updateCustomer(CustomerDto customer, String id);
    void addBankAccountToCustomer(String customerId, BankAccountDto bankAccountDto) throws CustomerNotFoundException;
}
