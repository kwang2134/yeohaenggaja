package com.yg.yeohaenggaja.service;

import com.yg.yeohaenggaja.domain.Country;
import com.yg.yeohaenggaja.domain.TravelSpot;
import com.yg.yeohaenggaja.dto.CountryDetailResponse;
import com.yg.yeohaenggaja.dto.CountryMapResponse;
import com.yg.yeohaenggaja.global.exception.ErrorCode;
import com.yg.yeohaenggaja.mapper.CountryMapper;
import com.yg.yeohaenggaja.repository.CountryRepository;
import com.yg.yeohaenggaja.repository.TravelSpotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    @Transactional(readOnly = true)
    public List<CountryMapResponse> getCountryMap() {
        List<Country> countries = countryRepository.findAllWithTravelSpots();

        return CountryMapper.toCountryMapResponse(countries);
    }

    @Transactional(readOnly = true)
    public List<CountryDetailResponse> getCountryDetails(String countryCode) {
        Country country = countryRepository.findById(countryCode).orElseThrow(
                () -> ErrorCode.COUNTRY_NOT_FOUND.domainException("존재하지 않는 나라 코드 : " + countryCode)
        );

        return CountryMapper.toCountryDetailResponse(country);
    }
}
