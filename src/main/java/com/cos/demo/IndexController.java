package com.cos.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class IndexController {
	
	// DI (Dependency Injection) : 의존성 주입
	// 따로 new로 객체를 생성할 필요가 없음
	@Autowired
	Test t;


	// http://localhost:8080/demo
	@GetMapping({"","/"})	// demo/, demo 둘다에 대응
	public @ResponseBody String index() {
		System.out.println(t.num);

		return "Hello";	// ViewResolver
	}
	
	// x-www-form-urlencoded 타입 => key=value
	@PostMapping("/form")	
	public @ResponseBody String user(String username, String password, String email) {
		System.out.println(username);
		System.out.println(password);
		System.out.println(email);

		return "Form";	// ViewResolver
	}
	
	
	// Mime 타입이 x-www-form-urlencoded인 경우 아래처럼 받을 수 있게 된다.
	// 즉, 보내는 측에서는 username=kim&password=1234&email=kim@nate.com 으로 보내는 경우에
	// 아래와 같이 User 객체가 만들어져서 처리가 되는 것!
	@PostMapping("/form/model")	
	public @ResponseBody String formModel(User user) {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getEmail());

		return "Form";	// ViewResolver
	}
	
	
	// Mime 타입이 x-www-form-urlencoded인 경우 아래처럼 받을 수 있게 된다.
	// 즉, 보내는 측에서는 username=kim&password=1234&email=kim@nate.com 으로 보내는 경우에
	// 아래와 같이 User 객체가 만들어져서 처리가 되는 것!
	@GetMapping("/form/model")	
	public @ResponseBody String formModelGet(User user) {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getEmail());

		return "Form";	// ViewResolver
	}
	
	
	// json => {"key":값}	: get방식으로 주고받을 수는 없음. post 방식으로 body에 넣어 보내야
	// jackson 라이브러리를 사용 (AOP: 관점 지향 프로그래밍) (@RequestBody 어노테이션으로
	// jackson 바인더가 먼저 발동함. 아래 메서드 시작 직전에)
	// @RequestBody를 안 붙이면 아래에서 null값만 출력됨
	// jackson 바인더는 요청과 응답시에 각각 발동한다.
	/*
	 {
		"username":"ssar",
		"password":"1234",
		"email":"cos@nate.com"
	} 
	 */
	@PostMapping("/json/model")	
	public @ResponseBody User jsonModel(@RequestBody User user) {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getEmail());

		return user;	// ViewResolver 작동막음 => Jackson 작동
						// 응답시 기본설정은 뷰리졸버가 작동하는 것
	}
}

/*
 * 대표적 어노테이션들
 */
/*
Controller
Service
Repository
Config - 설정
Component

*/


/*
	@ResponseBody 어노테이션이 없으면 RequestDispatcher로 Hello라는 파일을 찾으려고 하게 된다
	@ResponseBody 어노테이션이 붙으면 Hello라는 데이터를 보냄. out.print("Hello");
*/