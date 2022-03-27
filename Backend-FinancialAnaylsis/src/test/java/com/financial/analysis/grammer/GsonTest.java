package com.financial.analysis.grammer;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class GsonTest {

    private People peopleObject;
    private String peopleJsonString;

    @BeforeEach
    void setUp(){
        peopleObject = new People("lee",29, Arrays.asList("컴퓨터","게임","운동"));
        peopleJsonString = "{\"name\":\"lee\",\"age\":29,\"hobby\":[\"컴퓨터\",\"게임\",\"운동\"]}";
    }

    @Test
    void StringToJSON() {
        Gson gson = new Gson();
        String jsonString = gson.toJson(peopleObject);
        System.out.println(jsonString);
    }

    @Test
    void JsonStringToObject(){
        Gson gson = new Gson();
        People people = gson.fromJson(peopleJsonString,People.class);
        System.out.println(people.toString());
    }



}
