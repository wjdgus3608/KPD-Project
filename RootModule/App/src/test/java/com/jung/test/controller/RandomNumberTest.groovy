package com.jung.test.controller

import com.jung.app.randomnumber.controller.RandomNumberController
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

class RandomNumberTest extends Specification {
    MockMvc mockMvc;

    def setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(new RandomNumberController()).build()
    }


    def "인증번호 발급을 위해 부모,자식ID가 request에 존재해야한다"(){
        when:
        def response = mockMvc.perform(post('/req-randomnumber'))
        then:
            response == "200"
    }

}
