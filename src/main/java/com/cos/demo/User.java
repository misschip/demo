package com.cos.demo;

import lombok.Data;

// model의 클래스들은 성질상 @Component 어노테이션과 맞지 않는다
@Data
public class User {
	private String username;
	private String password;
	private String email;
}
