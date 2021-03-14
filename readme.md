# Servelt to Spring MVC 단계별 코드
- - -
### 순수 서블릿을 사용해 스프링 MVC 패턴의 추상화를 단계별로 구현한다.
- 순수 @WebServlet urlPatterns를 통한 Request, Reponse 맵핑 기본
> 1. Request Header, Param, Body
> 2. Response Header, Json, Html
- - -
- FrontContoller 인터페이스 추상화를 통한 각 객체 구현
> 1. 프론트 컨트롤러 서블릿 하나로 클라이언트의 요청을 받음.
> 2. 프론트 컨트롤러가 요청에 맞는 컨트롤러를 찾아서 호출 입구를 하나로.
> 3. 프론트 컨트롤러를 제외한 나머지 컨트롤러는 서블릿을 사용하지 않아도 된다.
> 4. ModelView 공통 사용.
- - -
- MappingHandlerAdadter 도입
> 1. 어댑터가 지원하기만 하면, 어떤 것이라도 URL에 매핑해서 사용할 수 있다.
> 2. 어댑터를 추가해서 프레임워크를 유연하고 확장성 있게 설계.
> 3. 다형성과 어댑터 덕분에 기존 구조를 유지하면서, 프레임워크의 기능을 확장할 수 있다.
---
- 스프링 MVC를 간단하게 구현하며 위의 프레임워크 구조를 비교하며 간단하게 비교하며 메커니즘을 이해한다.
> 1. 스프링 MVC 구조와 결과적으로는 비슷한 패턴으로 구현.
> 2. 비교하며 스프링 MVC 구조를 더 이해한다.