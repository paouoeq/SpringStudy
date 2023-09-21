import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.service.UserService;

public class UserMain {

	public static void main(String[] args) {
		
		// ApplicationContext는 인터페이스 -> 바로 new 불가능 -> 따라서 GenericXmlApplicationContext를 new한다.
		// xml이 패키지 안에 있다면 패키지 경로까지 명시해줘야 한다.
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/config/user.xml", "file:c:\\spring_study\\user2.xml");
		// 외부 파일에서 xml을 가져올 경우 프리픽스 필수로 달아줘야 한다.-> file:
		// src 경로에도 일반적으로 생략되어 사용하지만 사실 프리픽스가 있음 -> classpath:
	}

}
