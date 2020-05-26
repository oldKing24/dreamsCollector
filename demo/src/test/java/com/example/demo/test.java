package com.example.demo;

import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class test {
    public static void main(String[] args) throws Exception{
        String sql = null;
        String sql1 = "000";
        if(!StringUtils.isEmpty(sql)&&sql.equals(sql1)){
            System.out.println("11111");
        }else{
            System.out.println("2222222");
        }
//        ArrayList<Integer> list = new ArrayList<>();
//        int a = 0;
//        for(int i=0;i<10;i++){
//            list.add(i);
//        }
//        test test1 = new test();
//        test1.remove(list);
//        for(Integer integer:list){
//            System.out.println(a+++"----------"+integer);//先使用a，再操作a
////            System.out.println(++a+"----------"+integer);//先操作a，再使用a
//        }
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            Date d2 =sdf.parse("2020-03-05");
//            System.out.println(d2.compareTo(new Date()));
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }

    private void remove(ArrayList<Integer> list){
        //不能使用容器的remove
//        for(Integer i :list){
//            list.remove(i);
//        }
        //可以使用迭代器的remove
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
            if(it.next()<5){
                it.remove();
            }
        }
    }
}
