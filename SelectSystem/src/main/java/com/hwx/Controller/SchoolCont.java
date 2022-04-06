package com.hwx.Controller;

import com.hwx.Service.IMPL.SCHoolSpeIMPL;
import com.hwx.Service.SchoolS;
import com.hwx.join.school;
import com.hwx.join.schoolSpecialty;
import com.hwx.join.specialty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/school")
public class SchoolCont {

    @Autowired
    private SchoolS schoolS;

    @Autowired
    private SCHoolSpeIMPL scHoolSpeIMPL;

    @GetMapping("")
    public String  school(){
        return  "/schoolfill";
    }

    @PostMapping("/SchoolSelect")
    @ResponseBody
    public List<String> Schoolselect(){
        if(schoolS.getschoolName().size()!=0){

           return schoolS.getschoolName();
        }else
            return null;
    }

    @PostMapping("/specialtyadd")
    public String  specialtyadd(@RequestParam("specialtyName")String specialtyName,
                                @RequestParam("specialtyclass")String specialtyclass,
                                @RequestParam("admitscore")Integer admitscore,
                                @RequestParam("admitAmount")Integer admintAmount,
                                @RequestParam("schoolname")String schoolname, Map<String,String> map){
        if(!schoolname.equals("请选择学校") && !schoolname.equals("")){

            List<school> bynamegetschool = schoolS.Bynamegetschool(schoolname);

            Iterator<school> iterator=bynamegetschool.iterator();
            school school=iterator.next();

            schoolSpecialty schoolSpecialty=new schoolSpecialty();
            specialty specialty=new specialty();

            specialty.setAdmitscore(admitscore);
            specialty.setAdmitamount(admintAmount);
            specialty.setName(specialtyName);
            if(specialtyclass.equals("文科")){
                specialty.setSpecialtyclass(1);
            }else specialty.setSpecialtyclass(0);
            schoolSpecialty.setSchoolid(school.getId());

            scHoolSpeIMPL.insertSpecialty(schoolSpecialty,specialty);
        }else {
            map.put("TSHI","未选择学校!");
            return "/schoolfill";
        }

        return  "redirect:/";
    }
}
