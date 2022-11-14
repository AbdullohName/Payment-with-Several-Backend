//package com.example.easypay;
//
//import com.example.easypay.dto.LoginDTO;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import static org.hamcrest.Matchers.containsString;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class IntegrationTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    void getTokenWithUsernameAndPassword() throws Exception {
//        ObjectMapper objectMapper = new ObjectMapper();
//        String content = objectMapper.writeValueAsString(LoginDTO.builder()
//                                            .username("abdulloh")
//                                            .password("12345").build());
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/login")
//                .contentType("application/json")
//                .content(content);
////                .header("X-API-VERSION",1);
//        mockMvc.perform(requestBuilder)
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.content().string(containsString("token")));
//
//    }
//}
