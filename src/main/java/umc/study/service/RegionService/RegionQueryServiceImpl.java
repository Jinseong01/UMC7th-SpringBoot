package umc.study.service.RegionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.repository.RegionRepository.RegionRepository;

@Service
@RequiredArgsConstructor
public class RegionQueryServiceImpl implements RegionQueryService {

    private final RegionRepository regionRepository;

    @Override
    public Boolean exist(Long id) {
        return regionRepository.existsById(id);
    }
}
