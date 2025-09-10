package com.yg.yeohaenggaja.repository;

import com.yg.yeohaenggaja.domain.TravelSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TravelSpotRepository extends JpaRepository<TravelSpot, Long> {

    @Query("SELECT t FROM TravelSpot t JOIN FETCH t.country c WHERE t.vacationDays = :days")
    List<TravelSpot> findByVacationDays(int vacationDays);
}
