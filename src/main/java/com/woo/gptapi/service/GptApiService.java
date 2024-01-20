package com.woo.gptapi.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.woo.gptapi.dto.GptApiTextReq;
import com.woo.gptapi.dto.TextReq;
import com.woo.gptapi.feign.ChatGptOpenFeign;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GptApiService {

    private final ChatGptOpenFeign chatGptOpenFeign;
    private final Gson gson;

    @Value("${gpt.token}")
    private String token;
    @Value("${gpt.model}")
    private String model;

    public List<JsonObject> getAnswerForQuestion(TextReq req) {

        String resp = chatGptOpenFeign.requestAnswerToOpenAiApiByText(token,
                GptApiTextReq.builder()
                        .model(model)
                        .messages(Arrays.asList(
                                GptApiTextReq.Message.builder()
                                        .role("user")
                                        .content(req.getQuestion())
                                        .build()
                        ))
                        .build());


        JsonObject result = gson.fromJson(resp, JsonObject.class);
        JsonArray choicesArray = result.getAsJsonArray("choices");
        Type type = new TypeToken<List<JsonObject>>() {}.getType();

        return gson.fromJson(choicesArray.toString(), type);
    }
}
