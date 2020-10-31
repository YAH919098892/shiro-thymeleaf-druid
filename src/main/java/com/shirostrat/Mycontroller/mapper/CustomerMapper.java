package com.shirostrat.Mycontroller.mapper;

import com.shirostrat.Mycontroller.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Mapper
@Service
public interface CustomerMapper {
    List<Customer> queryAll();
    int addCus(Map map);
    Customer queryById(int id);
Customer queryByName(String username);

}
