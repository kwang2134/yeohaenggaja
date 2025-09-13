package com.yg.yeohaenggaja.mapper;

import com.yg.yeohaenggaja.domain.Country;
import com.yg.yeohaenggaja.domain.TravelSpot;
import com.yg.yeohaenggaja.domain.TravelSpotImage;
import com.yg.yeohaenggaja.dto.RecommendTravelSpotResponse;
import com.yg.yeohaenggaja.dto.TravelSpotDetailResponse;
import com.yg.yeohaenggaja.dto.TravelSpotSimpleResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TravelSpotMapper {

    // 추천 결과 매핑
    public static List<RecommendTravelSpotResponse> toRecommendTravelSpotResponse(Map<Country, List<TravelSpot>> spotMap) {
        return spotMap.entrySet().stream()
                .map(entry -> toRecommendTravelSpotResponse(entry.getKey(), entry.getValue()))
                .toList();
    }

    // 추천 결과 매핑 - spotSimpleResponse 제외
    private static RecommendTravelSpotResponse toRecommendTravelSpotResponse(Country country, List<TravelSpot> spots) {
        List<TravelSpotSimpleResponse> spotSimpleResponses = spots.stream()
                .map(TravelSpotMapper::toTravelSpotSimpleResponse)
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
    private static TravelSpotSimpleResponse toTravelSpotSimpleResponse(TravelSpot spot) {
        String imageKeys = spot.getImages().getFirst().getImageKey();

        return new TravelSpotSimpleResponse(
                spot.getId(),
                spot.getCityName(),
                spot.getHighlight(),
                imageKeys
        );
    }

    public static TravelSpotDetailResponse toTravelSpotDetailResponse(TravelSpot travelSpot) {
        List<String> bestSeasons = new ArrayList<>();

        if (travelSpot.isSpring()) {
            bestSeasons.add("Spring");
        }

        if (travelSpot.isSummer()) {
            bestSeasons.add("Summer");
        }

        if (travelSpot.isFall()) {
            bestSeasons.add("Fall");
        }

        if (travelSpot.isWinter()) {
            bestSeasons.add("Winter");
        }

        List<String> images = travelSpot.getImages().stream()
                .map(TravelSpotImage::getImageKey)
                .toList();

        return new TravelSpotDetailResponse(
                travelSpot.getId(),
                travelSpot.getCityName(),
                travelSpot.getVacationDays(),
                travelSpot.getDescription(),
                travelSpot.getHighlight(),
                travelSpot.getFlightTime(),
                travelSpot.getAverageCost(),
                bestSeasons,
                images
        );
    }
}
