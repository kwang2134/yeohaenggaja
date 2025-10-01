package com.yg.yeohaenggaja.service;

import com.yg.yeohaenggaja.domain.Prompt;
import com.yg.yeohaenggaja.dto.GptRecommendRequest;
import com.yg.yeohaenggaja.repository.GptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class GptService {

    private final OpenAiChatModel chatModel;
    private final GptRepository gptRepository;

    @Transactional(readOnly = true)
    public String askGpt(GptRecommendRequest request) {
        Prompt travel = gptRepository.findByName("Travel").getFirst();

        String prompt = getPrompt(request, travel);
        return chatModel.call(prompt);
    }

    private String getPrompt(GptRecommendRequest request, Prompt travel) {
        Map<String, String> requestMap = Map.of(
                "vacationDays", String.valueOf(request.vacationDays()),
                "cityName", request.cityName(),
                "countryName", request.countryName(),
                "highlights", request.highlights()
        );

        String prompt = travel.getPrompt();
        for (Map.Entry<String, String> entry : requestMap.entrySet()) {
            prompt = prompt.replace("{"+ entry.getKey() + "}", entry.getValue());
        }
        return prompt;
    }
}
