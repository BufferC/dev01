package com.fc.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

// JDBC的工具类
public class DruidUtil {
    private static DataSource dataSource = null;
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    static {
        Properties properties = new Properties();

        try {

            // 修改路径，通过字节码对象来加载配置文件
            properties.load(DruidUtil.class.getResourceAsStream("/druid.properties"));

            // 加载数据库连接池
            dataSource = DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取连接
    public static Connection getConnection() {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return connection;
    }

    // 获取搬运工对象
    private static Statement getStatement() {
        // 非空操作
        if (connection == null) {
            connection = getConnection();
        }

        try {
            statement = connection.createStatement();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return statement;
    }

    // 增删改操作
    public static int update(String sql) {
        if (statement == null) {
            statement = getStatement();
        }

        int affectedRows = 0;

        try {
            affectedRows = statement.executeUpdate(sql);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            close(statement, connection);
        }


        return affectedRows;
    }

    // 执行查询操作
    public static ResultSet query(String sql) {
        if (statement == null) {
            statement = getStatement();
        }

        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return resultSet;
    }

    private static void close(Connection connection) {
        close(resultSet, statement, connection);
    }

    public static void close(ResultSet resultSet) {
        close(resultSet, statement, connection);
    }

    public static void close(Statement statement, Connection connection) {
        close(resultSet, statement, connection);
    }

    private static void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
