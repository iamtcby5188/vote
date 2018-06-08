package com.flybian.vote;

import com.flybian.util.DBTools;
import com.flybian.vote.dao.UserInfoMapperDao;
import com.flybian.vote.model.UserInfoModel;
import org.apache.ibatis.session.SqlSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VoteApplication {
    public static void main(String[] args){
        System.out.println("hello world");
        //SpringApplication.run(VoteApplication.class,args);
        SqlSession session = DBTools.getSession();
        UserInfoMapperDao mapper = session.getMapper(UserInfoMapperDao.class);
        UserInfoModel user = new UserInfoModel("2","aa",2);
        try{
            mapper.save(user);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
