package com.mycompany.myfirstapp.entity;

/**
 * Created by Administrator on 2017/4/12.
 */

public class Student {
    //表名
    public static final String TABLE="Student";

    //表的各域名
    public static final String KEY_ID="id";
    public static final String KEY_name="name";
    public static final String KEY_email="email";
    public static final String KEY_age="age";

    //属性
    public int student_ID;
    public String name;
    public String email;
    public int age;

    public Student() {
        this.student_ID = student_ID;
        this.name = name;
        this.email = email;
        this.age = age;
    }
}
