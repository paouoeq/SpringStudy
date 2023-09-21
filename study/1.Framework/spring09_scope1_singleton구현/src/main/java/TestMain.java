
// 자바의 싱글톤 패턴 구현(singleton design pattern)
// => UserService를 한번만 생성하게끔 구현해야함.
class UserService {
	
	// 싱글톤 패턴 구현 4 : service를 private static 변수로 생성
	private static UserService service;
	
	// 싱글톤 패턴 구현 1 : 생성자를 private로 지정
	private UserService() {
		
	}
	
	// 싱글톤 패턴 구현 2 : private이기 때문에 자기 자신의 메서드에서 생성
	// 싱글톤 패턴 구현 3 : 외부에서 생성하지 않고 호출하는 방법 - static 메서드로 지정
	public static UserService getInstance() {
		// 싱글톤 패턴 구현 4 : 변수가 null 일때만 new 하도록 만듦
		if(service == null) {
			service = new UserService();
		} 
		return service;
	}
}

public class TestMain {
	public static void main(String[] args) {
		
		UserService s1 = UserService.getInstance();
		UserService s2 = UserService.getInstance();
		UserService s3 = UserService.getInstance();
		/* 생성하려면 new 사용해야함 -> new를 쓰면 생성자가 호출됨 
		 * -> new를 두번 이상 쓸 수 있는 건 생성자의 접근지정자가 public이기 때문
		 * -> private를 쓰면 new 방지 가능 -> 하지만 하나도 생성하지 못하게 됨
		 * => 따라서 자기가 자신을 생성하도록 만듦
		 */
		
		System.out.println(s1 == s2); // true => 주소값이 같다.
		System.out.println(s2 == s3); // true => 주소값이 같다.
		System.out.println(s3 == s1); // true => 주소값이 같다.
		// 따라서 UserService를 세번 생성한 것처럼 보이지만, 한번만 생성된 것이다.
	}
}
