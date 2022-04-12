package com.fc.entity;

public class VolunteerRecruitmentWithBLOBs extends VolunteerRecruitment{
    private String workRequire;

    public String getWorkRequire() {
        return workRequire;
    }

    public void setWorkRequire(String workRequire) {
        this.workRequire = workRequire == null ? null : workRequire.trim();
    }
}
