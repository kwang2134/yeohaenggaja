package com.yg.yeohaenggaja.dto;

public record CountryMapResponse(
        String countryCode,
        String continent,
        String countryName,
        int travelSpotCount,
        String flagImageKey
) {
}
