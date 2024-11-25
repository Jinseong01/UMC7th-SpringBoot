package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import java.math.BigDecimal;

public class ReviewRequestDTO {
    @Getter
    public static class reviewDTO {
        @NotBlank
        String content;

        @NotNull
        BigDecimal score;
    }
}
