import io.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by marcelvillanuevadelgado on 18/09/17.
 */
public class DataMain {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        String[] datos={"Fidel","Villanueva","23.00"};
        Data data= ReflectionUtil.getObject(Data.class,datos);

        printData(data);

    }
    public static void printData(Data data){
        Data d=data;
        System.out.println("Name: "+d.getName()+" LastName: "+d.getLastName()+" Age: "+d.getAge());
    }


}
