package com.works.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseModelX extends BaseModel {
    private String sicil;
    private String adSoyad;
    private String unvan;
    private String unvanKod;
    private String isyeriAd;

    @Override
    public void setX(Object[] params) {
        this.sicil= (String) params[0];
        this.adSoyad=  params[1] + " "+ params[2];
        this.unvan= (String) params[3];
    }
}
