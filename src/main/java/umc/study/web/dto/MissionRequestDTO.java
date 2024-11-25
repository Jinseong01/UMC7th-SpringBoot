package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;


public class MissionRequestDTO {
    @Getter
    public static class MissionAddDTO {
        @NotBlank
        String content;

        @NotNull
        Integer score;

        @NotBlank
        String deadline;
    }
}
