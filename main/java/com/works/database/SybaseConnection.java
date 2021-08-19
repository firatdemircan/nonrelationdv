package com.works.database;
import com.works.models.BaseModel;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


@Component
@Getter
public class SybaseConnection {


    private final EntityManager em;

    public SybaseConnection(EntityManager em) {
        this.em = em;
    }

    //Queries
    private final String USER_QUERY = "select sd.sicil,p.adi,p.soyadi,unv.unvanadi from personel_sondurum sd " +
            "left join personel p on sd.sicil=p.sicil " +
            " left join unvan unv on sd.unvankodu=unv.unvankodu" +
            " where sd.aktif_pasif='A' order by sd.unvankodu";
    //Queries



    public List<Object[]> getListFromDatabase(String query) {
        Query nativeQuery = em.createNativeQuery(query);
        return nativeQuery.getResultList();
    }

    public Object getSingleResult(String query){
        Query nativeQuery = em.createNativeQuery(query);
        return nativeQuery.getSingleResult();
    }


    //should think more how to make it generic
    public <T extends BaseModel> List<T> maptoList(List<Object[]> data, Class<T> t)  {
        List<T> result = new ArrayList<>();
            data.forEach(x->{
                T t1 = null;
                try {
                    t1 = t.getDeclaredConstructor().newInstance();
                    t1.setX(x);
                    result.add(t1);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }

            });
        return  result;
    }
    public <T extends BaseModel> T maptoSingle(Object data, Class<T> t) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        T t1 = t.getDeclaredConstructor().newInstance();

        return t1;

    }

}
