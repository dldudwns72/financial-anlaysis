package com.financial.analysis.persistence.entity;

import com.financial.analysis.persistence.entity.enummodel.ExpenseType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "expenses")
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "expense_id")
    private Long expenseID;

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate payDate;

    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private String placeUsed;

    @Column(nullable = false, columnDefinition = "INT")
    private int cost;

    @Column(columnDefinition = "VARCHAR(100)")
    private String usedType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ExpenseType expenseType;

    @Builder
    public Expense(LocalDate payDate, String placeUsed, int cost, String usedType, ExpenseType expenseType) {
        this.payDate = payDate;
        this.placeUsed = placeUsed;
        this.cost = cost;
        this.usedType = usedType;
        this.expenseType = expenseType;
    }


}
