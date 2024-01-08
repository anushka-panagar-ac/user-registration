package com.example.RegisterUser.controller;
import com.example.RegisterUser.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ValidateRequestBodyControllerTest.class)
public class ValidateRequestBodyControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void whenInputIsInvalid_thenReturnsStatus400() throws Exception {
        User userDto = new User("abc@gmail.com", "YourPassword1234#","24.48.0.1");
        String body = objectMapper.writeValueAsString(userDto);

        mvc.perform(post("/api/v1/user/register")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(userDto)))
                .andExpect(content().string("Valid request"));

    }

    @Test
    public void testValidateRequestBody_InvalidInput() throws Exception {
        User userDto = new User("", "YourPassword123#","24.48.0.1");
        String body = objectMapper.writeValueAsString(userDto);
        mvc.perform(post("/api/v1/user/register")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(userDto)))
                .andExpect(jsonPath("$.message").value("Username cannot be blank"));
    }
}

