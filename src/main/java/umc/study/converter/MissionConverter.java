package umc.study.converter;

import umc.study.domain.MissionEntity;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
}
