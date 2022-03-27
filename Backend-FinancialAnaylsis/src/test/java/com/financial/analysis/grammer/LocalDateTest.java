package com.financial.analysis.grammer;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

public class LocalDateTest {


    @Test
    public void localDateFormatTest(){
        LocalDate localDateStringFormat = LocalDate.parse("2022-03-10", DateTimeFormatter.ISO_DATE);
        String monthToString = localDateStringFormat.getMonth().toString();

        int month = localDateStringFormat.getMonth().getValue();
        int year =  localDateStringFormat.getYear();
        int day = localDateStringFormat.getDayOfMonth();

        assertThat(monthToString).isEqualTo("MARCH");
        assertThat(year).isEqualTo(2022);
        assertThat(month).isEqualTo(3);
        assertThat(day).isEqualTo(10);
    }



}
