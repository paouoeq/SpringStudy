import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.service.UserService;

public class TestMain {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/config/user.xml");
		
		// singleton은 하나의 인스턴스로 여러 사용자가 사용하기 때문에 자원이 공유된다.
		UserService s1 = ctx.getBean("service", UserService.class);
		UserService s2 = ctx.getBean("service", UserService.class);
		
		System.out.println("singleton : " + (s1==s2)); 
		// true => 싱글톤이기 때문에 빈 하나만 생성 -> s1과 s2의 주소값이 동일함
		
		s1.username = "홍길동";
		s2.username = "이순신";
		
		System.out.println(s1.username + "\t" + s2.username); 
		// 이순신	이순신  => 싱글톤이기에 나중에 입력된 값이 저장되어 있음.
		// => 나만의 정보 저장 불가능
		
		// prototype은 사용자간 자원 공유를 하지 않는다.
		UserService s3 = ctx.getBean("service2", UserService.class);
		UserService s4 = ctx.getBean("service2", UserService.class);
		
		System.out.println("prototype : " + (s3==s4));  // false => 매번 새롭게 생성됨
		
		s3.username = "홍길동";
		s4.username = "이순신";
		
		System.out.println(s3.username + "\t" + s4.username); 
		// 홍길동	이순신 => prototype은 매번 새로 생성되어 다른 저장공간을 가지고 있음.
		// => 나만의 정보 저장 가능
	}
}
