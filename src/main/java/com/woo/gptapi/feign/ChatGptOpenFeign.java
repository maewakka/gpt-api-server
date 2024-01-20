package com.woo.gptapi.feign;

import com.woo.gptapi.dto.GptApiTextReq;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "chat-gpt-open-feign", url = "${gpt.url}")
public interface ChatGptOpenFeign {
    @PostMapping(value = "/v1/chat/completions", consumes = "application/json")
    String requestAnswerToOpenAiApiByText(
            @RequestHeader("Authorization") String authorizationHeader,
            @RequestBody GptApiTextReq req
            );
}
