package com.cos.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.demo.model.Member;
import com.cos.demo.repository.MemberRepository;

@Controller
public class MyBatisController {

	@Autowired
	private MemberRepository memberRepository;
	
	// http://localhost:8000/demo/member/2
	@GetMapping("/member/{id}")
	public @ResponseBody Member findById(@PathVariable int id) {
		Member member = memberRepository.findById(id);
		return member;
	}
	
	// http://localhost:8000/demo/member
	@GetMapping("/member")
	public @ResponseBody List<Member> findAll() {
		List<Member> members = memberRepository.findAll();
		return members;
	}
}
