package com.woo.gptapi.controller;

import com.google.gson.JsonObject;
import com.woo.gptapi.dto.TextReq;
import com.woo.gptapi.service.GptApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GptApiController {

    private final GptApiService gptApiService;

    @PostMapping("/text")
    @ResponseBody
    public List<JsonObject> getAnswerForQuestion(@RequestBody TextReq req) {
        return gptApiService.getAnswerForQuestion(req);
    }

}
