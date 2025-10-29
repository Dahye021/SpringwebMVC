package com.ssg.springwebmvc.controller;

import com.ssg.springwebmvc.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Log4j2
@Controller //해당 클래스가 스프링mvc에서 컨트롤러 역할을 함 -> spring의 bean으로 등록
public class SampleController {
    //    front controller가 자동으로 매핑해줌
    @GetMapping("/hello") //doGet method를 의미
    public void hello(){
        log.info("hello");
    }

    @GetMapping("/ex01")
    public void ex01(String name, int age){
        log.info("ex01에서 수집한 파라미터");
        log.info("name: "+ name);
        log.info("age: "+ age);
    }

    @GetMapping("/ex02")
    //서버 오류 방지 위해 기본값 설정
    public void ex02(@RequestParam(name="name", defaultValue ="lalala") String name,
                     @RequestParam(name = "age", defaultValue = "10") int age){
        log.info("ex02에서 수집한 파라미터");
        log.info("name: "+ name);
        log.info("age: "+ age);
    }

    @GetMapping("/ex03")
    //그냥 객체로 들어가면 400 에러가 남
    public void ex03(LocalDate dueDate){
        log.info("ex03에서 수집한 파라미터");
        log.info("dueDate: "+ dueDate);
        //이때 필터 처리함
    }

    @GetMapping("/ex04")
    //Model은 controller간, 또는 view로 전송할 때 쓰는 객체
    public void ex04(Model model) {
        log.info("ex04에서 수집한 파라미터");
        model.addAttribute("message", "Hello Spring MVC!");
        //이때 필터 처리함
    }

    @GetMapping("/ex05")
    public String ex05(RedirectAttributes redirectAttributes) {
        log.info("ex05에서 수집한 파라미터");
        redirectAttributes.addAttribute("name", "ABCDEFG");
        redirectAttributes.addFlashAttribute("result", "success");
        return "redirect:/ex06";
    }

    @GetMapping("/ex06")
    public void ex06() {}

    @GetMapping("/ex07")
    public void ex07(int m1, String m2) {
        log.info("m1: " + m1);
        log.info("m2: " + m2);
    }
}