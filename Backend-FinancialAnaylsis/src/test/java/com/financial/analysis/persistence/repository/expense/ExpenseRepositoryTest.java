package com.financial.analysis.persistence.repository.expense;


import com.financial.analysis.AnalysisApplication;
import com.financial.analysis.persistence.entity.Expense;
import com.financial.analysis.persistence.entity.enummodel.ExpenseType;
import com.financial.analysis.persistence.repository.ExpenseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootTest
@Rollback(value = true)
@ContextConfiguration(classes = AnalysisApplication.class)
public class ExpenseRepositoryTest {

    @Autowired
    ExpenseRepository expenseRepository;

    @BeforeEach
    public void setUp(){
        Expense expense0301Dinner = Expense.builder()
                .payDate(LocalDate.parse("2022-03-01", DateTimeFormatter.ISO_DATE))
                .placeUsed("파스타")
                .cost(9000)
                .usedType("식사")
                .expenseType(ExpenseType.WITHDRAWAL)
                .build();

        Expense expense0301Cafe = Expense.builder()
                .payDate(LocalDate.parse("2022-03-01", DateTimeFormatter.ISO_DATE))
                .placeUsed("낙성대 할리스")
                .cost(4800)
                .usedType("카페")
                .expenseType(ExpenseType.WITHDRAWAL)
                .build();

        expenseRepository.save(expense0301Dinner);
        expenseRepository.save(expense0301Cafe);
    }

    @Test
    @Transactional
    public void findByPayDate(){
        int totalCostOf0301Day = 0;
        List<Expense> expensesOf0301Day = expenseRepository.findByPayDate(LocalDate.parse("2022-03-01", DateTimeFormatter.ISO_DATE));

        for(Expense expense : expensesOf0301Day){
            totalCostOf0301Day += expense.getCost();
        }

        assertThat(totalCostOf0301Day).isEqualTo(13800);
    }


}
