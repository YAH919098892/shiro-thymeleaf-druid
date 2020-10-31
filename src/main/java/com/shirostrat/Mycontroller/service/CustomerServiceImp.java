package com.shirostrat.Mycontroller.service;

import com.shirostrat.Mycontroller.mapper.CustomerMapper;
import com.shirostrat.Mycontroller.pojo.Customer;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Setter
public class CustomerServiceImp implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;
    @Override
    public List<Customer> queryAll() {
        return customerMapper.queryAll();
    }

    @Override
    public int addCus(Map map) {
        return customerMapper.addCus(map);
    }

    @Override
    public Customer queryById(int id) {
        return customerMapper.queryById(id);
    }

    @Override
    public Customer queryByName(String username) {
        return customerMapper.queryByName(username);
    }
}
