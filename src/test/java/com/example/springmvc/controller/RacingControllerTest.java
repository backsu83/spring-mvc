package com.example.springmvc.controller;

import com.example.springmvc.exception.ParamException;
import com.example.springmvc.service.DisplayBoardService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class RacingControllerTest {

    private MockMvc mockMvc;

    @Mock
    DisplayBoardService service;

    @InjectMocks
    RacingController controller;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testRestExceptionHandler() throws Exception {
        doThrow(new ParamException("test")).when(service).getOdds(anyString());
        mockMvc.perform(get("/"))
                .andExpect(status().isBadRequest());
    }

}