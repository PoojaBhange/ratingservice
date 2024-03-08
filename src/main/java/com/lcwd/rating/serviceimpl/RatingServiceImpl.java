package com.lcwd.rating.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.rating.entity.Rating;
import com.lcwd.rating.exception.ResourceNotFoundException;
import com.lcwd.rating.repository.RatingRepository;
import com.lcwd.rating.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepo;
	
	
	@Override
	public Rating createrating(Rating rating) {
		String ratingId = UUID.randomUUID().toString();
		rating.setRatingId(ratingId);
		
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {
		return ratingRepo.findAll();
	}

	@Override
	public Rating getRatingById(String ratingId) {
		Rating rating = ratingRepo.findById(ratingId).orElseThrow(()-> new ResourceNotFoundException("resource not found on serve at runtime"));
		return rating;
	}

	@Override
	public List<Rating> getAllRatingByUserId(String userId) {
		List<Rating > rUser = ratingRepo.findByUserId(userId);
		return rUser;
	}

	@Override
	public List<Rating> getAllRatingByHotelId(String hotelId) {
		List<Rating > rHotel = ratingRepo.findByHotelId(hotelId);
		return rHotel;
	}

}
