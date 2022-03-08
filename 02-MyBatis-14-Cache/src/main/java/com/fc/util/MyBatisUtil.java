package com.fc.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

// MyBatis工具类
public class MyBatisUtil {
    // 会话工厂
    private static SqlSessionFactory factory;

    // 为了保证SqlSession的线程安全，使用ThreadLocal
    private static final ThreadLocal<SqlSession> SESSION = new ThreadLocal<>();

    static {
        try {
            // 读取配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            factory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 获取连接
    private static SqlSession openSession() {
        // 从容器中获取一个连接
        SqlSession session = SESSION.get();

        if (session == null) {
            // 通过工厂
            session = factory.openSession();

            // 放回容器中
            SESSION.set(session);
        }

        return session;
    }

    // 关闭连接
    private static void closeSession() {
        SqlSession session = SESSION.get();

        session.close();

        SESSION.remove();
    }

    /**
     * 获取接口的实现类
     *
     * @param clazz 类型
     * @param <T> 泛型
     * @return 实现类
     */
    public static <T> T getMapper(Class<T> clazz) {
        SqlSession session = openSession();

        return session.getMapper(clazz);
    }

    // 提交
    public static void commit() {
        SqlSession session = openSession();

        session.commit();

        closeSession();
    }

    // 回滚
    public static void rollback() {
        SqlSession session = openSession();

        session.rollback();

        closeSession();
    }
}
