package com.hwx.Service.IMPL;

import com.hwx.Service.*;
import com.hwx.join.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class adminIMPL {
    @Autowired
    private sortingS sortingS;

    @Autowired
    private specialtyS specialtyS;

    @Autowired
    private enrollS enrollS;

    @Autowired
    private uservolunteerS uservolunteerS;

    @Autowired
    private englishS englishS;

    @Autowired
    private mathS mathS;

    public List<Integer> getUservolunteers(){

//        获取报考人数
        List<Integer>  list2=new ArrayList<>();
        list2=englishS.get_hwx();

//        获取考试人数
        List<Integer> list=new ArrayList<>();
        list=uservolunteerS.getUser_hwx();

        List<Integer> list1=new ArrayList<>();

        if(list.size()==0){
            list1.add(0);
        }else {
            list1.add(list.size());
        }
        if(list2.size()==0){
            list1.add(0);
        }else {
            list1.add(list2.size());
        }

        return list1;

    }

    public Integer  Stop(){

//        获取理科成绩排名
    List<sorting> math=sortingS.getrow_math();

//        获取文科成绩排名
    List<sorting> language=sortingS.getrow_Language();

        this.sorting(math);
        this.sorting(language);

        sortingS.delete_hwx(1);
        return  1;
    }

//    开始考试，清除上次考试结果
    public void  open(){
        sortingS.delete_hwx(2);
    }
    public void  sorting(List<sorting> List_sp){
        Iterator<sorting> iterator=List_sp.iterator();
//        按顺序遍历用户id
        while (iterator.hasNext()){
            sorting sorting=iterator.next();
            //  根据用户id查询在用户志愿表中查询用户的志愿
          List<uservolunteer>  user_uservolunteer
                  = uservolunteerS.getbyUserid_hwx(sorting.getUserId());
            Iterator<uservolunteer> uservolunteerIterator=user_uservolunteer.iterator();
            //  遍历查询出来的志愿
            while (uservolunteerIterator.hasNext()){

                //  用查询的专业id去查询专业详情
               specialty specialty=
                       specialtyS.getById(uservolunteerIterator.next().getSpecialtyid());
               if(specialty.getAdmitamount()>=1){
                   if(sorting.getUserRow()+sorting.getSpecialtyClass()>=specialty.getAdmitscore()){
                       //  将专业录取数量减一
                       specialtyS.update_Specialty(specialty.getId());
                       enroll enroll=new enroll();
                       enroll.setUserId(sorting.getUserId());
                       enroll.setSpecialtyId(specialty.getId());
                       enrollS.insert_mybatis(enroll);
                       break;
                   }
               }

            }

        }
        iterator.remove();
    }
}
