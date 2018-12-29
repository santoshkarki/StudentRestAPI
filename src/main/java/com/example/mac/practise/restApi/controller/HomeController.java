package com.example.mac.practise.restApi.controller;

import com.example.mac.practise.restApi.model.Greetings;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String helloWorld(){
        return "Hello World";
    }

    @RequestMapping(value="/greeting", method=RequestMethod.GET)
    public Greetings greeting(){
        return new Greetings(1L,"How are you");

    }

}
