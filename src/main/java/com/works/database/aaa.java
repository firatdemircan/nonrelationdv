package com.works.database;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class aaa {

    public aaa(Object[] data) {
        this.id = (String) data[0];
        this.a = (int) data[1];
    }

    private String id;
    private  int a;


}
