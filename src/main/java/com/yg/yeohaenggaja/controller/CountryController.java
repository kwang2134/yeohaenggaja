package com.yg.yeohaenggaja.controller;

import com.yg.yeohaenggaja.dto.CountryDetailResponse;
import com.yg.yeohaenggaja.dto.CountryMapResponse;
import com.yg.yeohaenggaja.global.common.CommonResponse;
import com.yg.yeohaenggaja.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/map/countries")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    public CommonResponse<List<CountryMapResponse>> getCountryMap() {
        return CommonResponse.success(countryService.getCountryMap());
    }

    @GetMapping("{countryCode}/regions")
    public CommonResponse<List<CountryDetailResponse>> getCountryDetail(@PathVariable String countryCode) {
        return CommonResponse.success(countryService.getCountryDetails(countryCode));
    }
}
