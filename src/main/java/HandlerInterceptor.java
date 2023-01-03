import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HandlerInterceptor {
    /*
    컨트롤러가 호출되기 전에 실행.
    컨트롤러 이전에 처리해야 하는 전처리 작업이나 요청정보 가공, 추가하는 경우에 사용한다.
     */
    default boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    /*
    컨트롤러를 호출한 후 실행.
    컨트롤러 이후에 처리해야 하는 후처리 작업이 있을 시에 사용한다.
    @Nullable ModelAndView : 컨트롤러가 반환하는 ModelAndView 타입의 정보가 제공되는데, 최근에는 JSON 형태의 데이터를 제공하는
    RestAPI 기반의 컨트롤러(@RestController)를 만들면서 자주 사용되지는 않음. 그래서 @Nullable

    컨트롤러 하위 계층에서 작업을 진행하다가 중간에 예외 발생 시, 호출되지 않는다.
     */
    default void postHandle(HttpServletRequest request, HttpServletResponse response
                            , Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }


    default void afterCompletion(HttpServletRequest request, HttpServletResponse response
                            , Object handler, @Nullable Exception exception) throws Exception{

    }
}
