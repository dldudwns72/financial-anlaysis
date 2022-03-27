package com.financial.analysis.persistence.repository;
import com.financial.analysis.persistence.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{
    List<Expense> findByPayDate(LocalDate dateTime);
}
