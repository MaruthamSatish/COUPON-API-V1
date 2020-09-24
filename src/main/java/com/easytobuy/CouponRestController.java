package com.easytobuy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CouponRestController {
	@Autowired
	private CouponRepository couponRepository;

	@RequestMapping(value = "/coupon/{couponCode}", method = RequestMethod.GET)
	public ResponseEntity<List<Coupon>> findByCouponCode(@PathVariable("couponCode") String couponCode) {
		List<Coupon> getCoupons = couponRepository.findByCouponCode(couponCode);
		if (getCoupons.isEmpty()) {
			System.out.println("Updated");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Coupon>>(getCoupons, HttpStatus.OK);
	}
	
	public ResponseEntity<Coupon> getByCouponCode() {
		return null;
		
	}
}
