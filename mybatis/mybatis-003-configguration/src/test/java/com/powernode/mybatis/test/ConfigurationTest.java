package com.powernode.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class ConfigurationTest {

    public void testEnvironments() throws IOException {
        // 获取SqlSessionFactory对象（采用默认的方式获取
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //这种方式是获取默认环境
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        //这个方式选取环境
        sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"),"mybatis");
    }
}
