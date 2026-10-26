package hello.hello_spring.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import hello.hello_spring.domain.Member;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; //고유 id 생성하는거임. 0~...



    @Override
    public Member save(Member member) {
        member.setId(++sequence); //id를 1씩 증가시키면서 넣어줌
        store.put(member.getId(), member); //store에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //그냥 store.get(id)하면 null이 반환될 수 있으므로 Optional로 감싸서 반환
    }

    @Override   
    public Optional<Member> findByName(String name) {
        return store.values().stream() //store.values(): 맵에 있는 Member목록 다 꺼내기 | .stream(): 목록을 하나씩 처리하기
                .filter(member -> member.getName().equals(name)) // .filter(member -> member.getName().equals(name)): member.getName()이 name과 같은지 확인해서 같은건 필터하기
                .findFirst(); // .findFirst(): 1등으로 필터 한거 뱉기
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //뱉는 형태가 List라서 Map의 values를 모아둔 list를 만들어 뱉기
    }

    public void clearStore() {
        store.clear();
    }

}
