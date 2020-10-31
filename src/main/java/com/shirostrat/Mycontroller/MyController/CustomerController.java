package com.shirostrat.Mycontroller.MyController;

import com.shirostrat.Mycontroller.pojo.Customer;
import com.shirostrat.Mycontroller.service.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerServiceImp customerServiceImp;
    @RequestMapping("/alll")
    public List<Customer> an(){
        List<Customer> customers = customerServiceImp.queryAll();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
        return customers;
    }
    @RequestMapping("/alll2")
    public Customer an2(){
        Customer customer1 = customerServiceImp.queryByName("2");
        System.out.println(customer1.toString());
        return customer1;
    }
}
