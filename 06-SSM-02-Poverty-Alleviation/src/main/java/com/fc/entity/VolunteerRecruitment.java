package com.fc.entity;

import java.util.Date;

public class VolunteerRecruitment {
    private Long id;

    private Date createTime;

    private String total;

    private String position;

    private String workSalary;

    private String workPlace;

    private String workTime;

    private Integer recruitsNum;

    private Date recruitsTime;

    private Date recruitsEndTime;

    private String lead;

    private String contact;

    private String picture;

    private Date releaseDate;

    private Date lastClickTime;

    private Integer clickNum;

    private String workRequire;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total == null ? null : total.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getWorkSalary() {
        return workSalary;
    }

    public void setWorkSalary(String workSalary) {
        this.workSalary = workSalary == null ? null : workSalary.trim();
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace == null ? null : workPlace.trim();
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime == null ? null : workTime.trim();
    }

    public Integer getRecruitsNum() {
        return recruitsNum;
    }

    public void setRecruitsNum(Integer recruitsNum) {
        this.recruitsNum = recruitsNum;
    }

    public Date getRecruitsTime() {
        return recruitsTime;
    }

    public void setRecruitsTime(Date recruitsTime) {
        this.recruitsTime = recruitsTime;
    }

    public Date getRecruitsEndTime() {
        return recruitsEndTime;
    }

    public void setRecruitsEndTime(Date recruitsEndTime) {
        this.recruitsEndTime = recruitsEndTime;
    }

    public String getLead() {
        return lead;
    }

    public void setLead(String lead) {
        this.lead = lead == null ? null : lead.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getLastClickTime() {
        return lastClickTime;
    }

    public void setLastClickTime(Date lastClickTime) {
        this.lastClickTime = lastClickTime;
    }

    public Integer getClickNum() {
        return clickNum;
    }

    public void setClickNum(Integer clickNum) {
        this.clickNum = clickNum;
    }

    public String getWorkRequire() {
        return workRequire;
    }

    public void setWorkRequire(String workRequire) {
        this.workRequire = workRequire == null ? null : workRequire.trim();
    }
}