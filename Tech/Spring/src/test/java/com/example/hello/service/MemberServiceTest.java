package com.example.hello.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.hello.domain.Member;
import com.example.hello.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberServiceTest {
	 // 리포지토리를 인자에 넣어줌
    MemberService memberService;
    // clear 해주기 위해 리포지토리 멤버변수 생성
    MemoryMemberRepository memberRepository;
 
    // 각 테스트를 실행하기 전에 리포지토리를 만들고, 서비스를 생성할때 인자로 사용합니다.
    // 그러면, 같은 리포지토리를 사용하게 됩니다.
    @BeforeEach
    public void beforeEach(){
        memberRepository  = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
 
    @AfterEach
    // 동작이 끝날때마다 어떤 처리를 해줍니다. (콜백 메소드)
    public void afterEach() {
        memberRepository.clearStore();
    }
 
    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("user1");
        // when
        Long saveId = memberService.join(member);
 
        // then
        Member findMember = memberService.findOne(saveId).get();
 
        // add static import (블럭잡고 전구 클릭)
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
 
    @Test
    public void 중복_회원_예외(){
        // given
        Member member1 = new Member();
        member1.setName("spring1");
 
        Member member2 = new Member();
        member2.setName("spring1");
 
        // when
        memberService.join(member1);
 
        /*
        try{
            memberService.join(member2);
            fail();
        }catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }*/

        // assertThrows(기대하는 예외, 로직)
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        // then
    }
    @Test
    void findMembers() {
    }
 
    @Test
    void findOne() {
    }
}