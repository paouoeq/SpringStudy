import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.dao.UserDAO;
import com.service.UserService;

public class UserMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("com/config/user.xml");
		
		// user.xml에 등록된 bean태그의 id값을 이용해서 빈을 참조한다.
		
		// 클래스명 변수명 = (클래스명)ctx.getBean("id값");
//		UserDAO userdao = (UserDAO)ctx.getBean("yyy");
		
		// 클래스명 변수명 = ctx.getBean("xml의 id값", 클래스명.class);
		UserDAO userDAO = ctx.getBean("yyy", UserDAO.class);
		
		UserService userService = ctx.getBean("xxx", UserService.class);
		
		// 메서드 호출
		System.out.println(userDAO.sayHello());
		System.out.println(userService.mesg());
	}

}
