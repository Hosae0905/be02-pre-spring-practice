package com.example.springboot.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoardReq {
    private int boardId;
    private String boardName;
    private String info;
    private String image;
}
