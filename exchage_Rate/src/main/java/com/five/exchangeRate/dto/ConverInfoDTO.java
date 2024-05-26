package com.five.exchangeRate.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConverInfoDTO {
    private String receiveCountry;
    private double sendAmount;
}
