import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.UserService2;

public class UserMain2 {

	public static void main(String[] args) {
		// IoC Container 생성
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/config/user2.xml"); // GenericXmlApplicationContext와 동일
		
		// 빈 얻기
		UserService2 service = ctx.getBean("service", UserService2.class);
		System.out.println(service.getNum()); // 20
		System.out.println(service.getUsername()); // 이순신
	}

}
