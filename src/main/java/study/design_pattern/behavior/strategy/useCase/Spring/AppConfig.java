package study.design_pattern.behavior.strategy.useCase.Spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig MemberService");
        return new MemberServiceImpl();
    }
}
