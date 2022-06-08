package com.web.jsp.web.config;


import com.web.jsp.web.interceptor.OnlyPrivate;
import com.web.jsp.web.interceptor.OnlyPublic;
import com.web.jsp.web.utills.SessionManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        SessionManager sessionManager = new SessionManager();
        registry.addInterceptor(new OnlyPrivate(sessionManager))
                .addPathPatterns(
                        "/logout",
                        "/board/add",
                        "/board/update/**",
                        "/board/delete/**",
                        "/comment/add/**",
                        "/comment/update/**",
                        "/comment/delete/**"
                );

        registry.addInterceptor(new OnlyPublic(sessionManager))
                .addPathPatterns("/login", "/join");
    }
}
