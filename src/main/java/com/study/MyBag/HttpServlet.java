package com.study.MyBag;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// servlet이 오면 전담할 클래스
@WebServlet(name="ServletTest", urlPatterns = "/servlet")
public class HttpServlet extends javax.servlet.http.HttpServlet {
    /*
    urlPattern에 맞추어 http 요청이 들어오면
    servlet 컨테이너는 해당 클래스의 service 메서드를 실행한다.
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }
}

