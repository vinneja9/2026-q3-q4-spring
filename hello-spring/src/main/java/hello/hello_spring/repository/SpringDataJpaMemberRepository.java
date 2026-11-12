package hello.hello_spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hello.hello_spring.domain.Member;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    
    Optional<Member> findByName(String name);
    Optional<Member> findById(long id);
    Member save(Member member);
    List<Member> findAll();
}
