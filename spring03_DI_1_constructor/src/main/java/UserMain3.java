import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.UserService3;

public class UserMain3 {

	public static void main(String[] args) {
		// IoC Container 생성
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/config/user3.xml"); // GenericXmlApplicationContext와 동일
		
		UserService3 service = ctx.getBean("service",UserService3.class);

		List<String> list = service.list();
		System.out.println(list);
		System.out.println(service.num);
	}

}
