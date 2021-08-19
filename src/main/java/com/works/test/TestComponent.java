package com.works.test;

import com.works.models.BaseModelX;
import com.works.service.SybaseService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class TestComponent {

private final SybaseService sybaseService;


    public TestComponent(SybaseService sybaseService) {
        this.sybaseService = sybaseService;
    }

    @PostConstruct
    public void test(){

        List<BaseModelX> kullaniciList = sybaseService.getKullaniciList();
        int x;
        x=2;
    }
}
