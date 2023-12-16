package com.example.springboot.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto {
    private int boardId;
    private String boardName;
    private String info;
    private String sellerName;
    private String image;
    private int categoryId;
}
