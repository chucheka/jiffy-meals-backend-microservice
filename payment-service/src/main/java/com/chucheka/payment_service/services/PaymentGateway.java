package com.chucheka.payment_service.services;

import com.chucheka.payment_service.dto.AccountDebitCreditRequest;
import com.chucheka.payment_service.dto.AccountDebitCreditResponse;
import com.chucheka.payment_service.dto.CreateWalletDto;
import com.chucheka.payment_service.dto.GenericResponse;
import com.chucheka.payment_service.exceptions.ServerErrorException;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.server.WebServerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentGateway implements IPaymentGateway {


    private final WebClient webClient;

    @Override
    @CircuitBreaker(name = "account_service", fallbackMethod = "buildFallbackPaymentResponse")
    @Bulkhead(name= "account_service",type = Bulkhead.Type.THREADPOOL, fallbackMethod= "buildFallbackPaymentResponse")
    @Retry(name = "account_service", fallbackMethod= "buildFallbackPaymentResponse")
    public ResponseEntity<AccountDebitCreditResponse> makePayment(AccountDebitCreditRequest request) {

        return webClient.post()
                .uri("/banka/transfer")
                .body(Mono.just(request), AccountDebitCreditRequest.class)
                .retrieve()
                .toEntity(AccountDebitCreditResponse.class)
                .onErrorMap(WebClientRequestException.class, ex -> {
                    throw new ServerErrorException("issuer inoperative");
                })
                .block();

    }

    private ResponseEntity<AccountDebitCreditResponse> buildFallbackPaymentResponse(AccountDebitCreditRequest request, Throwable t) {

        log.info(">>>>>>>THE FALLBACK METHOD REQUEST {}", request);

        AccountDebitCreditResponse response = new AccountDebitCreditResponse(HttpStatus.INTERNAL_SERVER_ERROR.name(),"circuit breaker error",null);

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
