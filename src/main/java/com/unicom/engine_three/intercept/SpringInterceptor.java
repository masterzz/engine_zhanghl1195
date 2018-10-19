package com.unicom.engine_three.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration  // 证明是一个配置
public class SpringInterceptor extends WebMvcConfigurerAdapter {

	// 自定义拦截器
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		HandlerInterceptor interceptor = new HandlerInterceptor() {

			/*在请求被处理之前调用*/
			@Override
			public boolean preHandle(HttpServletRequest request,
					HttpServletResponse response, Object handler)
					throws Exception {
				// 检查每个到来的请求对应的session域中是否有登录标识
				Object loginName = request.getSession().getAttribute("username");
				if (null == loginName || !(loginName instanceof String)) {
					// 未登录，重定向到登录页
					response.sendRedirect("/peixun/test/hello");
					return false;
				}
				String userName = (String) loginName;
				System.out.println("当前用户已登录，登录的用户名为： " + userName);
				return true;

			}

			/*在请求被处理后，视图渲染之前调用*/
			@Override
			public void postHandle(HttpServletRequest request,
					HttpServletResponse response, Object handler,
					ModelAndView modelAndView) throws Exception {
				// TODO Auto-generated method stub


			}


			/*在整个请求结束后调用*/
			@Override
			public void afterCompletion(HttpServletRequest request,
					HttpServletResponse response, Object handler, Exception ex)
					throws Exception {
				// TODO Auto-generated method stub
			}
			
		};
		
	//	registry.addInterceptor(interceptor)
		//		.addPathPatterns("/**")
		//		.excludePathPatterns("/peixun/test/hello")
		//		.excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");

	}
	
}
