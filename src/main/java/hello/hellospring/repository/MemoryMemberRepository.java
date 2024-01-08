package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence); //시스템이 정해주는 아이디 : 현재 시퀀스 숫자로 지
        store.put(member.getId(), member); //DB 사용하지 않으므로 일단 map에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //null일 경우라도 반환할 수 있도록 해주는 것
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
