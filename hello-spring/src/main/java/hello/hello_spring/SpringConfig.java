package hello.hello_spring;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hello_spring.repository.JpaMemberRepository;
import hello.hello_spring.repository.MemberRepository;

import hello.hello_spring.service.MemberService;
import jakarta.persistence.EntityManager;

@Configuration 
public class SpringConfig {

    private final MemberRepository memberRepository;
    @Autowired 
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
//    Bean
//    public MemberRepository memberRepository() {
//        //return new MemoryMemberRepository();
//        return new JpaMemberRepository(em);
//    }
}
