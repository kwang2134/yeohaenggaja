package com.yg.yeohaenggaja.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TravelSpot extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // PK

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;         // FK

    private String cityName;        // 도시이름

    private int vacationDays;    // 적정 휴가 기간

    private String description;     // 여행지 설명

    private String highlight;       // 특징

    private String flightTime;      // 평균 비행시간

    private String averageCost;     // 평균 항공권 가격 (비수기)

    private String bestMonth;       // 추천 시즌

    @OneToMany(mappedBy = "travelSpot", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<TravelSpotImage> images = new ArrayList<>();

    @Builder
    public TravelSpot(String cityName, Country country, int vacationDays, String description, String highlight, String flightTime, String averageCost, String bestMonth) {
        this.cityName = cityName;
        this.country = country;
        this.vacationDays = vacationDays;
        this.description = description;
        this.highlight = highlight;
        this.flightTime = flightTime;
        this.averageCost = averageCost;
        this.bestMonth = bestMonth;
    }
}

