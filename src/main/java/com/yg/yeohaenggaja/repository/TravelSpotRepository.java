package com.yg.yeohaenggaja.repository;

import com.yg.yeohaenggaja.domain.TravelSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TravelSpotRepository extends JpaRepository<TravelSpot, Long>, TravelSpotQueryRepository {

}
