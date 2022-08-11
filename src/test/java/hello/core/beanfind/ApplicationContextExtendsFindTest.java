package hello.core.beanfind;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscoutnPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ApplicationContextExtendsFindTest {





    @Test
    @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면, 중복 오류가 발생한다" )
    public void findBeanByParentTypeDuplicate() throws Exception {
        //given
        DiscountPolicy bean = ac.getBean(DiscountPolicy.class);
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(DiscountPolicy.class));
        //when

        //then
//        Assertions.assertThat();
     }


     AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
     @Configuration
    static class TestConfig {
        @Bean
         public DiscountPolicy rateDiscount() {
            return new RateDiscoutnPolicy();
        }
        @Bean
         public DiscountPolicy fixDiscountPolicy() {
            return new FixDiscountPolicy();
         }
     }
}
