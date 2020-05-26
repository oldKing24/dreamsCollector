package com.example.demo.utils;

import com.example.demo.Entity.MiniDreanListEntity;
import com.example.demo.annovation.TimeToDayAnnotation;

import java.lang.reflect.Field;

public class AnnotionUtils {
    public static String getInfo(Class<?> cs){
        String result = "";
        Field[] declaredFields = cs.getDeclaredFields();
        for (Field field : declaredFields){
            if(field.isAnnotationPresent(TimeToDayAnnotation.class)){
                TimeToDayAnnotation annotation = field.getAnnotation(TimeToDayAnnotation.class);
                String value = annotation.value();
                result += (field.getName() + ":" + value + "\n");
            }
        }
        return result;
    }

    public static void main(String[] args){
        String info = getInfo(MiniDreanListEntity.class);
        System.out.println(info);
    }
}
