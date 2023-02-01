package boardexample.myboard;


import boardexample.myboard.web.intercepter.LogInterceptor;
import boardexample.myboard.web.intercepter.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**") // 모든 경로에 적용한다는 의미
                .excludePathPatterns("/js/**","/css/**", "/*.ico", "/error", "/*.png", "/*.jpg");

        /*registry.addInterceptor(new LoginCheckInterceptor())
                .order(2)
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/user/add", "/login", "/css/**", "/*.png", "/*.jpg",
                            "/*.ico", "/error", "/userapi", "/loginapi");*/
    }


}
