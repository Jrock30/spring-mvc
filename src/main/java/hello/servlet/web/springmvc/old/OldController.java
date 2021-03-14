package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  옛날 컨트롤러 방식
 *  @Component("/springmvc/old-controller") -> 스프링 빈의 이름을 url 패턴으로 맞춘 것 이다.
 *  Controller 인터페이스를 구현
 *
 *  HandlerMapping(핸들러 매핑)
 *    핸들러 매핑에서 이 컨트롤러를 찾을 수 있어야 한다.
 *    예) 스프링 빈의 이름으로 핸들러를 찾을 수 있는 핸들러 매핑이 필요하다.
 *  HandlerAdapter(핸들러 어댑터)
 *    핸들러 매핑을 통해서 찾은 핸들러를 실행할 수 있는 핸들러 어댑터가 필요하다.
 *    예) Controller 인터페이스를 실행할 수 있는 핸들러 어댑터를 찾고 실행해야 한다.
 *
 *  스프링은 이미 필요한 핸들러 매핑과 핸들러 어댑터를 대부분 구현해두었다. 개발자가 직접 핸들러 매핑과 핸들러 어댑터를 만드는 일은 거의 없다.
 *
 *  스프링 부트가 자동 등록하는 핸들러 매핑과 핸들러 어댑터
 *  (실제로는 더 많지만, 중요한 부분 위주로 설명하기 위해 일부 생략)
 *
 *  HandlerMapping
 *    - 0 = RequestMappingHandlerMapping : 애노테이션 기반의 컨트롤러인 @RequestMapping에서 사용 ( 현재는 거의 이 것을 사용 )
 *    - 1 = BeanNameUrlHandlerMapping : 스프링 빈의 이름으로 핸들러를 찾는다. ( OLD 버전 아래의 소스 )
 *  HandlerAdapter
 *    - 0 = RequestMappingHandlerAdapter : 애노테이션 기반의 컨트롤러인 @RequestMapping에서 사용 ( 현재는 거의 이 것을 사용 )
 *    - 1 = HttpRequestHandlerAdapter : HttpRequestHandler 처리 (MyHttpRequestHandler.java 아래 참조)
 *    - 2 = SimpleControllerHandlerAdapter : Controller 인터페이스(애노테이션X, 과거에 사용) 처리 ( OLD 버전 아래의 소스 )
 */
@Component("/springmvc/old-controller")
public class OldController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");

        /**
         * 뷰 리졸버 - InternalResourceViewResolver
         * 스프링 부트는 InternalResourceViewResolver 라는 뷰 리졸버를 자동으로 등록하는데,
         * 이때 application.properties 에 등록한 spring.mvc.view.prefix , spring.mvc.view.suffix 설정 정보를 사용해서 등록한다.
         * 1 = BeanNameViewResolver : 빈 이름으로 뷰를 찾아서 반환한다. (예: 엑셀 파일 생성 기능에 사용)
         * 2 = InternalResourceViewResolver : JSP를 처리할 수 있는 뷰를 반환한다. (아래의 예)
         *
         * 스프링부트를 사용하지 않으면
         * @Bean 에 InternalResourceViewResolver를 등록해주어야한다.
         * EntryPoint 주석확인
         *
         */
        return new ModelAndView("new-form");
    }
}
