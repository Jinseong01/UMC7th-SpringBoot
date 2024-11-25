package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MissionConverter;
import umc.study.domain.MissionEntity;
import umc.study.service.MissionService.MissionCommandService;
import umc.study.validation.annotation.ExistStore;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
@Validated
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/{storeId}")
    public ApiResponse<MissionResponseDTO.MissionAddResultDTO> add(
            @PathVariable("storeId") @ExistStore Long storeId,
            @RequestBody @Valid MissionRequestDTO.MissionAddDTO request){
        MissionEntity mission = missionCommandService.addMission(request, storeId);
        return ApiResponse.onSuccess(MissionConverter.toResultDTO(mission));
    }
}
