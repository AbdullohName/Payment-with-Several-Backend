package com.example.easypay.service;

import com.example.easypay.dto.HistoryPayDto;
import com.example.easypay.dto.ResponseDto;

import java.util.List;

public interface HistoryService {
    ResponseDto<List<HistoryPayDto>> getAllByUserId();
}
