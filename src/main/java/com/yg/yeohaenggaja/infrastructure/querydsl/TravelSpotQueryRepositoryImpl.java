package com.yg.yeohaenggaja.infrastructure.querydsl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yg.yeohaenggaja.domain.QTravelSpot;
import com.yg.yeohaenggaja.domain.TravelSpot;
import com.yg.yeohaenggaja.repository.TravelSpotQueryRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.yg.yeohaenggaja.domain.QTravelSpot.*;

@Repository
@RequiredArgsConstructor
public class TravelSpotQueryRepositoryImpl implements TravelSpotQueryRepository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    @Override
    public List<TravelSpot> findByDaysAndSeasons(Integer days, Boolean spring, Boolean summer, Boolean fall, Boolean winter) {
        BooleanBuilder builder = new BooleanBuilder();

        if (days != null) {
            builder.and(travelSpot.vacationDays.eq(days));
        }

        if(spring != null && spring) {
            builder.and(travelSpot.spring.isTrue());
        }

        if (summer != null && summer) {
            builder.and(travelSpot.summer.isTrue());
        }

        if (fall != null && fall) {
            builder.and(travelSpot.fall.isTrue());
        }

        if (winter != null && winter) {
            builder.and(travelSpot.winter.isTrue());
        }

        return queryFactory.selectFrom(travelSpot)
                .join(travelSpot.country).fetchJoin()
                .leftJoin(travelSpot.images).fetchJoin()
                .where(builder)
                .distinct()
                .fetch();
    }
}
