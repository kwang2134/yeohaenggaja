package com.yg.yeohaenggaja.repository;

import com.yg.yeohaenggaja.domain.TravelSpot;

import java.util.List;

public interface TravelSpotRepositoryCustom {
    List<TravelSpot> searchByDaysAndSeasons(Integer days, Boolean spring, Boolean summer, Boolean fall, Boolean winter);
}
