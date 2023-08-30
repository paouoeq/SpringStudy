import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.dto.Cat;
import com.dto.Person;

public class TestMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/config/user.xml");
		
		
		System.out.println("1. 전체 Cat 목록");
		Person p = ctx.getBean("p1",Person.class);
		List<Cat> list = p.getCatList();
		for(Cat c : list) {
			System.out.println(c);
		}
		
		System.out.println("2. 특정 위치 Cat 출력");
		Person p2 = ctx.getBean("p2",Person.class);
		List<Cat> list2 = p2.getCatList();
		for(Cat c : list2) {
			System.out.println(c);
		}
		
		System.out.println("3. age < 10 Cat 출력");
		Person p3 = ctx.getBean("p3",Person.class);
		List<Cat> list3 = p3.getCatList();
		for(Cat c : list3) {
			System.out.println(c);
		}
		
		System.out.println("4. age < 10 and married==false Cat 출력");
		Person p4 = ctx.getBean("p4",Person.class);
		List<Cat> list4 = p4.getCatList();
		for(Cat c : list4) {
			System.out.println(c);
		}

	}

}