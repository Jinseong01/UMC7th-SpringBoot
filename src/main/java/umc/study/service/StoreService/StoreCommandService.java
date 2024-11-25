package umc.study.service.StoreService;

import umc.study.domain.StoreEntity;
import umc.study.web.dto.StoreRequestDTO;


public interface StoreCommandService {
    public StoreEntity addStore(StoreRequestDTO.AddDTO request);
}
