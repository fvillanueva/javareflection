package io.util;

import java.lang.reflect.Field;

public class ReflectionUtil {
    /**
     * Crear un Object a partir de
     * un String de Datos que vienen ser
     * las variables del Object
     * @param t
     * @param d
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static  <T> T getObject(Class<T> t, String... d) throws IllegalAccessException, InstantiationException {
        T ts=t.newInstance();
        Field[] fields=t.getDeclaredFields();
        for (int i = 0; i <d.length ; i++) {
            Field bean=fields[i];
            bean.setAccessible(true);
            bean.set(ts,d[i]);
        }
        return ts;

    }
    public static void printObject(Class<?> clas){

    }


}
