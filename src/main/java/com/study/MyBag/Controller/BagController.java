package com.study.MyBag.Controller;

import com.study.MyBag.HttpServlet;
import com.study.MyBag.Service.BagService;
import com.study.MyBag.Service.ClientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

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

    @GetMapping("uniqueId")
    public String uniqueId() {
        String uId = "";
        String carNo = "12가3456"; // 차량번호 라고 치자.
        uId = bagService.uniqueId(carNo);
        return uId;
    }

    @GetMapping("raffle")
    public String raffle() {
        String str = "";

        // 임시 신청자 목록
        int[] arr = {54, 12, 2, 5, 3, 63, 77, 25, 13, 17, 92, 32, 41, 9, 28, 6, 54, 24, 33, 19, 26, 31, 22};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        // ----------------------

        ArrayList<Integer> result = bagService.raffle(list, 13);

        for (int j : result) {
            str += j+" ";
        }

        return "당첨자 목록: " + str;
    }
}
