import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {


//		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/config/user.xml");
		MessageSource ctx = new GenericXmlApplicationContext("classpath:com/config/user.xml");
		
		// 리소스 번들(resource bundel)에서 메시지 얻기
		// String mesg = ctx.getMessage([properties 키값], [.java에서 properties로 전달할 값(String배열)], [일치하는 키값이 없을 때의 기본값], [지역명시-Locale 사용]);
		String mesg = ctx.getMessage("greeting", null, null, Locale.KOREAN);
		String mesg2 = ctx.getMessage("greeting", null, null, Locale.ENGLISH);
		System.out.println(mesg); // 안녕하세요
		System.out.println(mesg2); // hello
		
		String mesg3 = ctx.getMessage("greeting2", new String[]{"홍길동","감사합니다."}, null, Locale.ENGLISH);
		System.out.println(mesg3);
		mesg3 = ctx.getMessage("greeting2", new String[]{"이순신","고맙습니다."}, null, Locale.ENGLISH);
		System.out.println(mesg3);
		
	}

}
