package com.kahlua17.momo.domain.dutchpay.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DutchpayCreateRequest {
    private String creator;
    private String payer;
    private List<String> members;
    private int amount;

}