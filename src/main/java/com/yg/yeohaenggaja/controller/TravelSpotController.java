package com.yg.yeohaenggaja.controller;

import com.yg.yeohaenggaja.dto.RecommendVacationSpotResponse;
import com.yg.yeohaenggaja.global.common.CommonResponse;
import com.yg.yeohaenggaja.global.exception.ErrorCode;
import com.yg.yeohaenggaja.service.TravelSpotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TravelSpotController {
    private final TravelSpotService travelSpotService;

    @GetMapping("/recommendations")
    public CommonResponse<List<RecommendVacationSpotResponse>> getRecommendVacationSpots(@RequestParam(required = false) Integer days,
                                                                                         @RequestParam(required = false) Boolean spring,
                                                                                         @RequestParam(required = false) Boolean summer,
                                                                                         @RequestParam(required = false) Boolean fall,
                                                                                         @RequestParam(required = false) Boolean winter) {
        if(days == null && spring == null && summer == null && fall == null && winter == null) {
            throw ErrorCode.MISSING_FILTER_CONDITIONS.domainException("조건이 입력되지 않음");
        }

        List<RecommendVacationSpotResponse> result = travelSpotService.getRecommendVacationSpots(days, spring, summer, fall, winter);
        return CommonResponse.success(result);
    }


}
