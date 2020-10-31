package com.shirostrat.Mycontroller.MyController;

import com.shirostrat.Mycontroller.pojo.Customer;
import com.shirostrat.Mycontroller.service.CustomerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.security.Security;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    CustomerService customerService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        System.out.println("执行了---->授权：doGetAuthorizationInfo");
//拿到当前登录的对象
        Subject subject=SecurityUtils.getSubject();
//        从授权中拿值,n拿到customer对象
        Customer customer = (Customer) subject.getPrincipal();
        String username=customer.getUsername();
        //授予权限
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();

//        所有的用户都有这个user:add的权限(登录才有）
        if (username.equals("2")){
            info.addStringPermission("user:add");
        }


        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        System.out.println("执行了————>认证：doGetAuthenticationInfo");
//        用户名，密码 数据中取
//        String name ="root";
//        String password="123456";
        UsernamePasswordToken usernameToken = (UsernamePasswordToken) token;
        Customer customer=customerService.queryByName(usernameToken.getUsername());
        System.out.println(customer.toString());
        String name=customer.getUsername();
        String password=customer.getPhone();
        if (!usernameToken.getUsername().equals(name)){
            return null;//抛出异常：用户名不存在
        }
        Subject subject=SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setAttribute("result2",customer);
//        密码认证(存的值，密码，名称）
      return new SimpleAuthenticationInfo(customer,password,"");
    }
}
