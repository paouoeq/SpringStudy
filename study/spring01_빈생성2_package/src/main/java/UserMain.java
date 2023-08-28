import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.service.UserService;

public class UserMain {

	public static void main(String[] args) {
		
		// 1. 스프링 쓰지 않는 이전 방식
//		UserService service = new UserService();
//		System.out.println(service.mesg());
		
		// 2. 스프링 방식
		/*
		 	- 작업 순서
		 	1. 빈을 생성 (*.java) => UserService.java
			2. 빈을 xml에 등록 => src/main/resoure에 저장 => user.xml
			3. ApplicationContext(빈)에 xml을 알려준다.
			4. ApplicationContext(빈)가 xml에 등록된 빈 정보를 보고 자동 생성~소멸 처리한다.
		 */
		
		// ApplicationContext는 인터페이스 -> 바로 new 불가능 -> 따라서 GenericXmlApplicationContext를 new한다.
		// xml이 패키지 안에 있다면 패키지 경로까지 명시해줘야 한다.
		ApplicationContext ctx = new GenericXmlApplicationContext("com/config/user.xml"); // 작업순서 3번째
		
	}

}
