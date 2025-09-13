package com.yg.yeohaenggaja.repository;

import com.yg.yeohaenggaja.domain.TravelSpot;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TravelSpotRepository extends JpaRepository<TravelSpot, Long>, TravelSpotRepositoryCustom {

    @EntityGraph(attributePaths = {"images"})
    Optional<TravelSpot> findWithImagesById(Long id);
}
