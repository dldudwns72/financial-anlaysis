package com.financial.analysis.service;

import com.financial.analysis.model.ExpenseDTO;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseService {

    void saveExpense(ExpenseDTO request);

    List<ExpenseDTO> getExpenses();

    List<ExpenseDTO> getExpensesByDate(LocalDate date);
}
