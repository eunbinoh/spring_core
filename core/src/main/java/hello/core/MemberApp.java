package hello.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;


/*
 * 2022.04.07 프로젝트 시작
 * auth by eunbi
 * */

public class MemberApp {
	
	public static void main(String[] args) {
//		AppConfig appConfig = new AppConfig();
//		MemberService memberService = appConfig.memberService();
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = appContext.getBean("memberService", MemberService.class);
		
		
		Member member = new Member(1L, "memberA", Grade.VIP);
		memberService.join(member);
		
		Member findMember = memberService.findMember(1L);
		System.out.println("new member = " + member.getName());
		System.out.println("find member = " + findMember.getName());
	}
	
}
