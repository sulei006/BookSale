package com.su.booksale.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/{a}/{b}")
    Integer getSum(@PathVariable int a, @PathVariable int b)
    {
        Integer res=new Integer(a+b);
        return res;
    }
}
