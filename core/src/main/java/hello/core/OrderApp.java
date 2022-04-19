package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {
	public static void main(String[] args) {
		AppConfig appConfig = new AppConfig();
		
		MemberService mService = appConfig.memberService(); 
		OrderService oService = appConfig.orderService();
		
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA"	, Grade.VIP);
		mService.join(member);
		
		Order order = oService.createOrder(memberId, "itemA", 10000);
		
		System.out.println("order = " + order.toString());
		System.out.println("calculate price = " + order.calculatePrice());
	}
}