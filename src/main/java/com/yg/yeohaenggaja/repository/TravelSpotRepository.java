package com.yg.yeohaenggaja.repository;

import com.yg.yeohaenggaja.domain.TravelSpot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelSpotRepository extends JpaRepository<TravelSpot, Long>, TravelSpotRepositoryCustom {

}
