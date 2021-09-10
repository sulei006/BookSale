package com.su.booksale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping("/admin")
    public  String loginPage()
    {
        return "login";
    }

    //    登录方法
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, RedirectAttributes attributes)
    {

        if(username.equals("su")&&password.equals("123")){
            session.setAttribute("user",true);
            return  "redirect:/";
        }
        else{
            //这里不能用model，因为model的作用域是一次请求域，redirect是第二次请求，因此拿不到

            attributes.addFlashAttribute("message","用户名或密码错误");
            //这里用的是重定向，重新请求而不是用的转发，转发时一次请求，请求域中的内容不丢失
            //            这里等下测试一下
            return "redirect:/admin";
        }
    }
}
