package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import umc.study.validation.annotation.ExistCategories;
import umc.study.validation.annotation.ExistRegion;

import java.util.List;

public class StoreRequestDTO {
    @Getter
    public static class storeDTO {
        @NotBlank
        String name;

        @NotBlank
        String address;

        @NotBlank
        String phoneNumber;

        @ExistRegion
        Long region;

        @ExistCategories
        List<Long> preferCategory;
    }
}
