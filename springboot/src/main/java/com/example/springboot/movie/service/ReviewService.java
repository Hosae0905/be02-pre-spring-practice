package com.example.springboot.movie.service;


import com.example.springboot.movie.model.Movie;
import com.example.springboot.movie.model.MovieDto;
import com.example.springboot.movie.model.Review;
import com.example.springboot.movie.model.ReviewDto;
import com.example.springboot.movie.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public List<ReviewDto> getReviewList() {
        List<ReviewDto> reviewDtos = new ArrayList<>();

        for (Review review : reviewRepository.findAll()) {

            MovieDto movieDto = MovieDto.builder()
                    .id(review.getMovie().getId())
                    .name(review.getMovie().getName())
                    .price(review.getMovie().getPrice())
                    .build();


            reviewDtos.add(ReviewDto.builder()
                            .id(review.getReviewId())
                            .star(review.getStar())
                            .text(review.getText())
                            .movieDto(movieDto)
                            .build());
        }

        return reviewDtos;
    }

    public ReviewDto readReview(Integer id) {
        Optional<Review> review = reviewRepository.findById(id);
        if (review.isPresent()) {
            return ReviewDto.builder()
                    .id(review.get().getReviewId())
                    .star(review.get().getStar())
                    .text(review.get().getText())
                    .movieDto(MovieDto.builder()
                            .id(review.get().getMovie().getId())
                            .name(review.get().getMovie().getName())
                            .price(review.get().getMovie().getPrice())
                            .build())
                    .build();
        } else {
            return null;
        }
    }

    public void writeReview(Integer movieId, ReviewDto reviewDto) {
        reviewRepository.save(Review.builder()
                .movie(Movie.builder().id(movieId).build())
                .star(reviewDto.getStar())
                .text(reviewDto.getText())
                .build());

    }

    public void updateReview(ReviewDto reviewDto) {
        reviewRepository.save(Review.builder()
                .reviewId(reviewDto.getId())
                .text(reviewDto.getText())
                .star(reviewDto.getStar())
                .build());
    }

    public void deleteReview(Integer id) {
        reviewRepository.delete(Review.builder().reviewId(id).build());
    }
}
