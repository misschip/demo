package com.cos.demo.repository;



import java.util.List;

import com.cos.demo.model.Member;

// 이 위치에 @Repository 어노테이션이 없어도 되는 이유 : DataAccessConfig.java에 @MapperScan(basePackages = "com.cos.demo.repository") 가 있기 때문
public interface MemberRepository {
	public Member findById(int id);
	public List<Member> findAll();
}
