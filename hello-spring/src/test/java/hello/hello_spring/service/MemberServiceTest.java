package hello.hello_spring.service;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemoryMemberRepository;

public class MemberServiceTest {
    
/*
MemoryMemberRepository memberRepository= new MemoryMemberRepository();
MemberService memberService= new MemberService(memberRepository);
*/



    MemoryMemberRepository memberRepository;
    MemberService memberService;
    
    @BeforeEach 
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    
    
    @AfterEach 
    public void afterEach() {
        memberRepository.clearStore(); //테스트 끝날때마다 저장소 비우기
    } 
    
    
    @Test
    void testFindMembers() {
        //given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring2");
        //when
        memberRepository.save(member1);
        memberRepository.save(member2);
        //then
        List<Member> members = memberService.findMembers();
        Assertions.assertThat(members.size()).isEqualTo(2);
    }

    @Test
    void testFindOne() {

    }

    @Test
    void testJoin() { 
        //given
        Member member= new Member();
        member.setName("spring");


        //when
        Long memberId = memberService.join(member);
        //then
        Assertions.assertThat(member.getId()).isEqualTo(memberId);
    }

    @Test   
    void testJoinDuplicateMember() {
        //given
        Member member1 = new Member();
        member1.setName("spring");
        
        Member member2 = new Member();
        member2.setName("spring");
        
        //when
        memberService.join(member1);
        
        //then
        Assertions.assertThatThrownBy(() -> memberService.join(member2))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("이미 존재하는 회원입니다.");
        /* 정확히 위 아래가 같은 코드임.
        try {
            memberService.join(member2); 
            fail("예외가 발생해야 하는데 발생하지 않았습니다.");
        } catch (Throwable e) {
            Assertions.assertThat(e).isInstanceOf(IllegalStateException.class); 
            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다."); 
        }*/ 


        
    }
}
