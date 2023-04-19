package com.springcloud.productservice.restclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springcloud.productservice.entity.Coupon;

@FeignClient("GATEWAY-SERVICE")
public interface CouponClient {
    @GetMapping("/couponapi/coupon/{code}")
    Coupon getCoupon(@PathVariable("code") String code);
}
