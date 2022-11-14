package uzcard.service.mapper;

import org.mapstruct.Mapper;
import uzcard.dto.UzCardDto;
import uzcard.entity.UzCard;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UzCardMapper {
    UzCard toEntity(UzCardDto uzCardDto);
    UzCardDto toDto(UzCard uzCard);
    List<UzCard> toEntityList(List<UzCardDto> uzCardDtoList);
    List<UzCardDto> toDtoList(List<UzCard> uzCardList);
}
