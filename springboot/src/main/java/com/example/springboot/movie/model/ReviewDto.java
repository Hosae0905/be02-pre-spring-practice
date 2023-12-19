package com.example.springboot.movie.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ReviewDto {
    private Integer id;
    private Integer star;
    private String text;
    private MovieDto movieDto;
}
