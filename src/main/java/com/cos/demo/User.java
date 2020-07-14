package com.cos.demo;

import lombok.Data;

// model의 클래스들은 성질상 @Component 어노테이션과 맞지 않는다.
// @Component가 달린 클래스 객체는 Singleton으로 생성되어 관리되는데 비해,
// model 패키지의 모델 클래스들은 List<User>와 같은 형태로 사용되는 경우가 흔한데
// 이 경우 Singleton 객체여서는 곤란하기 때문
@Data
public class User {
	private String username;
	private String password;
	private String email;
}
