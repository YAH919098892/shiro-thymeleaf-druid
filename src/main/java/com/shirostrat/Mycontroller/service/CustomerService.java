package com.shirostrat.Mycontroller.service;

import com.shirostrat.Mycontroller.pojo.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public interface CustomerService {
    List<Customer> queryAll();
    int addCus(Map map);
    Customer queryById(int id);
    Customer queryByName(String username);

}
