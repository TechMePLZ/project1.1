package ru.friend.firstcrud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class StartController {

    @GetMapping
    public String index(){
        return "index/index";
    }

}
