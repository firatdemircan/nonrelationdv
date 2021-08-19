package com.works.service;

import com.works.database.SybaseConnection;
import com.works.models.BaseModelX;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Component
public class SybaseService {


    private final SybaseConnection sybaseConnection;
    public SybaseService(SybaseConnection sybaseConnection) {
        this.sybaseConnection = sybaseConnection;
    }


    public List<BaseModelX> getKullaniciList() {
        return sybaseConnection.maptoList(sybaseConnection.getListFromDatabase
                (sybaseConnection.getUSER_QUERY()), BaseModelX.class);
    }

    public BaseModelX getKullaniciSingle() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return sybaseConnection.maptoSingle(sybaseConnection.getSingleResult(sybaseConnection.getUSER_QUERY()), BaseModelX.class);
    }



}
