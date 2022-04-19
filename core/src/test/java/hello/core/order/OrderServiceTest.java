package hello.core.order;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

public class OrderServiceTest {

	MemberService mService;
	OrderService oService;
	
	@BeforeEach
	public void beforeEach() {
		AppConfig appConfig = new AppConfig();
		mService = appConfig.memberService();
		oService = appConfig.orderService();
	}
	
	
	@Test 
	void createOrder() {
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		mService.join(member);
		
		Order order = oService.createOrder(memberId, "itemA", 10000);
	
		Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}
	
}
