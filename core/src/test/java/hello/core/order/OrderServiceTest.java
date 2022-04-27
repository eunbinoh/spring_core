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
	 * IoC ������ ����
	 * �������� Ŭ���̾�Ʈ ������ü�� ������ �ʿ��� ��ü ����, ����, �����ߴ�.
	 *  ( ������ü�� ���α׷��� �����帧�� �����ߴ� )
	 * �׷���, AppConfig�� ��������, ������ü�� �ڽ��� ������ �����ϴ� ���Ҹ� �Ѵ�.
	 * AppConfig�� ���α׷��� ���� �����帧�� ��� ������ ���´�.
	 * 
	 * -> ���α׷��� ���� �帧�� ���� �����ϴ� ���� �ƴ϶�, �ܺο��� �����ϴ� ����
	 *    ������ ���� (Inversion of Control) �̶�� �Ѵ�.
	 *
	 * */
	
	/**
	 * �����ӿ�ũ vs ���̺귯��
	 * �����ӿ�ũ : �����ӿ�ũ�� ���� �ۼ��� �ڵ带 ����, ���� (ex.JUnit)
	 * ���̺귯�� : ���� �ۼ��� �ڵ尡 ���� ������ �帧�� ��� (ex. xml/JSON ��ȯ ����ȣ��) 
	 * 
	 * **/
	
	/**
	 * DI �������� ����
	 * ���� Ŭ���� �������� vs ���� ��ü(��������� �����Ǵ� �ν��Ͻ�) ��������
	 * ���� Ŭ���� : Ŭ������ ����ϴ� import �ڵ常 ���� �������� �Ǵ� ����
	 *  (�������� �ʾƵ�, Ŭ���� ���̾�׷��� ���� ���� �м� ����)
	 * ������, �̷� Ŭ���� �������踸���δ� ���� � ��ü�� service�� ���Ե��� �� ������.
	 * ���� ��ü �ν��Ͻ� : ��������� ���� ������ ��ü �ν��Ͻ��� ������ ����� ��������
	 * 
	 * -> ���ø����̼� �������(��Ÿ��)�� �ܺο��� ���� ���� ��ü�� ����, Ŭ���̾�Ʈ �����ؼ�
	 *    Ŭ���̾�Ʈ�� ������ ���� �������谡 ����Ǵ� ���� "�������� ����"�̶�� �Ѵ�.
	 * -  ��ü �ν��Ͻ��� ����, ������ �����ؼ� ����
	 * -  Ŭ���̾�Ʈ �ڵ� �������� �ʰ�, ȣ���ϴ� ����� Ÿ�� �ν��Ͻ� ���� ����
	 * -  ���� Ŭ���� �������踦 �������� �ʰ�, ���� ��ü �ν��Ͻ� �������� ���� ����   
	 * 
	 * **/
	
	/**
	 * ���� ���� ��� : DI�����̳�, �����(�����ڿ���), ������Ʈ ���丮
	 */
	
	
	
	
	
}
