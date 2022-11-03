package com.study.MyBag.Service;

import com.study.MyBag.HttpServlet;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Service
public class ClientInfoService {
    /*
    IP주소 확인
     */
    public String getInfo(HttpServletRequest request) throws Exception{
        String ip = request.getRemoteAddr();  // ip주소
        String host = request.getRemoteHost();// host명
        int port = request.getRemotePort();   // 포트번호

        return "IP: " + ip +" , host: " + host + " , port: " + port;
    }

    public String osInfo(HttpServletRequest request) throws Exception{
        String userAgent = request.getHeader("user-agent");
        String osInfo = userAgent.toUpperCase().split(";")[2].split("\\)")[0];

        return "OS info : " + osInfo;
    }

    public String webInfo(HttpServletRequest request) throws Exception{
        String userAgent = request.getHeader("user-agent");
        // 웹브라우저 종류 조회
        String webInfo = "";
        if (userAgent.toUpperCase().indexOf("GECKO") != -1) {
            if (userAgent.toUpperCase().indexOf("NESCAPE") != -1) {
                webInfo = "Netscape (Gecko/Netscape)";
            } else if (userAgent.toUpperCase().indexOf("FIREFOX") != -1) {
                webInfo = "Mozilla Firefox (Gecko/Firefox)";
            } else {
                webInfo = "Mozilla (Gecko/Mozilla)";
            }
        } else if (userAgent.toUpperCase().indexOf("MSIE") != -1) {
            if (userAgent.toUpperCase().indexOf("OPERA") != -1) {
                webInfo = "Opera (MSIE/Opera/Compatible)";
            } else {
                webInfo = "Internet Explorer (MSIE/Compatible)";
            }
        } else if (userAgent.toUpperCase().indexOf("SAFARI") != -1) {
            if (userAgent.toUpperCase().indexOf("CHROME") != -1) {
                webInfo = "Google Chrome";
            } else {
                webInfo = "Safari";
            }
        } else if (userAgent.toUpperCase().indexOf("THUNDERBIRD") != -1) {
            webInfo = "Thunderbird";
        } else {
            webInfo = "Other Web Browsers";
        }
        return "webInfo: "+webInfo;
    }

    public String webVersionInfo(HttpServletRequest request) throws Exception{
        String userAgent = request.getHeader("user-agent");
        // 웹브라우저 종류 조회
        String webVersionInfo = "";
        String [] arr = {"MSIE", "OPERA", "NETSCAPE", "FIREFOX", "SAFARI"};
        for (int i = 0; i < arr.length; i++) {
            int s_loc = userAgent.toUpperCase().indexOf(arr[i]);
            if (s_loc != -1) {
                int f_loc = s_loc + arr[i].length();
                webVersionInfo = userAgent.toUpperCase().substring(f_loc, f_loc+5);
                webVersionInfo = webVersionInfo.replaceAll("/", "").replaceAll(";", "").replaceAll("^", "").replaceAll(",", "").replaceAll("//.", "");
            }
        }
        return "webVersionInfo: "+webVersionInfo;
    }
}
