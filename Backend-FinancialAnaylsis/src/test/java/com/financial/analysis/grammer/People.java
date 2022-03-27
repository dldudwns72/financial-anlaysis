package com.financial.analysis.grammer;

import java.util.List;


public class People {

    private String name;

    private int age;

    private List<String> hobby;

    public People(String name, int age, List<String> hobby) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobby=" + hobby +
                '}';
    }
}
