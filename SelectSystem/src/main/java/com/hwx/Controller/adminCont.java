package com.hwx.Controller;

import com.auth0.jwt.JWT;
import com.hwx.Comp.HostHand;
import com.hwx.Comp.MyJWT;
import com.hwx.Service.IMPL.adminIMPL;
import com.hwx.Service.userS;
import com.hwx.Service.uservolunteerS;
import com.hwx.join.user;
import com.hwx.join.uservolunteer;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/hwx206")
public class adminCont {
    @Autowired
    private uservolunteerS uservolunteerS;

    @Autowired
    private adminIMPL adminIMPL;

    @Autowired
    private userS userS;

    @Autowired
    private MyJWT jwt;

    @Autowired
    private HostHand hostHand;

    @GetMapping("")
    public  String  adminLogin(){

        return  "/adminLogin";
    }

    @RequiresPermissions("admin:*:*")
    @GetMapping("/admin")
    public  String admin(Map<String,String>map){
       List<Integer> uservolunteerList=uservolunteerS.getUser_hwx();
        if(uservolunteerList.size()==0){
            map.put("volunteers","考试已经结束!");
            return "/adminData";
        }else {
            List<Integer> list=adminIMPL.getUservolunteers();
            map.put("volunteers",list.get(0)+""); //报名人数
            map.put("sj",list.get(1)+""); //实际人数
            return "/adminData";
        }
    }

    @RequiresPermissions("admin:*:*")
    @PostMapping("/adminStop")
    @ResponseBody
    public  String  adminStop(){
        adminIMPL.Stop();
        return  "成功结束考试!";
    }

    @RequiresPermissions("admin:*:*")
    @PostMapping("/adminopen")
    @ResponseBody
    public String adminopen(){
        adminIMPL.open();
        return  "开始考试!";
    }

    @GetMapping("/adminVerify")
    public String  verify(@RequestParam(value = "name")String name,
                          @RequestParam(value = "password")String password,
                          HttpSession session, Map<String,String> map){
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
                return "redirect:/hwx206/admin";
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

//    @PostMapping("/admin")
//    @RequiresPermissions("admin:*:*")
//    public  String   adminExam(){
//
//        return  "";
//    }
}
