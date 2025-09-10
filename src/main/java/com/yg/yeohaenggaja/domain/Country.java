package com.yg.yeohaenggaja.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Country extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // PK

    private String name;            // 국가명

    private String region;          // 지역(대륙)

    private String description;     // 국가 간략 설명

    private String visaRequirement; // 비자 유무

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<TravelSpot> travelSpots = new ArrayList<>();

    @Builder
    public Country(String name, String region, String description, String visaRequirement) {
        this.name = name;
        this.region = region;
        this.description = description;
        this.visaRequirement = visaRequirement;
    }
}
