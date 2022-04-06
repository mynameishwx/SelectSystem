package com.hwx.Controller;

import com.hwx.Comp.MyJWT;
import com.hwx.Service.IMPL.enterIMPL;
import com.hwx.Service.userS;
import com.hwx.join.user;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.logging.Logger;

@Controller
public class enterCont {
    @Autowired
    private userS userS;

    @Autowired
    private enterIMPL enter;

    @Autowired
    private MyJWT  jwt;

//    首页判断是否登录
    @GetMapping("/")
    public  String  index(){
         return  "/index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.setAttribute("token",null);
        return "redirect:/";
    }



    @PostMapping("/enter")
    public  String enterCont(@RequestParam(value = "name")String name,
                             @RequestParam(value = "password")String password,
                             HttpSession session,Map<String,String> map){
        Subject subject= SecurityUtils.getSubject();
        List<user> userList=new ArrayList<>();
        userList=userS.GetUserName(name);
       if(userList==null){
           map.put("Tshi","账号未注册!");
           return  "enter";
       }else {
          try {
              UsernamePasswordToken token=new UsernamePasswordToken(name,password);
              subject.login(token);
              Map<String,String> map1=new HashMap<>();
              map1.put("name",name);
              String s = jwt.GetJwt(map1);
              session.setAttribute("token",s);
              return "redirect:/";
          }catch (UnknownAccountException e){
              map.put("Tshi","账号错误!");
              return  "enter";
          }catch(IncorrectCredentialsException e){
              map.put("Tshi","密码错误!");
              return  "enter";
           }catch (Exception e){
              e.printStackTrace();
          }
       }



        return  "";
    }
    @GetMapping("/enter/verify")
    @ResponseBody
    public  String  verify(String nameid){
        List<user> userList= new ArrayList<>();
        userList=userS.GetUserName(nameid);
        if(userList==null){
            return "账号未注册!";
        }else {
            return  null;
        }
    }
    @GetMapping("/register")
    public  String register(@RequestParam("name")String name,
                            @RequestParam("nickname")String nickname,
                            @RequestParam("password")String password,
                            @RequestParam("surePassword")String surePassword,
                            @RequestParam(value = "sex",defaultValue = "0")Integer sex,
                            Map<Object,Object> map){
        if(userS.GetUserName(name)!=null){
           map.put("Tshi","账号已注册!");
           return  "login";
        }else {
            if(password.equals(surePassword)){
                 user user=new user();
                 user.setName(name);
                 user.setPassword(password);
                 user.setNameId(nickname);
                 user.setSex(sex);
                 user=enter.MyMD5(user);
                 userS.MyInsertUser(user);
            }else {
                map.put("Tshi","密码不一致!");
            }
        }

        return  "index";
    }
   @GetMapping("/getcj")
    public String getcj(){

        return  "";
   }
}
