package com.shirostrat.Mycontroller.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private  int id;
    private String username;
    private String jobs;
    private String phone;
    
}
