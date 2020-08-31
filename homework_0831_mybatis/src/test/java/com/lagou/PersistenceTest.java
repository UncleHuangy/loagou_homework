package com.lagou;

import com.lagou.dao.IUserDao;
import com.lagou.io.Resources;
import com.lagou.pojo.User;
import com.lagou.sqlSession.SqlSession;
import com.lagou.sqlSession.SqlSessionFactory;
import com.lagou.sqlSession.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class PersistenceTest {

    @Test
    public void test() throws Exception {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();


        //实现更新操作
//        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
//        User user = new User();
//        user.setId(2);
//        user.setUserName("柳传志");
//        Long aLong = userDao.updateByCondition(user);
//        System.out.println(aLong);
//
//        //实现删除操作
        IUserDao userDao2 = sqlSession.getMapper(IUserDao.class);
        Long aLong1 = userDao2.deleteUserById(3);
        System.out.println(aLong1);

        //查询所有
//        IUserDao userDao3 = sqlSession.getMapper(IUserDao.class);
//        List<User> all = userDao3.findAll();
//        for (User user1 : all) {
//            System.out.println(user1);
//        }

    }



}
