package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름 조회")
    public void findBeanByNames () throws Exception {
        //given
        Object memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

        //when

        //then
     }

     @Test
     @DisplayName("이름 없이 타입으로만 조회")
     public void findBeanByType() throws Exception {
         //given
         Object memberService = ac.getBean(MemberService.class);
         assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
         //when

         //then
//         Assertions.assertThat();
      }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    public void findBeanByName2() throws Exception {
        //given
        Object memberService = ac.getBean("memberService",MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
        //when

        //then
//         Assertions.assertThat();
      }

      @Test
      @DisplayName("빈 이름으로 조회X")
      public void findBeanByNameX () throws Exception {
          //given
          //ac.getBean("xxxx", MemberService.class);
//          ac.getBean("xxxx", MemberService.class);
          //when

          //then
//          Assertions.assertThat();
          assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean("xxxx", MemberService.class));
       }





}
