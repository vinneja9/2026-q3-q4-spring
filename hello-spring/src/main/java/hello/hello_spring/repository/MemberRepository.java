package hello.hello_spring.repository;

import java.util.List;
import java.util.Optional;

import hello.hello_spring.domain.Member;

public interface MemberRepository {
    Member save(Member member); //저장소에 저장
    Optional<Member> findById(Long id); //id로 찾기
    Optional<Member> findByName(String name); //이름으로 찾기
    List<Member> findAll(); //모든 저장된 회원 뱉기
    public void clearStore();
}
