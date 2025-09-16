package com.yg.yeohaenggaja.dto;

import java.util.List;

public record CountryRegionDetail(
        Long id,
        String cityName,
        String highlight,
        List<String> images
) {
}
