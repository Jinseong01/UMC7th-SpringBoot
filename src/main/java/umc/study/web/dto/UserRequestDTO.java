package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.study.validation.annotation.ExistCategories;

import java.util.List;

public class UserRequestDTO {
    @Getter
    public static class JoinDto{
        @NotBlank
        String login_id;

        @NotBlank
        String login_password;

        @NotBlank
        String email;

        @NotBlank
        String name;

        @NotBlank
        String nickname;

        @NotBlank
        String phoneNumber;

        @NotNull
        Integer gender;

        @NotBlank
        String birthday;

        @Size(min = 5, max = 12)
        String address;

        @ExistCategories
        List<Long> preferCategory;
    }
}
