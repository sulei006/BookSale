package com.su.booksale.config;

import com.su.booksale.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//这是springMVC的配置类，主要是实现过滤器等功能
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

//   拦截器必须修改，因为springboot2.0后会静态资源过滤，因此必须给静态资源放行
//    坑，放行后，必须在maven lifecycle中清除一遍，否则不成功
//    这里扩展一下web的访问方式：
//            1.通过controller来返回从而访问template中的内容
//            2.通过静态资源访问可以直接用url访问static中的内容（在放行静态资源的基础上）


//    同时如果要加入过滤器的话，也是在该方法中加入，配置该拦截器要拦截哪一些路径
    @Override

    public  void addInterceptors(InterceptorRegistry registry)
    {
        //指明要拦截的路径和要放行的路径
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/admin","/login")
                .excludePathPatterns("/css/*","/js/*","/images/*");
    }

}
