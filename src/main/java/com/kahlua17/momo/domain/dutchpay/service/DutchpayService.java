package com.kahlua17.momo.domain.dutchpay.service;

import com.kahlua17.momo.domain.dutchpay.entity.Dutchpay;
import com.kahlua17.momo.domain.dutchpay.repository.DutchpayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DutchpayService {

    private final DutchpayRepository dutchpayRepository;

    @Autowired
    public DutchpayService(DutchpayRepository dutchpayRepository) {
        this.dutchpayRepository = dutchpayRepository;
    }

    public Dutchpay createDutchpay(String moimId, String creator, String payer, List<String> members, int amount) {
        Dutchpay dutchpay = new Dutchpay(moimId, creator, payer, members, amount);
        return dutchpayRepository.save(dutchpay);
    }
}
