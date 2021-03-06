package example.filter;

import com.alibaba.fastjson.JSON;
import example.controller.CheckIsLogin;
import example.tools.ModelResult;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
public class userFilter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Boolean isLogin=new CheckIsLogin(httpServletRequest.getSession()).CheckIsLogin();
        if(!isLogin){
            httpServletResponse.setCharacterEncoding("utf-8");
            httpServletResponse.setContentType("text/html; charset=utf-8");
            PrintWriter writer = httpServletResponse.getWriter();
            writer.append(JSON.toJSONString(ModelResult.newError("401","未登录",false)));
            writer.close();
            return false;
        }else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
