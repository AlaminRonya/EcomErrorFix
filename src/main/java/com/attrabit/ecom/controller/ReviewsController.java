package com.attrabit.ecom.controller;

import com.attrabit.ecom.model.Reviews;
import com.attrabit.ecom.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {

    @Autowired
    private ReviewsService reviewsService;

    @GetMapping
    public ResponseEntity<List<Reviews>> getAllReviews() {
        return ResponseEntity.ok(reviewsService.getAllReviews());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reviews> getReviewById(@PathVariable Integer id) {
        Optional<Reviews> reviewOptional = reviewsService.getReviewById(id);
        if (reviewOptional.isPresent()) {
            return ResponseEntity.ok(reviewOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Reviews> createReview(@RequestBody Reviews review) {
        Reviews createdReview = reviewsService.createReview(review);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReview);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reviews> updateReview(@PathVariable Integer id, @RequestBody Reviews review) {
        Reviews updatedReview = reviewsService.updateReview(id, review);
        if (updatedReview != null) {
            return ResponseEntity.ok(updatedReview);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Integer id) {
        boolean isDeleted = reviewsService.deleteReview(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
