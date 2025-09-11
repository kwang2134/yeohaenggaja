package com.yg.yeohaenggaja.dto;

import jakarta.validation.constraints.Positive;

public record RecommendVacationSpotRequest(
        @Positive int days
) {
}
