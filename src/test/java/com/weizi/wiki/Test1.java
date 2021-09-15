package com.weizi.wiki;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: wiki
 * @description
 * @author: hu
 * @create: 2021-09-14 03:03
 **/
public class Test1 {
    public static void main(String[] args) throws ParseException {
         //时间戳
         System.out.println(System.currentTimeMillis());
         System.out.println(new Date().getTime());

         String dateTime = "2021-09-01 08:00:00";
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
         System.out.println(sdf.parse(dateTime).getTime());
    }
}
