package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
	private int discountPrice = 1000; // 1000¿ø ÇÒÀÎ

	@Override
	public int discount(Member member, int price) {

		if(member.getGrade() == Grade.VIP) {
			return discountPrice;
		} else {
			return 0;
		}
		
	}

}
