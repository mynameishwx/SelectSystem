package com.hwx.Config;

import com.hwx.Comp.MyHand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements  WebMvcConfigurer  {

    @Autowired
    private MyHand myHand;

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
       WebMvcConfigurer webMvcConfigurer=new WebMvcConfigurer() {
           @Override
           public void addViewControllers(ViewControllerRegistry registry) {
               registry.addViewController("/").setViewName("index");
               registry.addViewController("/index").setViewName("index");
               registry.addViewController("/sign").setViewName("register");
               registry.addViewController("/login").setViewName("enter");

           }
       };
       return  webMvcConfigurer;
  }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myHand)
                .excludePathPatterns("/**/*.css","/**/*.jpg","/**/*.png","/**/*.js","/**/*.jpeg");

    }
}
