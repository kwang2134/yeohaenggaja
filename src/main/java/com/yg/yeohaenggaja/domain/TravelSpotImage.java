package com.yg.yeohaenggaja.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TravelSpotImage extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "travel_spot_id")
    private TravelSpot travelSpot;

    private String imageKey;

    @Builder
    public TravelSpotImage(TravelSpot travelSpot, String imageKey) {
        this.travelSpot = travelSpot;
        this.imageKey = imageKey;
    }
}
