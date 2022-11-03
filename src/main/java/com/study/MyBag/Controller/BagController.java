package com.study.MyBag.Controller;

import com.study.MyBag.HttpServlet;
import com.study.MyBag.Service.BagService;
import com.study.MyBag.Service.ClientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class BagController {
    private BagService bagService;
    private ClientInfoService clientInfoService;

    @Autowired
    public BagController(BagService bagService, ClientInfoService clientInfoService) {
        this.bagService = bagService;
        this.clientInfoService = clientInfoService;
    }

    @GetMapping("age")
    public int age() {
        int age = bagService.age();
        return age;
    }

    @GetMapping("clientInfo")
    public void clientInfo(HttpServletRequest request) throws Exception {
        String info = clientInfoService.getInfo(request);
        String osInfo = clientInfoService.osInfo(request);
        String webInfo = clientInfoService.webInfo(request);
        String webVersionInfo = clientInfoService.webVersionInfo(request);

        System.out.println(info);
        System.out.println(osInfo);
        System.out.println(webInfo);
        System.out.println(webVersionInfo);
    }

}
