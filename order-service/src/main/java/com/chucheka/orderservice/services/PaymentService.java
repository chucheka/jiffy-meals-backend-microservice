package com.chucheka.orderservice.services;

import com.chucheka.orderservice.dto.CreditDebitWalletDto;
import com.chucheka.orderservice.dto.GenericResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.ResponseEntity;

public interface PaymentService {

    String CREDIT_DEBIT_WALLET = "paymentserv/api/v1/wallets/debit-wallet";

    ResponseEntity<GenericResponse> makePayment(CreditDebitWalletDto creditDebitWalletDto);

}
