package com.kahlua17.momo.domain.dutchpay.repository;

import com.kahlua17.momo.domain.dutchpay.entity.Dutchpay;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DutchpayRepository extends MongoRepository<Dutchpay, String> {
}