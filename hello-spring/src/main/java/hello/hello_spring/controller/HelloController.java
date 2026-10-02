package hello.hello_spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello") //링크에 hello가 들어있으면 이걸실행
    public String hello (Model model){
        model.addAttribute("data", "hello!!!!!!!!");
        return "hello"; //hello.html이라는걸 templates에서 찾아서 반환

}
    @GetMapping("hello2") //링크에 hello가 들어있으면 이걸실행
    public String hello2 (Model model){
        model.addAttribute("felt", "not fell good");
        return "hello2"; //hello2.html이라는걸 templates에서 찾아서 반환

}


}
