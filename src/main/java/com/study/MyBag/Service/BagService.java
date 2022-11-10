package com.study.MyBag.Service;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
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

    public String uniqueId(String carNo) {
        /*
        <요구사항>
        1. ID는 숫자4자리+알파벳2자리+숫자4자리로 한다.
        2. 처음 숫자 4자리는 받아오는 차량번호이다.
        3. 알파벳 2자리 중 첫번째는 년도, 두번째는 월
            -> 2022년 (현재년도) 기준 'A'
            -> 1월 ~ 12월 : 'A' ~ 'L'
        4. 뒤 숫자 4자리는 카운트이다. (당월에 해당 차량이 몇번 이용했는지)
         */
        String no = "";

        char nostr1; // 알파벳 첫번째 문자
        char nostr2; // 알파벳 두번째 문자

        int ynum = 65; // 아스키코드 숫자
        int mnum = 65; // 아스키코드 숫자

        int alphabetOfYear = 2022;
        no = carNo.substring(carNo.length() - 4, carNo.length());

        // 알파벳 첫번째 문자 시작
        LocalDate date = LocalDate.now();
        int year = date.getYear();

        if (year > alphabetOfYear) {
            // 현재 년도가 2022년 이후일 경우
            ynum = ynum + (year - alphabetOfYear);
        } else if (year < alphabetOfYear) {
            // 현재 년도가 2022년 이전일 경우
            ynum = ynum + (alphabetOfYear - year);
        }

        nostr1 = (char) ynum; // 아스키코드 문자변환
        no += nostr1;
        // 알파벳 첫번째 문자 완료
        // 알파벳 두번째 문자 시작
        int month = date.getMonthValue();

        if (month > 1) {
            // 현재 월이 1월 이후인 경우
            mnum = mnum + (month - 1);
        }

        nostr2 = (char) mnum;
        no += nostr2;
        // 알파벳 두번째 문자 완료

        // 당월에 해당 차량이 5번 이용했다고 치자. * count는 DB 데이터로 카운트 파악
        int count = 5;
        no = no + String.format("%04d", count);
        // ----
        String s = carNo + "은 " + date.getYear() + "년(" + nostr1 + ") " + date.getMonthValue() + "월(" + nostr2 + ")에 " + count + "번 이용함";
        return "ID: "+no + " / " + s;
    }
}
