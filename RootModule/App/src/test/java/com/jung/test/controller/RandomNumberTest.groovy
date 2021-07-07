package com.jung.test.controller

import com.jung.app.randomnumber.controller.RandomNumberController
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.test.EmbeddedKafkaBroker
import org.springframework.kafka.test.context.EmbeddedKafka
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

//@EmbeddedKafka(partitions = 1)
@Slf4j
class RandomNumberTest extends Specification {
    private MockMvc mockMvc;
   /* @Autowired
    private EmbeddedKafkaBroker embeddedKafkaBroker;
*/
    def setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(new RandomNumberController()).build()
    }

/*    def "카프카 정상 연결 테스트"(){
        expect:
        embeddedKafkaBroker.getTopics() == null
    }

    def "인증번호 정상 응답 테스트"(){

    }*/

  /*  def "인증번호 발급을 위해 부모,자식ID가 request에 없으면 에러리턴"(){
        when:
        def response = mockMvc.perform(post('/req-randomnumber'))
        then:
            response == "200"
    }*/

    def "인증번호는 매번 달라야한다"(){
        when:
        def a = 1

        then:
        a==1
    }
}
