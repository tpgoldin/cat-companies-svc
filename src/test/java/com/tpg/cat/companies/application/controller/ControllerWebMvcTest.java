package com.tpg.cat.companies.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@ActiveProfiles("dev")
public abstract class ControllerWebMvcTest {
    @Autowired
    MockMvc mockMvc;
}
