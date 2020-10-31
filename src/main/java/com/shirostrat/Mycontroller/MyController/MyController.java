package com.shirostrat.Mycontroller.MyController;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MyController {
    @RequestMapping({"/","index"})
    public String an(Model model){
        model.addAttribute("msg","helloword");
        return "index";
    }
    @RequestMapping("/add")
    public String add(){
        return "add";
    }
    @RequestMapping("/updat")
    public String updat(){
        return "updat";
    }
    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }

    @RequestMapping("/unauth")
    public String noauth(){
        return "un";
    }


    @RequestMapping("/login")
    public String login(String username,String password,Model model){
        //获取当前的用户
        System.out.println(username+password);
        Subject subject= SecurityUtils.getSubject();
//       获取封装当前用户
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        token.setRememberMe(false);//设置记住我功能
//        捕获异常
        try {
            subject.login(token);
            return "index";
        } catch (UnknownAccountException uae) {
            model.addAttribute("msg2","用户名不存在");
            return "login";
        } catch (IncorrectCredentialsException ice) {
            model.addAttribute("msg2","密码不存在");
            return "login";
        }
    }

}
