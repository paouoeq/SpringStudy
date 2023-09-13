import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.dto.DeptDTO;
import com.service.DeptService;

public class DeptMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/config/spring_config.xml");
		
		DeptService service = ctx.getBean("deptService", DeptService.class); // id 대신 어노테이션에 정한 이름 넣어주기
		
		// 트랜잭션 실습
		try { // Mapper에서 일부러 delete 실패하도록 오류 구문을 넣음, 예외 발생으로 중단되지 않도록 try~catch 구문 사용
			int n = service.tx(); 
			// 3번 저장, 91번 삭제 
			// 3번은 저장이 되었지만, 91번은 삭제되지 않음 => 트랜잭션으로 묶이지 않음
			// 하지만 @@Transactional 마킹과 함께 spring_config.xml에 이 어노테이션을 처리하면
			// => 4번을 저장하고 91번을 삭제하려고 할 때, 91번에서 오류가 발생하였기 때문에
			//    저장도 삭제도 되지 않고 rollback 시킨다.
		}catch(Exception e) {
			System.out.println("예외발생");
		}
		
		// 목록
		List<DeptDTO> list = service.deptList();
		for(DeptDTO dto : list) {
			System.out.println(dto);
		}
		
		
	}

}
