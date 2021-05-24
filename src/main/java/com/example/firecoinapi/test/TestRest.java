package com.example.firecoinapi.test;

import com.example.firecoinapi.common.FireCoinRest;
import com.example.firecoinapi.common.TestThread;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Notice:
 *
 * @author xuxu
 * @version 1.0
 * @date 2021/5/5
 * @since 1.0
 */
@RestController
@RequestMapping("/test")
public class TestRest {
    final FireCoinRest FireCoinRest;

    public TestRest(FireCoinRest FireCoinRest) {
        this.FireCoinRest = FireCoinRest;
    }

    @RequestMapping("test")
    @ResponseBody
    public String test(){
        System.out.println(System.currentTimeMillis());
        String result= FireCoinRest.getKline();
        System.out.println(System.currentTimeMillis());
        System.out.println(result);
        return "success";
    }

}
