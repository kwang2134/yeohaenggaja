package com.yg.yeohaenggaja.dto;

import java.util.List;

public record TravelSpotSimpleResponse(
        Long id,
        String cityName,
        String highlight,
        String image
) {
}
