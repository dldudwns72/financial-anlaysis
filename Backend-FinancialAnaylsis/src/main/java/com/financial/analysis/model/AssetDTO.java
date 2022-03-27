package com.financial.analysis.model;

import lombok.Data;

@Data
public class AssetDTO {

    private Long id;

    private int cash;

    private int stock;

    private int deposit;

    private int savings;

    private String month;

}
