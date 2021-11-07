package com.example.hello.repository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.example.hello.domain.Member;

import java.util.List;
import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
 
    MemberRepository repository = new MemoryMemberRepository();
    
    @AfterEach // 동작이 끝날때마다 처리 수행
    public void afterEach() {
    	repository.clearStore();
    }
 
    @Test
    public void save(){
        // 멤버 저장이 되는 지 테스트
        Member member = new Member();
        member.setName("baek jiyeon");
 
        repository.save(member);

        Member result = repository.findById(member.getId()).get(); 

        System.out.println("result = " + (result == member));

        assertThat(member).isEqualTo(result);
    }
 
    @Test
    public void findByNmae(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
 
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
 
        Member result = repository.findByName("spring1").get();
 
        assertThat(result).isEqualTo(member1);
    }


    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
 
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
 
        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
 
}
