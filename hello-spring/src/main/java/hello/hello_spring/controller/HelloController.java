package hello.hello_spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @GetMapping ("hello-mvc")
    public String helloMvc(@RequestParam(required = false, value="value") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
}
    @GetMapping ("hello-string")
    @ResponseBody 
    public String helloString(@RequestParam("name") String name){
        return "hello" + name; //이건 그냥 바디에 name로 받은 값을 hello와 합쳐서 그대로 넣어 출력
}

    @GetMapping("hello-api")
    @ResponseBody 
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // json 형식으로 반환됨. {"name":"value"} 이런식으로 반환됨.
    }
    
    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    
}


