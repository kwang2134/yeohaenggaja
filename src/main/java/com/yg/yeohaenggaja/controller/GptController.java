package com.yg.yeohaenggaja.controller;

import com.yg.yeohaenggaja.dto.GptRecommendRequest;
import com.yg.yeohaenggaja.global.common.CommonResponse;
import com.yg.yeohaenggaja.service.GptService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/gpt")
@RequiredArgsConstructor
public class GptController {

    private final GptService gptService;

    @PostMapping("/recommend")
    public CommonResponse<String> getRecommendFromGpt(@Valid @RequestBody GptRecommendRequest request) {
        String result = gptService.askGpt(request);
        return CommonResponse.success(result);
    }
}
