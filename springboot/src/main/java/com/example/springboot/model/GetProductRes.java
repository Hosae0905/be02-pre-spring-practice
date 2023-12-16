package com.example.springboot.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetProductRes {
    private int boardId;
    private String boardName;
    private String info;
    private String image;
}
