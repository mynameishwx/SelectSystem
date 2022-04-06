package com.hwx.Service.IMPL;

import com.hwx.Comp.HostHand;
import com.hwx.Service.*;
import com.hwx.join.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class SCHoolSpeIMPL {
    @Autowired
    private  languageS languageS;
    @Autowired
    private mathS mathS;

    @Autowired
    private SchoolS schoolS;

    @Autowired
    private computerS computerS;

    @Autowired
    private englishS englishS;

    @Autowired
    private  performanceS performanceS;

    @Autowired
    private HostHand hostHand;
    @Autowired
    private   specialtyS specialtyS;

    @Autowired
    private schoolSpecialtyS schoolSpecialtyS;

    @Autowired
    private uservolunteerS uservolunteerS;

//    学校专业表
    public Integer insertSpecialty(schoolSpecialty schoolSpecialty, specialty specialty){
        int x=specialtyS.insert(specialty);
        if(x==1){
            List<specialty> specialties = specialtyS.BynameGetsp(specialty.getName());
            Iterator<specialty> iterator=specialties.iterator();
            schoolSpecialty.setSpecialtyid(iterator.next().getId());
            schoolSpecialtyS.insert_mybatis(schoolSpecialty);
        }
        return 1;
    }
//插入学生志愿表
    public Integer  insertUservolunteer(List<String> specialtyity,Integer userid){
        Iterator<String>  specialtyit=specialtyity.iterator();
        List<specialty> specialties=new ArrayList<>();
        uservolunteer uservolunteer=new uservolunteer();
             while (specialtyit.hasNext()){
              specialties= specialtyS.BynameGetsp(specialtyit.next());
              Iterator<specialty> iterator=specialties.iterator();
              uservolunteer.setSpecialtyid(iterator.next().getId());
              uservolunteer.setUserid(userid);
              uservolunteerS.insert_mybatis(uservolunteer);
             }
        specialtyit.remove();
        specialtyity.clear();
        return  1;
    }
//    查询已经填报志愿的考生
    public Integer  getbyid(Integer suerid){
        List<uservolunteer> list= uservolunteerS.getbyUserid_hwx(suerid);
        if(list.size()==0){
            return 0;
        }else
        return 1;
    }
//    成绩插入
    public  Integer insertS(Integer wz,Integer englishSults,
                            Integer computerSults,Integer perfoemanceSults){
        user user=hostHand.getuser();

        computer computer=new computer();
        english english=new english();
        performance performance=new performance();
        computer.setComputerScore(computerSults);
        computer.setUserId(user.getId());
        english.setEnglishScore(englishSults);
        english.setUserId(user.getId());
        performance.setPerformanceScore(perfoemanceSults);
        performance.setUserId(user.getId());

        if(user.getSex().equals(0)){
            math math=new math();
            math.setMathScore(wz);
            math.setUserId(user.getId());
           mathS.insert_mybatis(math);
        }else {
            language language=new language();
            language.setLanguageScore(wz);
            language.setUserId(user.getId());
            performance.setUserId(user.getId());
            languageS.insert_mybatis(language);
        }
        computerS.insert_mybatis(computer);
        englishS.insert_mybatis(english);
        performanceS.insert_mybatis(performance);
        return 1;
    }

    public String  getspecialt_school(Integer specialtID){
      List<schoolSpecialty> specialties=  schoolSpecialtyS.SPECIALTIES(specialtID);
       school school= schoolS.getbyid(specialties.get(0).getSchoolid());
        return  school.getSchoolName();
    }
}
