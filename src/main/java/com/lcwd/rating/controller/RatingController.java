package com.lcwd.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.rating.entity.Rating;
import com.lcwd.rating.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping()
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		Rating r = ratingService.createrating(rating);
		return new ResponseEntity<>(r,HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<Rating>> getAllRating(){
		List<Rating> r1 = ratingService.getAllRating();
		return new ResponseEntity<>(r1,HttpStatus.OK);
	}
	
	@GetMapping("/{ratingId}")
	public ResponseEntity<Rating> getRatingById(@PathVariable String ratingId ){
		 
		return new ResponseEntity<>(ratingService.getRatingById(ratingId),HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId ){
		List<Rating> r2 = ratingService.getAllRatingByUserId(userId);

		return new ResponseEntity<>(r2,HttpStatus.OK);
	}
	
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId ){
		List<Rating> r3 = ratingService.getAllRatingByHotelId(hotelId);
		return new ResponseEntity<>(r3,HttpStatus.OK);
	}
	
}
