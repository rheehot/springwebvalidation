package com.rheehot.demospring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hey_age() throws Exception {
        mockMvc.perform(get("/hey")
                .param("name", "keesun")
                .param("age", "-25"))
                .andExpect(status().isBadRequest());

    }


    @Test
    public void hey_name() throws Exception {
        mockMvc.perform(get("/hey")
                .param("name", "")
                .param("age", "25"))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void hey() throws Exception {
        mockMvc.perform(get("/hey")
                .param("name", "keesun")
                .param("age", "25"))
                .andExpect(status().isOk());

    }


}