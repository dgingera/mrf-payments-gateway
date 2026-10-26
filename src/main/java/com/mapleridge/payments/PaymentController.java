package com.mapleridge.payments;

import jakarta.validation.Valid;
import java.util.Map;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/payments")
public class PaymentController {

    private static final Logger log = LogManager.getLogger(PaymentController.class);

    private final PaymentRouter router;

    public PaymentController(PaymentRouter router) {
        this.router = router;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> submit(
            @RequestHeader(value = "X-Merchant-Id") String merchantId,
            @RequestHeader(value = "User-Agent", required = false) String userAgent,
            @Valid @RequestBody PaymentRequest request) {
        String paymentId = UUID.randomUUID().toString();
        // Audit trail for the HSM appender: merchant and client identify the request
        log.info("payment {} received from merchant={} agent={} amount={} {}",
                paymentId, merchantId, userAgent, request.amount(), request.currency());
        router.route(paymentId, request);
        return ResponseEntity.accepted().body(Map.of("paymentId", paymentId, "status", "ACCEPTED"));
    }
}
