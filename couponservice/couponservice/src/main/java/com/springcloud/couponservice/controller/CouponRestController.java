package com.springcloud.couponservice.controller;

import com.springcloud.couponservice.entity.Coupon;
import com.springcloud.couponservice.repo.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {
	@Autowired
	CouponRepo couponRepo;
	
	@RequestMapping(value="/coupons",method=RequestMethod.POST)
	public Coupon create(@RequestBody Coupon coupon)
	{
		return couponRepo.save(coupon);
	}
   
	@RequestMapping(value="/coupon/{code}", method=RequestMethod.GET)
	public Coupon getCoupon(@PathVariable("code") String code) {
		System.out.println("server2");
		return couponRepo.findByCode(code);
	}
}
