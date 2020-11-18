package com.utte.controller;

import com.utte.beans.Review;
import com.utte.dao.ReviewDAO;

public class ReviewService {
	ReviewDAO dao = new ReviewDAO();
	
	public void reviewInsert(Review review) {
		dao.insertReview(review);
	}

}
