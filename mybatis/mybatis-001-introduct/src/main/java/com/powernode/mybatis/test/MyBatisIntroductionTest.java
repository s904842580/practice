package com.powernode.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyBatisIntroductionTest {
    public static void main(String[] args) throws Exception{
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        //获取SqlSessionFactory对象
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");//Resources.getResourceAsStream默认就是从类的根路径下开始查找资源
        //InputStream is = Resources.getResourceAsStream("com/mybatis-config.xml");
        //InputStream is = new FileInputStream("d:\\mybatis-config.cml");
        //InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml");//加载系统文件流
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);//一般情况都是一个数据库对应一个SqlSessionFactory对象

        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();//如果使用的事务管理器是JDBC的话，底层实际上会执行:conn.setAutoCommit(false);

        //执行SQL语句
        int count = sqlSession.insert("insertCar");

        System.out.println("插入了几条记录：" + count);

        //手动提交
        sqlSession.commit();//底层实际上还是会执行conn.commit();
    }
}
