package hello.servlet.web.frontcontroller.v1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 프런트 컨트롤러 인터페이스
 * 이 인터페이스를 각 각의 컨트롤러에서 구현한다.
 *
 * 프론트 컨트롤러 서블릿 하나로 클라이언트의 요청을 받음 프론트 컨트롤러가 요청에 맞는 컨트롤러를 찾아서 호출 입구를 하나로!
 *
 * 공통 처리 가능
 * 프론트 컨트롤러를 제외한 나머지 컨트롤러는 서블릿을 사용하지 않아도 됨
 * 스프링 웹 MVC와 프론트 컨트롤러
 * 스프링 웹 MVC의 핵심도 바로 FrontController
 * 스프링 웹 MVC의 DispatcherServlet이 FrontController 패턴으로 구현되어 있음
 *
 *
 */
public interface ControllerV1 {

    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
