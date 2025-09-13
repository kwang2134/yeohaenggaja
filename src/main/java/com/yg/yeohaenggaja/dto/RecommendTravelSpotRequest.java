package com.yg.yeohaenggaja.dto;

import jakarta.validation.constraints.Positive;

public record RecommendTravelSpotRequest(
        @Positive int days
) {
}
