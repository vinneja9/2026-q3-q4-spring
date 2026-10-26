package hello.hello_spring.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import hello.hello_spring.domain.Member;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();


    @AfterEach
    public void afterEach() {
        repository.clearStore(); //테스트 끝날때마다 저장소 비우기
    } 

    @Test 
    public void save() {
        //given
        Member member = new Member();
        member.setName("spring");
        //when
        repository.save(member);
        //then
        Member result = repository.findById(member.getId()).get();
        System.out.println("result = " + (result == member));
        Assertions.assertThat(member).isEqualTo(result);

    }

    @Test 
    public void findByName() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        Member member2 = new Member();
        member2.setName("spring2");
        
        //when
        repository.save(member1);
        repository.save(member2);

        ///then
        Member result = repository.findByName("spring1").get();
        Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test 
    public void findAll() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        Member member2 = new Member();
        member2.setName("spring2");
        
        //when  
        repository.save(member1);
        repository.save(member2);
        
        //then
        Assertions.assertThat(repository.findAll().size()).isEqualTo(2);
    }
}
