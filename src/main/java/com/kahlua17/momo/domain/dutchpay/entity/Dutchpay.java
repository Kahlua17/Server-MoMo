package com.kahlua17.momo.domain.dutchpay.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@RequiredArgsConstructor
@Document(collection = "dutchpay")
public class Dutchpay {
    @Id
    private String id;
    private final String moimId;
    private final String creator;
    private final String payer;
    private final List<String> members;
    private final int amount;

}