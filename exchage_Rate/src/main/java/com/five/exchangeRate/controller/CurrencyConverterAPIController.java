package com.five.exchangeRate.controller;

import com.five.exchangeRate.dto.ConverInfoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.five.exchangeRate.service.CurrencyConverterService;

import java.text.DecimalFormat;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class CurrencyConverterAPIController {
    private final CurrencyConverterService currencyConverter;
    private final DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

    //국가에 따른 환율을 가져오는 메소드
    @GetMapping("/exchange-rates")
    public ResponseEntity getExchangeRate(@RequestParam(name = "receiveCountry") String receiveCountry){
        System.out.println("@@@ : " + receiveCountry);
        Double exchangeRate = currencyConverter.getCurrencyRate(receiveCountry);
        return new ResponseEntity(format(exchangeRate), HttpStatus.OK);
    }

    //송금액을 가져오는 메소드
    @PostMapping("/exchange-rates")
    public ResponseEntity getSendAmount(@RequestBody ConverInfoDTO convertInfo){

        Double currency = currencyConverter.getCurrencyRate(convertInfo.getReceiveCountry());
        System.out.println("@@ : " + currency);
        Double sendAmount = (currency * convertInfo.getSendAmount());
        String formatSendAmount = format(sendAmount);

        return new ResponseEntity(formatSendAmount, HttpStatus.OK);
    }

    public String format(Number number){
        return decimalFormat.format(number);
    }
}
