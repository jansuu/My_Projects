package com.hotelbooking.cozyheaven.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.Discount;
import com.hotelbooking.cozyheaven.model.Hotel;
import com.hotelbooking.cozyheaven.model.Season;
import com.hotelbooking.cozyheaven.service.DiscountService;
import com.hotelbooking.cozyheaven.service.HotelService;
import com.hotelbooking.cozyheaven.service.SeasonService;

@RestController
@RequestMapping("/api/discount")
public class DiscountController {
	@Autowired
	private DiscountService discountService;
	@Autowired
	private SeasonService seasonService;
	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/add/{hid}/{sid}")
	public Discount addDiscount(@PathVariable int hid
								,@PathVariable int sid
								,@RequestBody Discount discount) throws InvalidIDException
	{
		Season season = seasonService.getSeasonById(sid);
		discount.setSeason(season);
		Hotel hotel = hotelService.findByHotelID(hid);
		discount.setHotel(hotel);
		return discountService.addDiscount(discount);
	}
	
	//Getting  the discounts by hotelId
	@GetMapping("/get-discount-hotel/{hid}")
	public List<Discount> getDiscountByHotelId(@PathVariable int hid)
	{
		return discountService.getDisountByHotelId(hid);
	}
	
	@GetMapping("/get-discount-season/{sid}")
	public List<Discount> getDiscountBySeasonId(@PathVariable int sid)
	{
		return discountService.getDisountBySeasonId(sid);
	}
	
	@GetMapping("/get-all-discounts")
	public List<Discount> getAllDiscount()
	{
		return discountService.getAllDiscount();
	}
	
	//find hotel by discount(id,name)
	@GetMapping("/gethotelname/{discountname}")
	public List<String> getHotelByDiscountName(@PathVariable String discountname)
	{
		return discountService.getHotelByDiscountName(discountname);
	}
	
	

}
