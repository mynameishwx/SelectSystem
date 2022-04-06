package com.hwx.Comp;

import com.hwx.join.user;
import org.springframework.stereotype.Component;

@Component
public class HostHand {
    private  ThreadLocal<user> userThreadLocal=new InheritableThreadLocal<>();

    public user getuser(){
       return userThreadLocal.get();
    }
    public void  setuser(user user){
        userThreadLocal.set(user);
    }
    public void clear(){
        userThreadLocal.remove();
    }
}
