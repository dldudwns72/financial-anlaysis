package com.financial.analysis.service.impl;

import com.financial.analysis.model.ExpenseDTO;
import com.financial.analysis.persistence.entity.Expense;
import com.financial.analysis.persistence.repository.ExpenseRepository;
import com.financial.analysis.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    ExpenseRepository repository;

    @Override
    public void saveExpense(ExpenseDTO request) {
        Expense entity = new Expense(
                request.getPayDate(),
                request.getPlaceUsed(),
                request.getCost(),
                request.getUsedType(),
                request.getExpenseType());

        repository.save(entity);
    }

    @Override
    public List<ExpenseDTO> getExpenses() {
        Iterable<Expense> expenses = repository.findAll();
        List<ExpenseDTO> response = new ArrayList<>();
        expenses.forEach(expense -> {
            ExpenseDTO dto = ExpenseDTO.builder()
                    .expenseID(expense.getExpenseID())
                    .payDate(expense.getPayDate())
                    .cost(expense.getCost())
                    .usedType(expense.getUsedType())
                    .expenseType(expense.getExpenseType())
                    .build();

            response.add(dto);
        });
        /*
        for (ExpenseEntity entity : expenses){
            ExpenseDTO dto = ExpenseDTO.builder()
                    .expenseID(entity.getExpenseID())
                    .payDate(entity.getPayDate())
                    .cost(entity.getCost())
                    .usedType(entity.getUsedType())
                    .expenseType(entity.getExpenseType())
                    .build();

            response.add(dto);
        }
        */
        return response;
    }

    @Override
    public List<ExpenseDTO> getExpensesByDate(LocalDate date) {
        List<Expense> expenses = repository.findByPayDate(date);
        return expenses.stream()
                .map(expense ->
                        ExpenseDTO.builder()
                            .expenseID(expense.getExpenseID())
                            .payDate(expense.getPayDate())
                            .cost(expense.getCost())
                            .usedType(expense.getUsedType())
                            .expenseType(expense.getExpenseType())
                            .build()
                ).collect(Collectors.toList());

    }
}
