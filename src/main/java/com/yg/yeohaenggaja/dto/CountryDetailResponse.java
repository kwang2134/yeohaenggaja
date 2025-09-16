package com.yg.yeohaenggaja.dto;

import java.util.List;

public record CountryDetailResponse(
        String countryCode,
        String regionCode,
        String regionName,
        int travelSpotCount,
        List<CountryRegionDetail> spots
) {
}
