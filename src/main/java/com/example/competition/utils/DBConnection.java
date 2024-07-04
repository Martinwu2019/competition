package com.example.competition.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    /*
    *1.执行数据库得连接配置
    *
    *
    * */
    private static final String Driver = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/competition?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8";
    private static final String username = "root";
    private static final String password = "123456";
    private Connection conn = null;
    public DBConnection() throws Exception{//进行数据库连接
        try {
            Class.forName(Driver);//利用反射加载数据库驱动可以获得一类对象
            this.conn = DriverManager.getConnection(URL, username, password);
        }catch (Exception e){
            throw e;
        }
    }
    public Connection getConnection(){
        return this.conn;//取得数据库得连接
    }
    public void close() throws Exception{//关闭数据库
        if (this.conn!=null){
            try {
                this.conn.close();
            }catch (Exception e){
                throw e;
            }
        }
    }
}
