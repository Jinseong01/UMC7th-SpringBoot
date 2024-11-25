package umc.study.converter;

import umc.study.domain.StoreEntity;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class StoreConverter {
    public static StoreEntity toStore(StoreRequestDTO.AddDTO request) {
        return StoreEntity.builder()
                .name(request.getName())
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())
                .storeFoodCategoryEntityList(new ArrayList<>())
                .build()
                ;
    }

    public static StoreResponseDTO.AddResultDTO toResultDTO(StoreEntity store){
        return StoreResponseDTO.AddResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build()
        ;
    }
}
