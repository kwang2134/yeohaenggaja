package com.yg.yeohaenggaja.service;

import com.yg.yeohaenggaja.domain.Country;
import com.yg.yeohaenggaja.domain.TravelSpot;
import com.yg.yeohaenggaja.dto.RecommendVacationSpotResponse;
import com.yg.yeohaenggaja.mapper.TravelSpotMapper;
import com.yg.yeohaenggaja.repository.TravelSpotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TravelSpotService {
    private final TravelSpotRepository travelSpotRepository;

    public List<RecommendVacationSpotResponse> getRecommendVacationSpots(Integer days, Boolean spring, Boolean summer, Boolean fall, Boolean winter) {
        // 선택지에 맞는 여행지 조회
        List<TravelSpot> travelSpots = travelSpotRepository.findByDaysAndSeasons(days, spring, summer, fall, winter);

        // 나라를 기준으로 매핑
        Map<Country, List<TravelSpot>> spotMap = travelSpots.stream()
                .collect(Collectors.groupingBy(TravelSpot::getCountry));

        return TravelSpotMapper.toRecommendVacationSpotResponse(spotMap);
    }
}
