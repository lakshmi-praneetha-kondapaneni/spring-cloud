package com.springcloud.couponservice.repo;

import com.springcloud.couponservice.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepo extends JpaRepository<Coupon, Long> {

	Coupon findByCode(String code);
}
