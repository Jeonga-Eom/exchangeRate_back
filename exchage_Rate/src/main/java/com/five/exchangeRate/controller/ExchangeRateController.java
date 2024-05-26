package com.five.exchangeRate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExchangeRateController {
    @RequestMapping("/")
    public static String main(){
        return "index";
    }
}
