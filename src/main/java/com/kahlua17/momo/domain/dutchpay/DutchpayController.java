package com.kahlua17.momo.domain.dutchpay;

import com.kahlua17.momo.domain.dutchpay.dto.DutchpayCreateRequest;
import com.kahlua17.momo.domain.dutchpay.entity.Dutchpay;
import com.kahlua17.momo.domain.dutchpay.service.DutchpayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dutchpay")
public class DutchpayController {

    private final DutchpayService dutchpayService;

    @Autowired
    public DutchpayController(DutchpayService dutchpayService) {
        this.dutchpayService = dutchpayService;
    }

    @PostMapping("/paylog")
    public ResponseEntity<Dutchpay> createDutchpay(
            @RequestHeader("Moim-ID") String moimId,
            @RequestBody DutchpayCreateRequest request) {

        Dutchpay dutchpay = dutchpayService.createDutchpay(
                moimId,
                request.getCreator(),
                request.getPayer(),
                request.getMembers(),
                request.getAmount()
        );
        return new ResponseEntity<>(dutchpay, HttpStatus.CREATED);
    }
}
