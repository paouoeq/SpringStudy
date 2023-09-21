import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.UserService;

public class UserMain {

	public static void main(String[] args) {
		// IoC Container 생성
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/config/user.xml"); // GenericXmlApplicationContext와 동일
		
		// 빈 얻기
		UserService service = ctx.getBean("service", UserService.class);
		System.out.println(service.getNum()); // 20
		System.out.println(service.getUsername()); // 이순신
		List<String> list = service.list();
		System.out.println(list); // [홍길동, 이순신]
	}

}
