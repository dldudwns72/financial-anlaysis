package com.financial.analysis.controller;

import com.financial.analysis.model.ExpenseDTO;
import com.financial.analysis.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/expense")
public class ExpenseController {

    @Autowired
    ExpenseService service;

    @PostMapping
    public void saveExpense(ExpenseDTO request){
        service.saveExpense(request);
    }

    @GetMapping
    public List<ExpenseDTO> getExpenses(){
        return service.getExpenses();
    }

    @GetMapping(value = "/{date}")
    public List<ExpenseDTO> getExpensesByDate(LocalDate date){
        return service.getExpensesByDate(date);
    }
}
