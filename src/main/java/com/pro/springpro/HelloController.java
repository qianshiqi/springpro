package com.pro.springpro;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String say(){
        System.out.println("测试快捷键");
        String str = new String();
        str = "";
        for(int i=0;i < 10;i++){
            System.out.println(i);
            str += String.valueOf(i);
        }
        return str;
    }

}
