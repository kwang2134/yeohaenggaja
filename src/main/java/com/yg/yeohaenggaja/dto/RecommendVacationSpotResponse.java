package com.yg.yeohaenggaja.dto;

import java.util.List;

public record RecommendVacationSpotResponse(
        String name,
        String region,
        String description,
        String visaRequirement,
        String flagImageKey,
        List<VacationSpotSimpleResponse> spots
) {}
