package com.hwx.Controller;

import com.hwx.Comp.HostHand;
import com.hwx.Service.IMPL.SCHoolSpeIMPL;
import com.hwx.Service.SchoolS;
import com.hwx.Service.englishS;
import com.hwx.Service.enrollS;
import com.hwx.Service.specialtyS;
import com.hwx.join.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/volunteer")
public class volunteerCont {

    @Autowired
    private enrollS enrollS;

    @Autowired
    private SCHoolSpeIMPL scHoolSpeIMPL;

    @Autowired
    private specialtyS specialtyS;

    @Autowired
    private SchoolS schoolS;

    @Autowired
    private HostHand hostHand;

    @Autowired
    private englishS englishS;

    @GetMapping("")
    public  String  volunteer(Map<String,String> map){
        user user=hostHand.getuser();
        List<enroll> list= new ArrayList<>();
        list=enrollS.getByUserId_hwx(user.getId());//结果表
        int x=scHoolSpeIMPL.getbyid(user.getId());  //志愿表
        List<english> englishes =new ArrayList<>(); //成绩表(该成查询自己成绩)
         englishes = englishS.getbyUserid(user.getId());

        if(x==0 && list==null){
           map.put("one", "0");//填志愿
           return "/target";
       }else {
           if(x==0){
               specialty  specialty=specialtyS.getById(list.get(0).getSpecialtyId());
               map.put("one","4");

               map.put("SpecialtyName",specialty.getName());  //成绩结果
               map.put("schoolName",scHoolSpeIMPL.getspecialt_school(specialty.getId()));
               return  "/target";
           }else {
               if(englishes.size()!=0){
                   map.put("one","3");  //等待成绩
                   return  "/target";
               }else {
                   map.put("one", "1");  //提交成绩
                   map.put("class", user.getSex() + "");
                   return "/target";
               }
           }
       }












//        if(list.size()==0 || englishss==null) {
//            if (x != 0) {
//                map.put("one", "1");  //提交成绩
//                map.put("class", user.getSex() + "");
//                return "/target";
//            } else {
//                map.put("one", "0");//填志愿
//                return "/target";
//            }
//        }else {
//               if(englishss!=null){
//                   map.put("one","3");  //等待成绩
//                   return  "/target";
//               }else{
//                   specialty  specialty=specialtyS.getById(list.get(0).getSpecialtyId());
//                   map.put("one","4");
//
//                   map.put("SpecialtyName",specialty.getName());  //成绩结果
//                   map.put("schoolName",scHoolSpeIMPL.getspecialt_school(specialty.getId()));
//                   return  "/target";
//               }
//        }
    }
    @PostMapping("/addresults")
    public String addresults(@RequestParam("zz")Integer performanceSults,
                             @RequestParam("yy")Integer englishSults,
                             @RequestParam("jsj")Integer computterSults,
                             @RequestParam("wz")Integer wzSults,Map<String,String>map){
        scHoolSpeIMPL.insertS(wzSults,englishSults,computterSults,computterSults);
        map.put("one","3");
        return  "/target";
    }
   @PostMapping("/target")
   @ResponseBody
    public List<String> target(@RequestParam("schoolname")String schoolname,
                               @RequestParam("specialtyClass")String specialtyClass){
       List<school> schoolList= schoolS.Bynamegetschool(schoolname);

       if(schoolList.size()!=0){
           Iterator<school> iterator=schoolList.iterator();
           Integer schoolId=iterator.next().getId();

           if(specialtyClass.equals("0")){
             return   specialtyS.GetSchoolSpecialty(schoolId,0);
           }else {
              return specialtyS.GetSchoolSpecialty(schoolId,1);
           }
       }else {
           List<String> list=new ArrayList<>();
           list.add("获取列表失败!");
           return list;
       }

   }

   @PostMapping("/addtarget")
   public  String  addtarget(@RequestParam("specialty")String specialty1,
                             @RequestParam("specialty2")String specialty2,
                             @RequestParam("specialty3")String specialty3,
                             @RequestParam("specialty4")String specialty4,
                             @RequestParam("specialty5")String specialty5,
                             Map<String,String> map){
       user user=hostHand.getuser();
       List<String> stringsr=new ArrayList<>();
       stringsr.add(specialty1);
       stringsr.add(specialty2);
       stringsr.add(specialty3);
       stringsr.add(specialty4);
       stringsr.add(specialty5);
       Iterator<String> iteratorr=stringsr.iterator();
           while (iteratorr.hasNext()){
               String ff=iteratorr.next();
               if(ff.equals("")){
                   map.put("TSHI","参数为空");
                   return "/target";
               }
           }
       scHoolSpeIMPL.insertUservolunteer(stringsr,user.getId());
      return "redirect:/";
   }
}
