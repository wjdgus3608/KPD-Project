//package com.jung.test.controller;
//
//
//import com.jung.app.randomnumber.controller.RandomNumberController;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//public class RandomNumberControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    @DisplayName("request에 부모ID, 자식ID가 존재하여야 한다")
//    public void requestTest() throws Exception {
//        mockMvc.perform(post("/req-randomnumber"))
//                .andExpect(status().is4xxClientError());
//    }
//}
