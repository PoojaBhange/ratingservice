package com.lcwd.rating.service;

import java.util.List;

import com.lcwd.rating.entity.Rating;

public interface RatingService {

	Rating createrating(Rating rating);
	
	List<Rating> getAllRating();
	
	Rating getRatingById(String ratingId);
	
	List<Rating> getAllRatingByUserId(String userId);

	List<Rating> getAllRatingByHotelId(String hotelId);

}
