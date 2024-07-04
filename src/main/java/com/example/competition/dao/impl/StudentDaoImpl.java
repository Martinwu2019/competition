package com.example.competition.dao.impl;

import com.example.competition.dao.StudentDao;
import com.example.competition.entity.Notice;
import com.example.competition.entity.Student;
import com.example.competition.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private DBConnection dbConnection = null;//定义数据库连接类
    private Connection conn = null;//数据库连接对象
    private PreparedStatement pstmt = null;//数据库操作对象,语句被预编译并且存储在 PreparedStatement 对象中

    public StudentDaoImpl() throws Exception {
        this.dbConnection = new DBConnection();
        conn = dbConnection.getConnection();
    }

    public StudentDaoImpl(Connection conn){
        this.conn = conn;
    }

    @Override
    public Student save(Student student) throws Exception {
        boolean flag = false;
        String sql = "insert into student(" +
                "userName," +
                "password," +
                "realName," +
                "age," +
                "phone," +
                "email," +
                "grade," +
                "major," +
                "identityCode," +
                "createTime)values(?,?,?,?,?,?,?,?,?,?)";
        this.pstmt = this.conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);//实例化prepareStatement对象
        this.pstmt.setString(1,student.getUserName());//setString将指定参数设置为给定 Java String 值
        // 。在将此值发送给数据库时，驱动程序将它转换成一个 SQL VARCHAR 或 LONGVARCHAR 值
        this.pstmt.setString(2,student.getPassword());
        this.pstmt.setString(3,student.getRealName());
        this.pstmt.setInt(4,student.getAge());
        this.pstmt.setString(5,student.getPhone());
        this.pstmt.setString(6,student.getEmail());
        this.pstmt.setString(7,student.getGrade());
        this.pstmt.setString(8,student.getMajor());
        this.pstmt.setString(9,student.getIdentityCode());
        this.pstmt.setDate(10,new Date(student.getCreateTime().getTime()));
        if (this.pstmt.executeUpdate() == 0){
            throw new SQLException("Creating user failed, no rows affected.");
        }
        try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                System.out.println("Inserted record's ID: " + id);
                student.setId(id);
            } else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        }
        this.pstmt.close();//关闭prepareStatement操作
        return student;
    }

    @Override
    public Student findByIdentityCode(String identityCode) throws SQLException {
        pstmt = conn.prepareStatement("SELECT * FROM student WHERE identityCode = ?");
        pstmt.setString(1, identityCode);

        ResultSet rs = pstmt.executeQuery();
        Student student = null;
        if (rs.next()) {
            student = new Student();
            student.setId(rs.getInt("id"));
            student.setUserName(rs.getString("userName"));
            student.setPassword(rs.getString("password"));
            student.setRealName(rs.getString("realName"));
            student.setAge(rs.getInt("age"));
            student.setPhone(rs.getString("phone"));
            student.setEmail(rs.getString("email"));
            student.setGrade(rs.getString("grade"));
            student.setMajor(rs.getString("major"));
            student.setIdentityCode(rs.getString("identityCode"));
            student.setCreateTime(rs.getDate("createTime"));
            // 设置其他属性
        }
        return student;
    }

    @Override
    public Student findByUserName(String userName) throws SQLException {
        pstmt = conn.prepareStatement("SELECT * FROM student WHERE userName = ?");
        pstmt.setString(1, userName);

        ResultSet rs = pstmt.executeQuery();
        Student student = null;
        if (rs.next()) {
            student = new Student();
            student.setId(rs.getInt("id"));
            student.setUserName(rs.getString("userName"));
            student.setPassword(rs.getString("password"));
            student.setRealName(rs.getString("realName"));
            student.setAge(rs.getInt("age"));
            student.setPhone(rs.getString("phone"));
            student.setEmail(rs.getString("email"));
            student.setGrade(rs.getString("grade"));
            student.setMajor(rs.getString("major"));
            student.setIdentityCode(rs.getString("identityCode"));
            student.setCreateTime(rs.getDate("createTime"));
            // 设置其他属性
        }
        return student;
    }
    @Override
    public List<Student> listByIds(List<Integer> stuIds) throws SQLException {
        List<Student> list = new ArrayList<Student>();//定义集合
        StringBuilder sql = new StringBuilder("select id,userName," +
                "password," +
                "realName," +
                "age," +
                "phone," +
                "email," +
                "grade," +
                "major," +
                "identityCode," +
                "createTime from student where id in (");

        for (int i = 0; i < stuIds.size(); i++) {
            if (i > 0) {
                sql.append(",");
            }
            sql.append(stuIds.get(i));
        }
        sql.append(")");

        pstmt = conn.prepareStatement(sql.toString());
        ResultSet rs = pstmt.executeQuery();
        Student student = null;
        while (rs.next()) {
            student = new Student();
            student.setId(rs.getInt("id"));
            student.setUserName(rs.getString("userName"));
            student.setPassword(rs.getString("password"));
            student.setRealName(rs.getString("realName"));
            student.setAge(rs.getInt("age"));
            student.setPhone(rs.getString("phone"));
            student.setEmail(rs.getString("email"));
            student.setGrade(rs.getString("grade"));
            student.setMajor(rs.getString("major"));
            student.setIdentityCode(rs.getString("identityCode"));
            student.setCreateTime(rs.getDate("createTime"));
            list.add(student);
        }
        this.pstmt.close();
        return list;
    }
//    @Override
//    public List<Student> findAll(String product_name) throws Exception {
//        List<Student> list = new ArrayList<Student>();//定义集合
//        String sql = "select product_id,product_name,price,info from student";
//        if (product_name!=null&&!"".equals(product_name)){
//            sql = "select product_id,product_name,price,info from student where product_name like ?";
//            this.pstmt.setString(1,"%"+product_name+"%"); //设置要查询的商品的名称
//            //this.pstmt = this.conn.prepareStatement(sql);
//        }else{
//            this.pstmt =this.conn.prepareStatement(sql);
//        }
//        ResultSet rs = this.pstmt.executeQuery();//执行查询语句
//        Student student = null;
//        while (rs.next()){
//            student = new Student();
//            student.setProduct_id(rs.getString(1));
//            student.setProduct_name(rs.getString(2));
//            student.setPrice(rs.getDouble(3));
//            student.setInfo(rs.getString(4));
//            list.add(student);//向集合中添加product对象
//        }
//        this.pstmt.close();
//        return list;
//    }
//
//    @Override
//    public Student findByProductId(String product_id) throws Exception {
//        Student student = null;
//        String sql = "select product_id,product_name,price,info from student where product_id like ?";
//        this.pstmt = this.conn.prepareStatement(sql);
//        this.pstmt.setString(1,product_id);//设置产品编号
//        ResultSet rs = this.pstmt.executeQuery();
//        if (rs.next()){
//            student = new Student();
//            student.setProduct_id(rs.getString(1));
//            student.setProduct_name(rs.getString(2));
//            student.setPrice(rs.getDouble(3));
//            student.setInfo(rs.getString(4));
//        }
//        this.pstmt.close();
//        return student;//若查询不到则就返回空。
//    }
}