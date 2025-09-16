package com.yg.yeohaenggaja.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record GptRecommendRequest(
        @Positive int vacationDays,
        @NotBlank String cityName,
        @NotBlank String countryName,
        @NotBlank String highlights
) {
}
