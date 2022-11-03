package com.study.MyBag.Service;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class BagService {


    /*
    만 나이 계산
     */
    public int age() {
        int age = 0;
        String id = "19980915"; // 주민번호라고 치자.
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MMdd");

        int year = Integer.parseInt(id.substring(0, 4));        // 1998
        int monthNday = Integer.parseInt(id.substring(4, 8));   // 0915
        int todayMMdd = Integer.parseInt(String.valueOf(sdf.format(today)));

        age = (Calendar.getInstance().get(Calendar.YEAR)) - year;

        if (monthNday > todayMMdd) {
            age = age - 1;
        }

        return age;
    }
}
