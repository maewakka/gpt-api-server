package com.woo.gptapi.controller;

import com.woo.gptapi.dto.QuestionReq;
import com.woo.gptapi.service.GptApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GptApiController {

    private final GptApiService gptApiService;

    @PostMapping("/gpt")
    @ResponseBody
    public String getAnswerForQuestion(@RequestBody QuestionReq req) {
        return gptApiService.getAnswerForQuestion(req).toString();
    }

}
