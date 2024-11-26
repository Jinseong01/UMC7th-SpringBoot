package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.UserConverter;
import umc.study.domain.UserEntity;
import umc.study.domain.mapping.UserMissionEntity;
import umc.study.service.UserService.UserCommandService;
import umc.study.validation.annotation.ExistMission;
import umc.study.validation.annotation.ExistUM;
import umc.study.web.dto.UserRequestDTO;
import umc.study.web.dto.UserResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Validated
public class UserRestController {
    private final UserCommandService userCommandService;

    @PostMapping("/")
    public ApiResponse<UserResponseDTO.JoinResultDTO> join(@RequestBody @Valid UserRequestDTO.JoinDto request){
        UserEntity user = userCommandService.joinMember(request);
        return ApiResponse.onSuccess(UserConverter.toJoinResultDTO(user));
    }

    @PostMapping("/addMission")
    public ApiResponse<UserResponseDTO.ChallengeMissionResultDTO> challenge(@ExistMission @ExistUM @RequestParam Long missionId){
        UserMissionEntity userMission = userCommandService.addMission(1L, missionId);
        return ApiResponse.onSuccess(UserConverter.toChallengeMissionResultDTO(userMission));
    }
}
