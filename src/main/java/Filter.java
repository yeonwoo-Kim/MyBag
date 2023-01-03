import javax.servlet.*;
import java.io.IOException;

public interface Filter {
    /*
    필터 객체를 초기화하고 서비스에 추가하기 위한 메서드
    (웹 컨테이너가 1회 init 메서트를 호출해서 객체를 초기화하면 이후의 요청들은 doFilter를 통해 처리된다.
     */
    public default void init(FilterConfig filterConfig) throws ServletException{}

    /*
    url-pattern에 맞는 모든 HTTP 요청이 Dispatcher Servlet으로 전달되기 전에
    웹 컨테이너에 의해서 실행되는 메서드
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException;

    /*
    필터 객체를 서비스에서 제거하고 사용하는 자원을 반환하기 위한 메서드.
    웹 컨테이너에 의해서 1번 호출되며 이후에는 doFilter에 의해 처리되지 않는다.
     */
    public default void destroy() {}
}
