package com.hwx.Comp;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hwx.Service.userS;
import com.hwx.join.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;

@Component
public class MyHand implements HandlerInterceptor {

    @Autowired
    private   MyJWT jwt;

    @Autowired
    private userS userS;

    @Autowired
    private  HostHand hostHand;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object token=request.getSession().getAttribute("token");
        if(token!=null) {
            DecodedJWT yanz = jwt.yanz(token.toString());
            String name = yanz.getClaims().get("name").asString();
            List<user> users = userS.GetUserName(name);
            Iterator<user> iterator = users.iterator();
            user user = iterator.next();
            hostHand.setuser(user);
        }else{
            hostHand.clear();
        }
//        else {
//            response.sendRedirect("/login");
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {


        if(hostHand.getuser()!=null && modelAndView!=null){
            user user=hostHand.getuser();
            modelAndView.addObject("loginUser",user);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
