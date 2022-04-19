package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
	public MemberService memberService() {
		return new MemberServiceImpl(MemoryMemberRepository());
	}
	
	//중복 리팩토링
	private MemberRepository MemoryMemberRepository() {
		return new MemoryMemberRepository();
	}

	public OrderService orderService() {
		return new OrderServiceImpl(MemoryMemberRepository(), discountPolicy());
	}
	
	//리팩토링 (기능 분리 구현, 명확한 명명, 호출)
	public DiscountPolicy discountPolicy() {
		return new FixDiscountPolicy();
	}
	
	
}
