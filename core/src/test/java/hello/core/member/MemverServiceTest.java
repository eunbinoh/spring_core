package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemverServiceTest {

	MemberService service = new MemberServiceImpl();
		
	@Test
	void join () {
		//given
		Member member = new Member(1L, "memberA", Grade.VIP);
		
		//when
		service.join(member);
		Member findMember = service.findMember(1L);
		
		//then
		Assertions.assertThat(member).isEqualTo(findMember);
	}

	
}
