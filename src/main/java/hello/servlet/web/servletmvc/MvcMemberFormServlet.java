package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * redirect vs forward
         *   리다이렉트는 실제 클라이언트(웹 브라우저)에 응답이 나갔다가, 클라이언트가 redirect 경로로 다시
         *   요청한다. 따라서 클라이언트가 인지할 수 있고, URL 경로도 실제로 변경된다. 반면에 포워드는 서버 내부에서 일어나는 호출이기 때문에 클라이언트가 전혀 인지하지 못한다.
         *
         * /WEB-INF
         *   이 경로안에 JSP가 있으면 외부에서 직접 JSP를 호출할 수 없다. 우리가 기대하는 것은 항상 컨트롤러를
         *   통해서 JSP를 호출하는 것이다.
         *   webapp/WEB-INF DIR을 사용하면 컨트롤러를 통해서 부른다고 생각하면 된다. http://localhost:8080/WEB-INF 이런식으로 접근 불가능, 표준이라 보자
         *
         * 여기서 form의 action을 보면 절대 경로(로 시작)이 아니라 상대경로(로 시작X)하는 것을 확인할 수 있다. 이렇게 상대경로를 사용하면 폼 전송시 현재 URL이 속한 계층 경로 + save가 호출된다.
         * 현재 계층 경로: /servlet-mvc/members/
         * 결과: /servlet-mvc/members/save
         *
         */

        /**
         * 문제점
         *
         * prefix: /WEB-INF/views/
         * suffix: .jsp
         * 그리고 만약 jsp가 아닌 thymeleaf 같은 다른 뷰로 변경한다면 전체 코드를 다 변경해야 한다.
         *
         * 컨트롤러 호출 전에 먼저 공통 기능을 처리해야 한다. 소위 수문장 역할을 하는 기능이 필요하다. 프론트 컨트롤러(Front Controller, 필터랑은 다르다.) 패턴을 도입하면 이런 문제를 깔끔하게 해결할 수 있다. (입구를 하나로!)
         * 스프링 MVC의 핵심도 바로 이 프론트 컨트롤러에 있다.
         */
        String viewPath = "/WEB-INF/views/new-form.jsp";
        // 컨트럴로에서 View 를 호출하기 위한.
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        // 제어권을 뷰로 넘겨준다., redirect랑은 다르다.
        // 서블릿이 호출되고 JSP가 호출된다고 보면 된다.
        dispatcher.forward(request, response);
    }
}
