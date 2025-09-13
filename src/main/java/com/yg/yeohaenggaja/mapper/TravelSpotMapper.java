package com.yg.yeohaenggaja.mapper;

import com.yg.yeohaenggaja.domain.Country;
import com.yg.yeohaenggaja.domain.TravelSpot;
import com.yg.yeohaenggaja.domain.TravelSpotImage;
import com.yg.yeohaenggaja.dto.RecommendTravelSpotResponse;
import com.yg.yeohaenggaja.dto.TravelSpotSimpleResponse;

import java.util.List;
import java.util.Map;

public class TravelSpotMapper {

    // 추천 결과 매핑
    public static List<RecommendTravelSpotResponse> toRecommendVacationSpotResponse(Map<Country, List<TravelSpot>> spotMap) {
        return spotMap.entrySet().stream()
                .map(entry -> toRecommendVacationSpotResponse(entry.getKey(), entry.getValue()))
                .toList();
    }

    // 추천 결과 매핑 - spotSimpleResponse 제외
    private static RecommendTravelSpotResponse toRecommendVacationSpotResponse(Country country, List<TravelSpot> spots) {
        List<TravelSpotSimpleResponse> spotSimpleResponses = spots.stream()
                .map(TravelSpotMapper::toVacationSpotSimpleResponse)
                .toList();

        return new RecommendTravelSpotResponse(
                country.getName(),
                country.getRegion(),
                country.getDescription(),
                country.getVisaRequirement(),
                country.getFlagImageKey(),
                spotSimpleResponses
        );
    }

    // 추천 결과 매핑 - spotSimpleResponse 매핑
    private static TravelSpotSimpleResponse toVacationSpotSimpleResponse(TravelSpot spot) {
        List<String> imageKeys = spot.getImages().stream()
                .map(TravelSpotImage::getImageKey)
                .toList();

        return new TravelSpotSimpleResponse(
                spot.getId(),
                spot.getCityName(),
                spot.getHighlight(),
                imageKeys
        );
    }
}
