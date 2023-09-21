import org.springframework.context.support.GenericXmlApplicationContext;

import com.service.UserService;

public class TestMain {

	public static void main(String[] args) {

		//xml을 ctx 생성시 넣어주지 않음
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		
		// profile 결정
		ctx.getEnvironment().setActiveProfiles("dev"); // setActiveProfiles : profile 결정하는 메서드
		
		// xml 등록 => 두 xml 로드 후 로드 된 것 중에서 지정한 profile에 맞는 것이 실행됨
		ctx.load("classpath:com/config/user_dev.xml", "classpath:com/config/user_prod.xml");
		ctx.refresh();
		
		// 빈 얻기(다형성)
		UserService service = ctx.getBean("service",UserService.class);
		System.out.println(service.mseg());
	}

}
