package com.mycompany.myfirstapp.entity;

/**
 * Created by Administrator on 2017/4/17.
 */

public class Visitor {

    //表名
    public static final String TABLE="Visitor";


    public static final String KEY_visitId ="visitId" ;
    public static final String KEY_createTime ="createTime" ;
    public static final String KEY_createBy ="createBy" ;
    public static final String KEY_changeTime ="changeTime" ;
    public static final String KEY_changeBy ="changeBy" ;
    public static final String KEY_department ="department" ;
    public static final String KEY_crew ="crew" ;
    public static final String KEY_deskclrek ="deskclrek" ;
    public static final String KEY_deskclrekPhone ="deskclrekPhone" ;
    public static final String KEY_reason ="reason" ;
    public static final String KEY_memo ="memo" ;
    public static final String KEY_status ="status" ;
    public static final String KEY_statusTime ="statusTime" ;
    public static final String KEY_visitTime ="visitTime" ;
    public static final String KEY_leaveTime ="leaveTime" ;
    public static final String KEY_test2 ="test2" ;
    public static final String KEY_test3 ="test3" ;



    public int visitId;//唯一主键
    public String createTime;//申请时间
    public String createBy;//申请人
    public String changeTime;//修改时间
    public String changeBy;//修改人
    public String department;//部门
    public String crew;//科室
    public String deskclrek;//接待人
    public String deskclrekPhone;//接待人电话
    public String reason;//来访事由
    public String memo;//备注
    public String status;//状态
    public String statusTime;//状态时间
    public String visitTime;//来访时间
    public String leaveTime;//预计离开时间
    public String test2;
    public String test3;



    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getTest2() {
        return test2;
    }

    public void setTest2(String test2) {
        this.test2 = test2;
    }

    public String getTest3() {
        return test3;
    }

    public void setTest3(String test3) {
        this.test3 = test3;
    }

    public Visitor() {
    }

    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(String changeTime) {
        this.changeTime = changeTime;
    }

    public String getChangeBy() {
        return changeBy;
    }

    public void setChangeBy(String changeBy) {
        this.changeBy = changeBy;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getDeskclrek() {
        return deskclrek;
    }

    public void setDeskclrek(String deskclrek) {
        this.deskclrek = deskclrek;
    }

    public String getDeskclrekPhone() {
        return deskclrekPhone;
    }

    public void setDeskclrekPhone(String deskclrekPhone) {
        this.deskclrekPhone = deskclrekPhone;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusTime() {
        return statusTime;
    }

    public void setStatusTime(String statusTime) {
        this.statusTime = statusTime;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }
}
