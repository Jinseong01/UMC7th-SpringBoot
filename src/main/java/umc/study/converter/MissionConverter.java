package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.MissionEntity;
import umc.study.domain.ReviewEntity;
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

        List<MissionResponseDTO.MissionPreViewDTO> reviewPreViewDTOList = missionList.stream()
                .map(MissionConverter::missionPreViewDTO).collect(Collectors.toList());

        return MissionResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
