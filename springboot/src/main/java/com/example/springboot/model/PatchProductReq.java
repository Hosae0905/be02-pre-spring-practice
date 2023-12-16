package com.example.springboot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatchProductReq {
    private int productId;
    private String productInfo;
}
