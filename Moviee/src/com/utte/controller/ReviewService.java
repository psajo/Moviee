package com.utte.controller;

import com.utte.beans.Review;
import com.utte.dao.ReviewDAO;

public class ReviewService {
	ReviewDAO dao = new ReviewDAO();
	
	public int reviewInsert(Review review) {
		int val = dao.insertReview(review);	
		return val;
	}
	
}
