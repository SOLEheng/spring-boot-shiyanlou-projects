package com.itheng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author PV-CZH mail:zilemontree@yeah.net
 * @description Thymeleaf test
 * @Date 2020/12/10 23:36
 * @title: ThymeleafController
 * @projectName spring-boot-shiyanlou-projects
 */
@Controller
public class ThymeleafController {
    @GetMapping("/thymeleaf")
    public String helloThymeleaf(HttpServletRequest request, @RequestParam(value = "description",required = false,defaultValue = "springboot-thymeleaf") String description) {
        request.setAttribute("description",description);
        return "thymeleaf";
    }

    @GetMapping("/attributes")
    public String attributes(Model model) {
        model.addAttribute("th_background","#FFC0CB");
        model.addAttribute("title","Thymeleaf标签演示");
        model.addAttribute("th_id","1001");
        model.addAttribute("th_name","lemon");
        model.addAttribute("th_value","22");
        model.addAttribute("th_class","nav");
        model.addAttribute("th_href","http://www.itczheng.online");
        return "attributes";
    }

    @GetMapping("/simple")
    public String simple(ModelMap modelMap) {
        modelMap.addAttribute("number1",2019);
        modelMap.addAttribute("number2",3);
        modelMap.addAttribute("thymeleafText","shiyanlou");
        return "simple";
    }

    @GetMapping("/test")
    public String test(ModelMap modelMap) {
        modelMap.put("title","Thymeleaf复杂语法测试");
        modelMap.put("testString","String Boot");
        modelMap.put("testArray",new Integer[]{1,2,3,4,5});
        modelMap.put("testList", Arrays.asList("Spring Boot","Java","Mybatis"));
        Map testMap = new HashMap();
        testMap.put("keyA","Spring");
        testMap.put("title","Spring Boot");
        testMap.put("keyC","czh");
        modelMap.put("testMap",testMap);
        modelMap.put("testDate",new Date());
        return "test";
    }
}
