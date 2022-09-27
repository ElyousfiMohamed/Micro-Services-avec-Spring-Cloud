package ma.enset.bankaccountservice.Service;

import ma.enset.bankaccountservice.Dto.BankAccountDto;
import ma.enset.bankaccountservice.Dto.CustomerDto;
import ma.enset.bankaccountservice.Dto.Mapper.BankAccountMapper;
import ma.enset.bankaccountservice.Exception.CustomerNotFoundException;
import ma.enset.bankaccountservice.Model.Customer;
import ma.enset.bankaccountservice.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    BankAccountMapper bankAccountMapper;

    @Override
    public Customer saveCustomer(String name) {
        Customer customer = new Customer();
        customer.setId(UUID.randomUUID().toString());
        customer.setName(name);
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomer(String id) throws CustomerNotFoundException {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customer, String id) {
        Customer customer1 = bankAccountMapper.toEntity(customer);
        customer1.setId(id);
        return bankAccountMapper.toDto(customerRepository.save(customer1));
    }

    @Override
    public void addBankAccountToCustomer(String customerId, BankAccountDto bankAccountDto) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
        customer.getAccounts().add(bankAccountMapper.toEntity(bankAccountDto));
        customerRepository.save(customer);
    }
}

