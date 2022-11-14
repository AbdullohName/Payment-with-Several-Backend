package com.example.easypay.service.mapper;

import com.example.easypay.dto.CardDto;
import com.example.easypay.entity.Card;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper {
    Card toEntity(CardDto cardDto);
    CardDto toDto(Card card);
}
