package com.attrabit.ecom.service;

import com.attrabit.ecom.model.Reviews;
import com.attrabit.ecom.repository.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewsService {

    @Autowired
    private ReviewsRepository reviewsRepository;

    public List<Reviews> getAllReviews() {
        return reviewsRepository.findAll();
    }

    public Optional<Reviews> getReviewById(Integer id) {
        return reviewsRepository.findById(id);
    }

    public Reviews createReview(Reviews review) {
        review.setCreatedAt(LocalDateTime.now());
        review.setUpdatedAt(LocalDateTime.now());
        return reviewsRepository.save(review);
    }

    public Reviews updateReview(Integer id, Reviews review) {
        Optional<Reviews> existingReviewOptional = reviewsRepository.findById(id);
        if (existingReviewOptional.isPresent()) {
            Reviews existingReview = existingReviewOptional.get();
            existingReview.setReviewer(review.getReviewer());
            existingReview.setProduct(review.getProduct());
            existingReview.setRating(review.getRating());
            existingReview.setReviewerName(review.getReviewerName());
            existingReview.setComment(review.getComment());
            existingReview.setIsApproved(review.getIsApproved());
            existingReview.setUpdatedAt(LocalDateTime.now());
            return reviewsRepository.save(existingReview);
        }
        return null;
    }

    public boolean deleteReview(Integer id) {
        Optional<Reviews> reviewOptional = reviewsRepository.findById(id);
        if (reviewOptional.isPresent()) {
            reviewsRepository.delete(reviewOptional.get());
            return true;
        }
        return false;
    }
}
