package com.attrabit.ecom.dto.request;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public record RequestCouponsDTO(
        String code,
        BigDecimal value,
        Boolean isPercent,
        Boolean freeShipping,
        BigDecimal minimumSpend,
        BigDecimal maximumSpend,
        Integer usageLimitPerCoupon,
        Integer usageLimitPerCustomer,
        Boolean isActive,
        Date startDate,
        Date endDate
) {
    public RequestCouponsDTO {
    }
}
