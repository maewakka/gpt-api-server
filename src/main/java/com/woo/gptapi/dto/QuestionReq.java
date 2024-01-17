package com.woo.gptapi.dto;

import lombok.Data;

@Data
public class QuestionReq {

    private String systemContent;
    private String userContent;

}
