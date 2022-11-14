package com.example.easypay.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
//Malumotlarni ResponseDto ga orab qaytarish
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class ResponseDto<T> {
    private Integer code;
    private String message;
    private Boolean success;
    private T data;
}
