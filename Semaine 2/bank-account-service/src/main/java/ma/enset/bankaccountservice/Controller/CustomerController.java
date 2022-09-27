package ma.enset.bankaccountservice.Controller;

import lombok.AllArgsConstructor;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@AllArgsConstructor
@RequestMapping("/api")
public class CustomerController {
    private CustomerService service;
    private BankAccountMapper bankAccountMapper;

    @GetMapping("/customers")
    public List<Customer> customers(){
        return service.getCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer customer(@PathVariable String id) throws CustomerNotFoundException {
        return service.getCustomer(id);
    }

    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody CustomerDto customerDto) throws CustomerNotFoundException {
        return service.saveCustomer(customerDto.getName());
    }

    @PutMapping("/customers/{id}")
    public CustomerDto updateCustomer(@RequestBody CustomerDto customerDto,
                                      @PathVariable String id) throws CustomerNotFoundException {
        return service.updateCustomer(customerDto,id);
    }


    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable String id) {
        service.deleteCustomer(id);
    }
}
