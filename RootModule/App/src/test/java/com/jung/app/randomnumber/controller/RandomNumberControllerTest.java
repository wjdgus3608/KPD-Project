package com.jung.app.randomnumber.controller;

import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RandomNumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("인증번호 요청 정상동작 확인")
    void successCase() throws Exception {
        JSONObject json = new JSONObject();
        json.put("parentId","id1");
        json.put("childId","id2");

        mockMvc.perform(
                post("/req-randomnumber")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json.toString()))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("부모ID, 자식ID가 존재하지 않으면 클라이언트(400) 에러를 리턴한다.")
    void errorCase() throws Exception {
        mockMvc.perform(post("/req-randomnumber"))
                .andExpect(status().is4xxClientError());
    }

}