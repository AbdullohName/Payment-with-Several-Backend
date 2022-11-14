package com.example.easypay.service.mapper;

import com.example.easypay.dto.HistoryPayDto;
import com.example.easypay.entity.HistoryPay;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HistoryPayMapper {
    HistoryPayDto toDto(HistoryPay history);
    HistoryPay toEntity(HistoryPayDto historyDto);
}
