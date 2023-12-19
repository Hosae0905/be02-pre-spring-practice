package com.example.springboot.movie.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@Builder
public class MovieDto {
    Integer id;

    String name;
    Integer price;

    List<ReviewDto> reviews = new ArrayList<>();
}
