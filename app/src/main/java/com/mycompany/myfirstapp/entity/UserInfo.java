package com.mycompany.myfirstapp.entity;

/**
 * Created by Administrator on 2017/4/1.
 */

public class UserInfo {

    //表名
    public static final String TABLE="UserInfo";

    //表的各域名
    public static final String KEY_IDS="ids";
    public static final String KEY_remark="remark";
    public static final String KEY_hobby="hobby";
    public static final String KEY_sex="sex";
    public static final String KEY_username="username";
    public static final String KEY_psd="psd";
    public static final String KEY_age="age";
    public static final String KEY_img="img";
    public static final String KEY_department="department";
    public static final String KEY_crew="crew";
    public static final String KEY_phone="phone";
    public static final String KEY_createTime="createTime";
    public static final String KEY_text2="text2";
    public static final String KEY_text3="text3";
    public static final String KEY_text4="text4";
    public static final String KEY_text5="text5";

    public int ids;
    public int img;
    public String remark;
    public String sex;
    public String hobby;
    public String username;
    public String psd;
    public int age;
    public String department;//部门
    public String crew;//科室
    public String phone;
    public String createTime;//创建时间
    public String text2;
    public String text3;
    public String text4;
    public String text5;


    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getText4() {
        return text4;
    }

    public void setText4(String text4) {
        this.text4 = text4;
    }

    public String getText5() {
        return text5;
    }

    public void setText5(String text5) {
        this.text5 = text5;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd;
    }

    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }
    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

   /* public UserInfo(int ids, int img, String remark, String sex, String hobby, String username, String psd) {
        super();
        this.ids = ids;
        this.img = img;
        this.remark = remark;
        this.sex = sex;
        this.hobby = hobby;
        this.username = username;
        this.psd = psd;
    }*/

    public UserInfo() {
        this.ids = ids;
        this.img = img;
        this.remark = remark;
        this.sex = sex;
        this.hobby = hobby;
        this.username = username;
        this.psd = psd;
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "ids=" + ids +
                ", img=" + img +
                ", remark='" + remark + '\'' +
                ", sex='" + sex + '\'' +
                ", hobby='" + hobby + '\'' +
                ", username='" + username + '\'' +
                ", psd='" + psd + '\'' +
                '}';
    }


}
