package com.example.hello.repository;

import java.util.*;

import com.example.hello.domain.Member;

public interface MemberRepository{
	// 회언 가입
	Member save(Member member); // 회원 저장하면 저장된 회원 반환
	
	// 회원 조회
	Optional<Member> findById(Long id); // ID로 회원 조회
	Optional<Member> findByName(String name); // 이름으로 회원 조회
	
	List<Member> findAll(); // 전체 회원 조회

	public void clearStore();
}
