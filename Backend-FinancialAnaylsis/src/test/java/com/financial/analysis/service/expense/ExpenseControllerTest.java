package com.financial.analysis.service.expense;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.financial.analysis.controller.ExpenseController;
import com.financial.analysis.model.ExpenseDTO;
import com.financial.analysis.persistence.entity.enummodel.ExpenseType;
import com.financial.analysis.service.ExpenseService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebMvcTest(ExpenseController.class)
public class ExpenseControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;


    @MockBean
    ExpenseService service;

    @Test
    @DisplayName("비용 지출 리스트 가져오기")
    void getExpense() throws Exception{
        List<ExpenseDTO> response = new ArrayList<>();
        ExpenseDTO expense = ExpenseDTO.builder()
                .expenseID(2004L)
                .payDate(LocalDate.parse("2020-03-09", DateTimeFormatter.ISO_DATE))
                .placeUsed("할리스")
                .usedType("카페")
                .cost(6200)
                .expenseType(ExpenseType.WITHDRAWAL)
                                .build();

        response.add(expense);

        given(service.getExpenses()).willReturn(response);

        mvc.perform(get("/expense"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("할리스")))
                .andDo(print());

    }

    @Test
    void saveController() throws Exception{
        ExpenseDTO request = ExpenseDTO.builder()
                .payDate(LocalDate.parse("2020-03-01",DateTimeFormatter.ISO_DATE))
                .placeUsed("사용")
                .cost(300)
                .usedType("간식")
                .expenseType(ExpenseType.WITHDRAWAL)
                .build();

        String content = objectMapper.writeValueAsString(request);

        mvc.perform(post("/expense")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                //.andExpect(content().string("데일의 블로그입니다. dale"))
                .andDo(print());
    }


}
