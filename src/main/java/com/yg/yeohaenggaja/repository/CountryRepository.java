package com.yg.yeohaenggaja.repository;


import com.yg.yeohaenggaja.domain.Country;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query("SELECT c FROM Country c JOIN FETCH c.travelSpots")
    List<Country> findAllWithTravelSpots();

    @EntityGraph(attributePaths = {"travelSpots"})
    Optional<Country> findById(String id);

}
