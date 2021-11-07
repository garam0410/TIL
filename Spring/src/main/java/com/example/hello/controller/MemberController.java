package com.example.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.hello.service.MemberService;

public class MemberController {
	private final MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
}
