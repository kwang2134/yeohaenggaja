package com.yg.yeohaenggaja.mapper;

import com.yg.yeohaenggaja.domain.Country;
import com.yg.yeohaenggaja.domain.TravelSpot;
import com.yg.yeohaenggaja.domain.TravelSpotImage;
import com.yg.yeohaenggaja.dto.CountryDetailResponse;
import com.yg.yeohaenggaja.dto.CountryMapResponse;
import com.yg.yeohaenggaja.dto.CountryRegionDetail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountryMapper {

    // 지도 매핑
    public static List<CountryMapResponse> toCountryMapResponse(List<Country> countries) {
        return countries.stream().map(country -> new CountryMapResponse(
                        country.getId(),
                        country.getContinent(),
                        country.getName(),
                        country.getTravelSpots().size(),
                        country.getFlagImageKey()
                )
        ).toList();
    }

    // 지도 나라별 응답 매핑
    public static List<CountryDetailResponse> toCountryDetailResponse(Country country) {
        // 행정 구역별 매핑
        Map<String, List<TravelSpot>> regionMap = country.getTravelSpots().stream()
                .collect(Collectors.groupingBy(TravelSpot::getRegionCode));

        return regionMap.entrySet().stream()
                .map(entry -> toCountryDetailResponseEntry(country.getId(), entry))
                .toList();
    }

    // 지도 나라별 매핑 - 행정 구역 매핑
    private static CountryDetailResponse toCountryDetailResponseEntry(String countryCode, Map.Entry<String, List<TravelSpot>> entry) {
        String regionCode = entry.getKey();
        List<TravelSpot> spots = entry.getValue();
        String regionName = spots.getFirst().getRegionName();  // 첫번째 여행지에서 regionName 추출

        // 행정 구역 내 여행지 DTO 매핑
        List<CountryRegionDetail> regionDetails = spots.stream()
                .map(CountryMapper::toCountryRegionDetail)
                .toList();

        // 행정 구역 DTO 매핑
        return new CountryDetailResponse(
                countryCode,
                regionCode,
                regionName,
                regionDetails.size(),
                regionDetails
        );
    }

    // 지도 나라별 매핑 - 행정 구역 내 여행지 매핑
    private static CountryRegionDetail toCountryRegionDetail(TravelSpot spot) {
        return new CountryRegionDetail(
                spot.getId(),
                spot.getCityName(),
                spot.getHighlight(),
                spot.getImages().stream()
                        .map(TravelSpotImage::getImageKey)
                        .toList()
        );
    }


}
