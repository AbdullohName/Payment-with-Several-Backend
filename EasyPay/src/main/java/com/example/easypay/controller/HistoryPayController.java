package com.example.easypay.controller;

import com.example.easypay.dto.HistoryPayDto;
import com.example.easypay.dto.ResponseDto;
import com.example.easypay.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/history")
@RequiredArgsConstructor
public class HistoryPayController {
    private final HistoryService service;

    @GetMapping
    public ResponseDto<List<HistoryPayDto>> getAllByUserId() {
        return service.getAllByUserId();
    }
}
