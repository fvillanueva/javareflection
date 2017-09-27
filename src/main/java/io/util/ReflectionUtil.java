package io.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<Field> fieldList=new ArrayList<>();
        Field[] fieldParent=t.getSuperclass().getDeclaredFields();
        Field[] fieldSub=t.getDeclaredFields();
        if (fieldParent.length>0){
            for (int i = 0; i <fieldParent.length ; i++) {
                fieldList.add(fieldParent[i]);
            }
        }
        for (int i = 0; i <fieldSub.length ; i++) {
            fieldList.add(fieldSub[i]);
        }
        int index=0;
        for (Field field:fieldList){
            Field bean=field;
            bean.setAccessible(true);
            bean.set(ts,d[index]);
            index++;
        }
        return ts;
    }

    /**
     *
     * @param o
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static Map<String,Object> getObjectWithParentFields(Object o) throws IllegalAccessException, InstantiationException {
        Map<String, Object> map=new HashMap<>();
        List<Field> fieldList=new ArrayList<>();
        Field[] fieldParent=o.getClass().getSuperclass().getDeclaredFields();
        Field[] fieldSub=o.getClass().getDeclaredFields();
        for (int i = 0; i <fieldParent.length ; i++) {
            fieldList.add(fieldParent[i]);
        }
        for (int i = 0; i <fieldSub.length ; i++) {
            fieldList.add(fieldSub[i]);
        }
        for (Field field:fieldList){
            Field bean=field;
            bean.setAccessible(true);
            map.put(bean.getName(),bean.get(o));
        }
        return map;
    }


    /**
     *
     * @param o
     * @throws IllegalAccessException
     */
    public static void printObjectField(Object o) throws IllegalAccessException {
        List<Field> fieldList=new ArrayList<>();
        Field[] fieldParent=o.getClass().getSuperclass().getDeclaredFields();
        Field[] fieldSub=o.getClass().getDeclaredFields();
        if(fieldParent.length>0){
            for (int i = 0; i <fieldParent.length ; i++) {
                fieldList.add(fieldParent[i]);
            }
        }
        for (int i = 0; i <fieldSub.length ; i++) {
            fieldList.add(fieldSub[i]);
        }
        for (Field field:fieldList) {
            Field bean=field;
            bean.setAccessible(true);
            System.out.println(bean.getName()+ " => "+bean.get(o)+"  Type: "+ bean.getType());
        }

    }




}
