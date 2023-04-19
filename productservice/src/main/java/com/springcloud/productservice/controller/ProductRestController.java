package com.springcloud.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import com.springcloud.productservice.entity.Coupon;
import com.springcloud.productservice.entity.Product;
import com.springcloud.productservice.repository.ProductRepo;
import com.springcloud.productservice.restclients.CouponClient;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/productapi")
@RefreshScope
public class ProductRestController {
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private CouponClient couponClient;

	@Value("${com.praneetha.springcloud.property}")
	private String customProperty;

	@GetMapping("/customProperty")
	String getProperty()
	{
		return this.customProperty;
	}
	@RequestMapping(value="/products",method=RequestMethod.POST)
	@Retry(name="product-api",fallbackMethod = "handleError")
	 public Product create(@RequestBody Product product) {
		Coupon coupon=couponClient.getCoupon(product.getCouponCode());
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return productRepo.save(product);
	}
	public Product handleError(Product product, Exception exception)
	{
		System.out.println("Inside Handle Error");
		return product;
	}
}
