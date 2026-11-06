package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class HomeController {

    @GetMapping("/") //링크에 hello가 들어있으면 이걸실행
    public String home (){
        return "home"; //home.html이라는걸 templates에서 찾아서 반환
    }
}
