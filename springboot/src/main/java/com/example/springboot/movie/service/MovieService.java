package com.example.springboot.movie.service;

import com.example.springboot.movie.model.Movie;
import com.example.springboot.movie.model.MovieDto;
import com.example.springboot.movie.model.Review;
import com.example.springboot.movie.model.ReviewDto;
import com.example.springboot.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public void create(MovieDto movieDto) {

        movieRepository.save(Movie.builder()
                .name(movieDto.getName())
                .price(movieDto.getPrice())
                .build());
    }

    public List<MovieDto> list() {
        List<MovieDto> movieDtos = new ArrayList<>();

        for (Movie movie : movieRepository.findAll()) {

            List<ReviewDto> reviewDtos = new ArrayList<>();

            for (Review review : movie.getReviews()) {
                reviewDtos.add(ReviewDto.builder()
                                .id(review.getReviewId())
                                .star(review.getStar())
                                .text(review.getText())
                                .build());
            }

            movieDtos.add(MovieDto.builder()
                    .id(movie.getId())
                    .name(movie.getName())
                    .price(movie.getPrice())
                    .reviews(reviewDtos)
                    .build());
        }

        return movieDtos;
    }

    public MovieDto read(Integer id) {
        Optional<Movie> result = movieRepository.findById(id);
        if (result.isPresent()) {
            Movie movie = result.get();

            List<ReviewDto> reviewDtos = new ArrayList<>();

            for (Review review : movie.getReviews()) {
                reviewDtos.add(ReviewDto.builder()
                        .id(review.getReviewId())
                        .star(review.getStar())
                        .text(review.getText())
                        .build()
                );
            }

            return MovieDto.builder()
                    .id(movie.getId())
                    .price(movie.getPrice())
                    .name(movie.getName())
                    .reviews(reviewDtos)
                    .build();
        } else {
            return null;
        }
    }

    public void update(MovieDto movieDto) {
        movieRepository.save(Movie.builder()
                .id(movieDto.getId())
                .name(movieDto.getName())
                .price(movieDto.getPrice())
                .build());
    }

    public void delete(Integer id) {
        movieRepository.delete(Movie.builder().id(id).build());
    }
}
