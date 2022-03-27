package com.financial.analysis.persistence.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "asset")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AssetEntity {

    public AssetEntity(int cash, int stock, int deposit, int savings, String month) {
        this.cash = cash;
        this.stock = stock;
        this.deposit = deposit;
        this.savings = savings;
        this.month = month;
    }
    @Id @GeneratedValue
    private Long id;

    @Column
    private int cash;

    @Column
    private int stock;

    @Column
    private int deposit;

    @Column
    private int savings;

    @Column
    private String month;

}
