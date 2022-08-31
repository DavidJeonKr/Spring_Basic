package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {
    @Test
    @DisplayName("스프링")
    public void pureContainer () throws Exception {
        //given
        AppConfig appConfig = new AppConfig();
        //1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();
        //2. 조회 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();
        //when
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
        //then
        // memberService1 != memberService2
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);

     }

     @Test
     @DisplayName("싱글톤 패턴을 적용한 객체 사용")
     public void singletonServiceTest () throws Exception {
         //given
         SingletonService singletonService1 = SingletonService.getInstance();
         SingletonService singletonService2 = SingletonService.getInstance();

//         SingletonService.getInstance().logic();
         //when
         System.out.println("singletonService1 = " + singletonService1);
         System.out.println("singletonService2 = " + singletonService2);
         //then
        Assertions.assertThat(singletonService1).isSameAs(singletonService2);
      }
}
