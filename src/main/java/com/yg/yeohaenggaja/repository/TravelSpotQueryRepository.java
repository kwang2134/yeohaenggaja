package com.yg.yeohaenggaja.repository;

import com.yg.yeohaenggaja.domain.TravelSpot;

import java.util.List;

public interface TravelSpotQueryRepository {
    List<TravelSpot> findByDaysAndSeasons(Integer days, Boolean spring, Boolean summer, Boolean fall, Boolean winter);
}
