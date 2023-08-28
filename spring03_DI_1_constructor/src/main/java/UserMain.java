import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.UserService;

public class UserMain {

	public static void main(String[] args) {
		// IoC Container 생성
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/config/user.xml"); // GenericXmlApplicationContext와 동일
		
		// 빈 얻기
		UserService xxx = ctx.getBean("xxx", UserService.class);
		System.out.println(xxx.getNum()); // 0
		
		UserService yyy = ctx.getBean("yyy", UserService.class);
		System.out.println(yyy.getNum()); // 10
	}

}
