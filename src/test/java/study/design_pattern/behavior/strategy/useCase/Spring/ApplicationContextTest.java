package study.design_pattern.behavior.strategy.useCase.Spring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.*;

class ApplicationContextTest {

    /**
     * ApplicatoinContext : SpringContainer -> BeanFactory 인터페이스의 하위 인터페이스
     *                      BeanFactory + 추가 기능( 국제화, 환경변수 ,리소스 조회, 애플리케이션 이벤트 등)
     *                      다양한 구현체를 가짐 (@Configuration,@Bean Annotation 기반 / XML기반 등..
     *                      다양한 방법으로 스프링 컨테이너 생성)
     *
     *                      ==> 다양한 방식으로 beanDefinition을 추상화 하여 Bean 등록( XML, Annotation.. 등)
     *
     *                      (BEAN은 스프링 컨테이너 내부에 bean저장소에 <bean이름,bean> K,V 로 저장
     *                      스프링 컨테이너가 bean을 싱글통르로 관리(= 싱글톤 컨테이너)
     *
     *                      스프링 부트를 동작시킬때 SpringApplication 내부를 보면
     *                      SpringApplication 인스턴스를 생성할때 ResourceLoader를 통해 주입받는다.
     *
     *                      ResourceLoader 인터페이스 설명을 보면 Strateg Interface로 전략패턴을 사용함을 알 수 있고,
     *                      예시와 함께 클래스 패스, 혹은 파일시스템자원을 로딩하기 위한 인터페이스 있고,
     *
     *                      Bean properties of type Resource and Resource[] can be
     *                      populated from Strings when running in an ApplicationContext,
     *                      using the particular context's resource loading strategy.
     *
     *                      특정 컨텍스트의 리소스 로딩 전략을 활용해 ApplicationContext가 동작할때 문자열로 된
     *                      다양한 리소스들을 bean 객체로 발행해준다.
     *
     *
     * */

    @Test
    @DisplayName("annotation 기반 appcliationContext 생성")
    void applicationContextFromAnnotation() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }

        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    @DisplayName("xml 기반 appcliationContext 생성")
    void applicationContextFromXml() {
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}