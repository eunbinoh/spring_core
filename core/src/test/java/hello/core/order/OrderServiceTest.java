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
	
	/**
	 * IoC 제어의 역전
	 * 기존에는 클라이언트 구현객체가 스스로 필요한 객체 생성, 연결, 실행했다.
	 *  ( 구현객체가 프로그램의 제어흐름을 조종했다 )
	 * 그런데, AppConfig의 등장으로, 구현객체는 자신의 로직을 실행하는 역할만 한다.
	 * AppConfig가 프로그램에 대한 제어흐름의 모든 권한을 갖는다.
	 * 
	 * -> 프로그램의 제어 흐름을 직접 제어하는 것이 아니라, 외부에서 관리하는 것을
	 *    제어의 역전 (Inversion of Control) 이라고 한다.
	 *
	 * */
	
	/**
	 * 프레임워크 vs 라이브러리
	 * 프레임워크 : 프레임워크가 내가 작성한 코드를 제어, 실행 (ex.JUnit)
	 * 라이브러리 : 내가 작성한 코드가 직접 제어의 흐름을 담당 (ex. xml/JSON 변환 직접호출) 
	 * 
	 * **/
	
	/**
	 * DI 의존관계 주입
	 * 정적 클래스 의존관계 vs 동적 객체(실행시점에 결정되는 인스턴스) 의존관계
	 * 정적 클래스 : 클래스가 사용하는 import 코드만 보고도 의존관계 판단 가능
	 *  (실행하지 않아도, 클래스 다이어그램만 봐도 쉽게 분석 가능)
	 * 하지만, 이런 클래스 의존관계만으로는 실제 어떤 객체가 service에 주입될지 알 수없다.
	 * 동적 객체 인스턴스 : 실행시점에 실제 생성된 객체 인스턴스의 참조가 연결된 의존관계
	 * 
	 * -> 애플리케이션 실행시점(런타임)에 외부에서 실제 구현 객체를 생성, 클라이언트 전달해서
	 *    클라이언트와 서버의 실제 의존관계가 연결되는 것을 "의존관계 주입"이라고 한다.
	 * -  객체 인스턴스를 생성, 참조값 전달해서 연결
	 * -  클라이언트 코드 변경하지 않고, 호출하는 대상의 타입 인스턴스 변경 가능
	 * -  정적 클래스 의존관계를 변경하지 않고, 동적 객체 인스턴스 의존관계 변경 가능   
	 * 
	 * **/
	
	/**
	 * 유사 개념 용어 : DI컨테이너, 어샘블러(조립자역할), 오브젝트 팩토리
	 */
	
	
	
	
	
}
