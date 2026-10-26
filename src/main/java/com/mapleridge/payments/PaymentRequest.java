package com.mapleridge.payments;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public record PaymentRequest(
        @NotBlank String debtorAccount,
        @NotBlank String creditorAccount,
        @Positive BigDecimal amount,
        @NotBlank String currency,
        String remittanceInfo) {
}
