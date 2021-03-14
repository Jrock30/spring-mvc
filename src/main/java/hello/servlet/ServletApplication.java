package hello.servlet;

import hello.servlet.web.springmvc.v1.SpringMemberFormControllerV1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ServletComponentScan // 스프링이 자동으로 서블릿을 등록해주고 실행을 도와주는
@SpringBootApplication
public class ServletApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServletApplication.class, args);
    }

    // 스프링부트가 해줌 properties 에서
//    @Bean
//    ViewResolver internalResourceViewResolver() {
//        return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
//    }

    // @Component 내지는 @Controller 쓰지 않고 @RequestMapping 만 사용하고 이렇게 빈 등록 해도 된다.
//    @Bean
//    SpringMemberFormControllerV1 springMemberFormControllerV1() {
//        return new SpringMemberFormControllerV1();
//    }
}
