import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.dto.DeptDTO;
import com.service.DeptService;

public class DeptMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/config/spring_config.xml");
		
		DeptService service = ctx.getBean("deptService", DeptService.class); // id 대신 어노테이션에 정한 이름 넣어주기
		
		// 저장(스프링에서는 자동 commit)
//		DeptDTO xxx = new DeptDTO(13, "개발", "서울");
//		int n = service.deptAdd(xxx);
		
		// 수정(스프링에서는 자동 commit)
//		DeptDTO xxx2 = new DeptDTO(13, "개발부", "서울시");
//		int n2 = service.deptUpdate(xxx2);
		
		// 삭제(스프링에서는 자동 commit)
		int n3 = service.deptDelete(88);
		
		// 목록
		List<DeptDTO> list = service.deptList();
		for(DeptDTO dto : list) {
			System.out.println(dto);
		}
		
		
	}

}
