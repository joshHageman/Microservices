package com.hagemanservices.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/fraud-check")
@Slf4j
public class FraudController {
    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
        boolean isFraud = fraudCheckService.isFraudulent(customerId);
        log.info("Fraud check for customer {}", customerId);
        return new FraudCheckResponse(isFraud);
    }
}
