package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MissionConverter;
import umc.study.converter.ReviewConverter;
import umc.study.domain.MissionEntity;
import umc.study.domain.ReviewEntity;
import umc.study.domain.mapping.UserMissionEntity;
import umc.study.service.MissionService.MissionCommandService;
import umc.study.service.MissionService.MissionQueryService;
import umc.study.validation.annotation.CheckPage;
import umc.study.validation.annotation.ExistStore;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;
import umc.study.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
@Validated
public class MissionRestController {

    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;

    @PostMapping("/{storeId}")
    public ApiResponse<MissionResponseDTO.MissionAddResultDTO> add(
            @PathVariable("storeId") @ExistStore Long storeId,
            @RequestBody @Valid MissionRequestDTO.MissionAddDTO request){
        MissionEntity mission = missionCommandService.addMission(request, storeId);
        return ApiResponse.onSuccess(MissionConverter.toResultDTO(mission));
    }

    @GetMapping("/store/{storeId}")
    @Operation(summary = "가게의 미션 목록 조회 API",description = "특정 가게의 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, query parameter입니다!")
    })
    public ApiResponse<MissionResponseDTO.MissionPreViewListDTO> getStoreMissionList(
            @PathVariable(name="storeId") Long storeId,
            @CheckPage Integer page
    ) {
        Page<MissionEntity> missionList = missionQueryService.getStoreMissionList(storeId, page);
        return ApiResponse.onSuccess(MissionConverter.missionPreViewListDTO(missionList));
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "사용자의 미션 목록 조회 API",description = "특정 사용자의 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 미션 status와 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "userId", description = "사용자의 아이디, path variable 입니다!"),
            @Parameter(name = "status", description = "미션 상태, query parameter입니다!"),
            @Parameter(name = "page", description = "페이지 번호, query parameter입니다!"),
    })
    public ApiResponse<MissionResponseDTO.UserMissionPreViewListDTO> getUserMissionList(
            @PathVariable(name="userId") Long userId,
            @RequestParam(name="status") String status,
            @CheckPage Integer page
    ) {
        Page<UserMissionEntity> missionList = missionQueryService.getUserMissionList(userId, status, page);
        return ApiResponse.onSuccess(MissionConverter.userMissionPreViewListDTO(missionList));
    }


    @PostMapping("/complete/userMission/{userMissionId}/user/{userId}")
    @Operation(summary = "사용자의 미션 완료 API",description = "특정 사용자의 특정 미션을 완료로 바꾸는 API")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "userMissionId", description = "사용자 미션의 아이디, path variable 입니다!"),
            @Parameter(name = "userId", description = "사용자의 아이디, path variable 입니다!")
    })
    public ApiResponse<MissionResponseDTO.UpdateUserMissionPreViewDTO> completeUserMission(
            @PathVariable(name="userMissionId") Long userMissionId,
            @PathVariable(name="userId") Long userId
    ) {
        UserMissionEntity userMission = missionCommandService.completeUserMission(userMissionId, userId);
        return ApiResponse.onSuccess(MissionConverter.updateUserMissionPreViewDTO(userMission));
    }
}
