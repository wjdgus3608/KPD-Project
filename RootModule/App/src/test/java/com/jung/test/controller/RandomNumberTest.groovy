package com.jung.test.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

class RandomNumberTest extends Specification {
    @Autowired
    private MockMvc mvc;

    def "인증번호 발급을 위해 부모,자식ID가 request에 존재해야한다"(){
        given:
        String result = null;
        when:
        result = mvc.perform(post("/req-randomnumber"));
        then:
        System.out.println(result);
    }

}
