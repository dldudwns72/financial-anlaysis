package com.financial.analysis.model;

import com.financial.analysis.persistence.entity.enummodel.ExpenseType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;


@Data
@Builder
public class ExpenseDTO {

    private Long expenseID;

    private LocalDate payDate;

    private String placeUsed;

    private int cost;

    private String usedType;

    private ExpenseType expenseType;



}
