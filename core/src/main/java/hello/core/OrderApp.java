package hello.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;

public class OrderApp {
	public static void main(String[] args) {
//		AppConfig appConfig = new AppConfig();
//		MemberService mService = appConfig.memberService(); 
//		OrderService oService = appConfig.orderService();
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService mService = appContext.getBean("memberService", MemberService.class);
		OrderService oService = appContext.getBean("orderService",OrderService.class);
		
		
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA"	, Grade.VIP);
		mService.join(member);
		
		Order order = oService.createOrder(memberId, "itemA", 30000);
		
		System.out.println("order = " + order.toString());
		System.out.println("calculate price = " + order.calculatePrice());
	}
}