package com.example.springboot.movie.repository;

import com.example.springboot.movie.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
