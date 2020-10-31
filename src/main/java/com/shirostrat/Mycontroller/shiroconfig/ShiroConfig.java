package com.shirostrat.Mycontroller.shiroconfig;


import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.shirostrat.Mycontroller.MyController.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {



//3  shiroFilterFactoryBean3
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){

        ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
//        过滤器配置
        bean.setSecurityManager(defaultWebSecurityManager);
//        添加shiro的内置过滤器
        /*
        anon无需认证
        authc必须认证才能访问
        user必须拥有记住我功能才能使用
        perm是拥有某个资源的权限才能使用
        role 拥有某个角色才能使用
         */
        //拦截
        Map<String, String> filterChainDefinitionMap=new LinkedHashMap<>();
//        设置授权 访问/add 必须有user：add的权利
        filterChainDefinitionMap.put("/add","perms[user:add]");
        //        所有人都可访问
        // filterChainDefinitionMap.put("/add","anon");
//        未授权页面
        bean.setUnauthorizedUrl("/unauth");

//        要认证了才能访问（spring-security有自定义的login.html页面，而Shiro没有，需要我们自己配置）
        filterChainDefinitionMap.put("/updat","authc");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//        设置登录的请求
        bean.setLoginUrl("/tologin");

        return bean;
    }


//2    DefaultwebSecurityManager2
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        System.out.println(securityManager);
        return securityManager;
    }


// 1   realm
    @Bean(name = "userRealm")
    public UserRealm userRealm(){
        return new UserRealm();
    }

//整合thymelaef-shiro
    @Bean
    public ShiroDialect getShiroDialect(){
        return  new ShiroDialect();
    }


}
