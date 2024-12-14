package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.MissionEntity;
import umc.study.domain.ReviewEntity;
import umc.study.domain.mapping.UserMissionEntity;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;
import umc.study.web.dto.ReviewResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {
    public static MissionEntity toMission(MissionRequestDTO.MissionAddDTO request) {
        return MissionEntity.builder()
                .content(request.getContent())
                .reward(request.getScore())
                .deadline(LocalDate.parse(request.getDeadline()))
                .build()
                ;
    }

    public static MissionResponseDTO.MissionAddResultDTO toResultDTO(MissionEntity mission){
        return MissionResponseDTO.MissionAddResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build()
                ;
    }

    public static MissionResponseDTO.MissionPreViewDTO missionPreViewDTO(MissionEntity mission){
        return MissionResponseDTO.MissionPreViewDTO.builder()
                .content(mission.getContent())
                .reward(mission.getReward())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .build();
    }
    public static MissionResponseDTO.MissionPreViewListDTO missionPreViewListDTO(Page<MissionEntity> missionList){

        List<MissionResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(MissionConverter::missionPreViewDTO).collect(Collectors.toList());

        return MissionResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }

    public static MissionResponseDTO.UserMissionPreViewDTO userMissionPreViewDTO(UserMissionEntity userMission){
        return MissionResponseDTO.UserMissionPreViewDTO.builder()
                .storeName(userMission.getMissionEntity().getStoreEntity().getName())
                .content(userMission.getMissionEntity().getContent())
                .reward(userMission.getMissionEntity().getReward())
                .deadline(userMission.getMissionEntity().getDeadline())
                .build();
    }
    public static MissionResponseDTO.UserMissionPreViewListDTO userMissionPreViewListDTO(Page<UserMissionEntity> userMissionList){

        List<MissionResponseDTO.UserMissionPreViewDTO> userMissionPreViewDTOList = userMissionList.stream()
                .map(MissionConverter::userMissionPreViewDTO).collect(Collectors.toList());

        return MissionResponseDTO.UserMissionPreViewListDTO.builder()
                .isLast(userMissionList.isLast())
                .isFirst(userMissionList.isFirst())
                .totalPage(userMissionList.getTotalPages())
                .totalElements(userMissionList.getTotalElements())
                .listSize(userMissionPreViewDTOList.size())
                .missionList(userMissionPreViewDTOList)
                .build();
    }
}
