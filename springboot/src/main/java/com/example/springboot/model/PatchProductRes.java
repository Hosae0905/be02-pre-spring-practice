package com.example.springboot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatchProductRes {
    private int productId;
    private String productName;
    private String productInfo;
    private String productImage;
}
