package com.example.easypay.service.Impl;

import com.example.easypay.dto.HistoryPayDto;
import com.example.easypay.dto.ResponseDto;
import com.example.easypay.dto.UserInfoDto;
import com.example.easypay.entity.HistoryPay;
import com.example.easypay.repository.HistoryRepository;
import com.example.easypay.service.HistoryService;
import com.example.easypay.service.mapper.HistoryPayMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service @RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {
    private final HistoryRepository repository;
    private final HistoryPayMapper mapper;

    @Override
    public ResponseDto<List<HistoryPayDto>> getAllByUserId() {
        UserInfoDto userInfoDto = (UserInfoDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            List<HistoryPay> historyPays = repository.getHistoryPayById(userInfoDto.getId());
            List<HistoryPayDto> historyPayDtos = historyPays.stream().map(mapper::toDto).collect(Collectors.toList());
            return ResponseDto.<List<HistoryPayDto>>builder()
                    .code(0)
                    .message("Ok")
                    .success(true)
                    .data(historyPayDtos)
                    .build();
        } catch (Exception e) {
            return ResponseDto.<List<HistoryPayDto>>builder()
                    .code(-1)
                    .message("Failed")
                    .success(false)
                    .build();
        }
    }
}
