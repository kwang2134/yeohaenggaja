package com.yg.yeohaenggaja.dto;

import java.util.List;

public record TravelSpotDetailResponse(
        Long id,
        String cityName,
        String regionName,
        int vacationDays,
        String description,
        String highlight,
        String flightTime,
        String averageCost,
        List<String> bestSeasons,
        List<String> images
) {}
