package com.unicom.engine_three.model;

public class UserCall {

    // 用户id
    private String userId;
    // 通话开始日期
    private String startDate;
    // 通过开始时间
    private String startTime;
    // 通话时长
    private double callDuration;
    // 语音量
    private double callAmount;
    // 流量
    private double flowAmout;
    // 用户数
    private double userSum;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public double getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(double callDuration) {
        this.callDuration = callDuration;
    }

    public double getCallAmount() {
        return callAmount;
    }

    public void setCallAmount(double callAmount) {
        this.callAmount = callAmount;
    }

    public double getFlowAmout() {
        return flowAmout;
    }

    public void setFlowAmout(double flowAmout) {
        this.flowAmout = flowAmout;
    }

    public double getUserSum() {
        return userSum;
    }

    public void setUserSum(double userSum) {
        this.userSum = userSum;
    }

    @Override
    public String toString() {
        return "UserCall{" +
                "userId='" + userId + '\'' +
                ", startDate='" + startDate + '\'' +
                ", startTime='" + startTime + '\'' +
                ", callDuration=" + callDuration +
                ", callAmount=" + callAmount +
                ", flowAmout=" + flowAmout +
                ", userSum=" + userSum +
                '}';
    }

}
