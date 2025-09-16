package com.yg.yeohaenggaja.dto;

import java.util.List;

public record RecommendTravelSpotResponse(
        String id,
        String name,
        String continent,
        String description,
        String visaRequirement,
        String flagImageKey,
        List<TravelSpotSimpleResponse> spots
) {}
