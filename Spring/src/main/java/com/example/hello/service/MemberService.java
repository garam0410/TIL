package com.example.hello.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hello.domain.Member;
import com.example.hello.repository.MemberRepository;

public class MemberService {
	// 서비스 작성에는 Repository 필요
	private final MemberRepository memberRepository;
	
	// Repository를 직접 생성하지 않고, 외부에서 넣어주도록 구현
	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	// 회원 가입
	public Long join(Member member) {
		// 중복 회원 검증
		validateDuplicateMember(member);
		
		memberRepository.save(member);
		return member.getId();
	}
	
	//중복 회원 검증
	private void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName())
		.ifPresent(user -> {
			throw new IllegalStateException("이미 존재하는 회원");
		});
	}
	
	// 전체 회원 조회
	public List<Member> findMembers(){
		return memberRepository.findAll();
	}
	
	// 특정 회원 조회
	
	public Optional<Member> findOne(Long memberId){
		return memberRepository.findById(memberId);
	}
}
