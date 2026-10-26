package com.mapleridge.payments;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class PaymentRouter {

    private static final Logger log = LogManager.getLogger(PaymentRouter.class);

    public void route(String paymentId, PaymentRequest request) {
        String rail = request.amount().doubleValue() > 25_000 ? "LYNX" : "INTERAC";
        log.info("payment {} routed to {} (remittance: {})", paymentId, rail, request.remittanceInfo());
    }
}
