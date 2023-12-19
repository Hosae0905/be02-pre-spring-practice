package com.example.springboot.movie.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewId;
    private Integer star;
    private String text;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

}
