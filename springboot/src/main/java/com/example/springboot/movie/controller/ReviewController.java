package com.example.springboot.movie.controller;

import com.example.springboot.movie.model.Review;
import com.example.springboot.movie.model.ReviewDto;
import com.example.springboot.movie.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;


    @RequestMapping(method = RequestMethod.GET, value = "/reviewList")
    public ResponseEntity<Object> reviewList() {
        List<ReviewDto> reviewList = reviewService.getReviewList();
        return ResponseEntity.ok().body(reviewList);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/read")
    public ResponseEntity<Object> read(Integer id) {
        ReviewDto review = reviewService.readReview(id);
        return ResponseEntity.ok().body(review);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/write")
    public ResponseEntity<Object> write(Integer movieId, ReviewDto reviewDto) {
        reviewService.writeReview(movieId, reviewDto);
        return ResponseEntity.ok().body("리뷰 작성 완료");
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity<Object> update(@RequestBody ReviewDto reviewDto) {
        reviewService.updateReview(reviewDto);
        return ResponseEntity.ok().body("리뷰 수정 완료");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public ResponseEntity<Object> delete(Integer id) {
        reviewService.deleteReview(id);
        return ResponseEntity.ok().body("리뷰 삭제 완료");
    }
}
