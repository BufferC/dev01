package com.fc.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class VolunteerRecruitmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VolunteerRecruitmentExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andTotalIsNull() {
            addCriterion("total is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(String value) {
            addCriterion("total =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(String value) {
            addCriterion("total <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(String value) {
            addCriterion("total >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(String value) {
            addCriterion("total >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(String value) {
            addCriterion("total <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(String value) {
            addCriterion("total <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLike(String value) {
            addCriterion("total like", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotLike(String value) {
            addCriterion("total not like", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<String> values) {
            addCriterion("total in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<String> values) {
            addCriterion("total not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(String value1, String value2) {
            addCriterion("total between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(String value1, String value2) {
            addCriterion("total not between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andPositionIsNull() {
            addCriterion("position is null");
            return (Criteria) this;
        }

        public Criteria andPositionIsNotNull() {
            addCriterion("position is not null");
            return (Criteria) this;
        }

        public Criteria andPositionEqualTo(String value) {
            addCriterion("position =", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotEqualTo(String value) {
            addCriterion("position <>", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThan(String value) {
            addCriterion("position >", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThanOrEqualTo(String value) {
            addCriterion("position >=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThan(String value) {
            addCriterion("position <", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThanOrEqualTo(String value) {
            addCriterion("position <=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLike(String value) {
            addCriterion("position like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotLike(String value) {
            addCriterion("position not like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionIn(List<String> values) {
            addCriterion("position in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotIn(List<String> values) {
            addCriterion("position not in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionBetween(String value1, String value2) {
            addCriterion("position between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotBetween(String value1, String value2) {
            addCriterion("position not between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andWorkSalaryIsNull() {
            addCriterion("work_salary is null");
            return (Criteria) this;
        }

        public Criteria andWorkSalaryIsNotNull() {
            addCriterion("work_salary is not null");
            return (Criteria) this;
        }

        public Criteria andWorkSalaryEqualTo(String value) {
            addCriterion("work_salary =", value, "workSalary");
            return (Criteria) this;
        }

        public Criteria andWorkSalaryNotEqualTo(String value) {
            addCriterion("work_salary <>", value, "workSalary");
            return (Criteria) this;
        }

        public Criteria andWorkSalaryGreaterThan(String value) {
            addCriterion("work_salary >", value, "workSalary");
            return (Criteria) this;
        }

        public Criteria andWorkSalaryGreaterThanOrEqualTo(String value) {
            addCriterion("work_salary >=", value, "workSalary");
            return (Criteria) this;
        }

        public Criteria andWorkSalaryLessThan(String value) {
            addCriterion("work_salary <", value, "workSalary");
            return (Criteria) this;
        }

        public Criteria andWorkSalaryLessThanOrEqualTo(String value) {
            addCriterion("work_salary <=", value, "workSalary");
            return (Criteria) this;
        }

        public Criteria andWorkSalaryLike(String value) {
            addCriterion("work_salary like", value, "workSalary");
            return (Criteria) this;
        }

        public Criteria andWorkSalaryNotLike(String value) {
            addCriterion("work_salary not like", value, "workSalary");
            return (Criteria) this;
        }

        public Criteria andWorkSalaryIn(List<String> values) {
            addCriterion("work_salary in", values, "workSalary");
            return (Criteria) this;
        }

        public Criteria andWorkSalaryNotIn(List<String> values) {
            addCriterion("work_salary not in", values, "workSalary");
            return (Criteria) this;
        }

        public Criteria andWorkSalaryBetween(String value1, String value2) {
            addCriterion("work_salary between", value1, value2, "workSalary");
            return (Criteria) this;
        }

        public Criteria andWorkSalaryNotBetween(String value1, String value2) {
            addCriterion("work_salary not between", value1, value2, "workSalary");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceIsNull() {
            addCriterion("work_place is null");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceIsNotNull() {
            addCriterion("work_place is not null");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceEqualTo(String value) {
            addCriterion("work_place =", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotEqualTo(String value) {
            addCriterion("work_place <>", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceGreaterThan(String value) {
            addCriterion("work_place >", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("work_place >=", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceLessThan(String value) {
            addCriterion("work_place <", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceLessThanOrEqualTo(String value) {
            addCriterion("work_place <=", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceLike(String value) {
            addCriterion("work_place like", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotLike(String value) {
            addCriterion("work_place not like", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceIn(List<String> values) {
            addCriterion("work_place in", values, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotIn(List<String> values) {
            addCriterion("work_place not in", values, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceBetween(String value1, String value2) {
            addCriterion("work_place between", value1, value2, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotBetween(String value1, String value2) {
            addCriterion("work_place not between", value1, value2, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkTimeIsNull() {
            addCriterion("work_time is null");
            return (Criteria) this;
        }

        public Criteria andWorkTimeIsNotNull() {
            addCriterion("work_time is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTimeEqualTo(String value) {
            addCriterion("work_time =", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNotEqualTo(String value) {
            addCriterion("work_time <>", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeGreaterThan(String value) {
            addCriterion("work_time >", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeGreaterThanOrEqualTo(String value) {
            addCriterion("work_time >=", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeLessThan(String value) {
            addCriterion("work_time <", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeLessThanOrEqualTo(String value) {
            addCriterion("work_time <=", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeLike(String value) {
            addCriterion("work_time like", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNotLike(String value) {
            addCriterion("work_time not like", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeIn(List<String> values) {
            addCriterion("work_time in", values, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNotIn(List<String> values) {
            addCriterion("work_time not in", values, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeBetween(String value1, String value2) {
            addCriterion("work_time between", value1, value2, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNotBetween(String value1, String value2) {
            addCriterion("work_time not between", value1, value2, "workTime");
            return (Criteria) this;
        }

        public Criteria andRecruitsNumIsNull() {
            addCriterion("recruits_num is null");
            return (Criteria) this;
        }

        public Criteria andRecruitsNumIsNotNull() {
            addCriterion("recruits_num is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitsNumEqualTo(Integer value) {
            addCriterion("recruits_num =", value, "recruitsNum");
            return (Criteria) this;
        }

        public Criteria andRecruitsNumNotEqualTo(Integer value) {
            addCriterion("recruits_num <>", value, "recruitsNum");
            return (Criteria) this;
        }

        public Criteria andRecruitsNumGreaterThan(Integer value) {
            addCriterion("recruits_num >", value, "recruitsNum");
            return (Criteria) this;
        }

        public Criteria andRecruitsNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("recruits_num >=", value, "recruitsNum");
            return (Criteria) this;
        }

        public Criteria andRecruitsNumLessThan(Integer value) {
            addCriterion("recruits_num <", value, "recruitsNum");
            return (Criteria) this;
        }

        public Criteria andRecruitsNumLessThanOrEqualTo(Integer value) {
            addCriterion("recruits_num <=", value, "recruitsNum");
            return (Criteria) this;
        }

        public Criteria andRecruitsNumIn(List<Integer> values) {
            addCriterion("recruits_num in", values, "recruitsNum");
            return (Criteria) this;
        }

        public Criteria andRecruitsNumNotIn(List<Integer> values) {
            addCriterion("recruits_num not in", values, "recruitsNum");
            return (Criteria) this;
        }

        public Criteria andRecruitsNumBetween(Integer value1, Integer value2) {
            addCriterion("recruits_num between", value1, value2, "recruitsNum");
            return (Criteria) this;
        }

        public Criteria andRecruitsNumNotBetween(Integer value1, Integer value2) {
            addCriterion("recruits_num not between", value1, value2, "recruitsNum");
            return (Criteria) this;
        }

        public Criteria andRecruitsTimeIsNull() {
            addCriterion("recruits_time is null");
            return (Criteria) this;
        }

        public Criteria andRecruitsTimeIsNotNull() {
            addCriterion("recruits_time is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitsTimeEqualTo(Date value) {
            addCriterionForJDBCDate("recruits_time =", value, "recruitsTime");
            return (Criteria) this;
        }

        public Criteria andRecruitsTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("recruits_time <>", value, "recruitsTime");
            return (Criteria) this;
        }

        public Criteria andRecruitsTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("recruits_time >", value, "recruitsTime");
            return (Criteria) this;
        }

        public Criteria andRecruitsTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("recruits_time >=", value, "recruitsTime");
            return (Criteria) this;
        }

        public Criteria andRecruitsTimeLessThan(Date value) {
            addCriterionForJDBCDate("recruits_time <", value, "recruitsTime");
            return (Criteria) this;
        }

        public Criteria andRecruitsTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("recruits_time <=", value, "recruitsTime");
            return (Criteria) this;
        }

        public Criteria andRecruitsTimeIn(List<Date> values) {
            addCriterionForJDBCDate("recruits_time in", values, "recruitsTime");
            return (Criteria) this;
        }

        public Criteria andRecruitsTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("recruits_time not in", values, "recruitsTime");
            return (Criteria) this;
        }

        public Criteria andRecruitsTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("recruits_time between", value1, value2, "recruitsTime");
            return (Criteria) this;
        }

        public Criteria andRecruitsTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("recruits_time not between", value1, value2, "recruitsTime");
            return (Criteria) this;
        }

        public Criteria andRecruitsEndTimeIsNull() {
            addCriterion("recruits_end_time is null");
            return (Criteria) this;
        }

        public Criteria andRecruitsEndTimeIsNotNull() {
            addCriterion("recruits_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitsEndTimeEqualTo(Date value) {
            addCriterionForJDBCDate("recruits_end_time =", value, "recruitsEndTime");
            return (Criteria) this;
        }

        public Criteria andRecruitsEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("recruits_end_time <>", value, "recruitsEndTime");
            return (Criteria) this;
        }

        public Criteria andRecruitsEndTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("recruits_end_time >", value, "recruitsEndTime");
            return (Criteria) this;
        }

        public Criteria andRecruitsEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("recruits_end_time >=", value, "recruitsEndTime");
            return (Criteria) this;
        }

        public Criteria andRecruitsEndTimeLessThan(Date value) {
            addCriterionForJDBCDate("recruits_end_time <", value, "recruitsEndTime");
            return (Criteria) this;
        }

        public Criteria andRecruitsEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("recruits_end_time <=", value, "recruitsEndTime");
            return (Criteria) this;
        }

        public Criteria andRecruitsEndTimeIn(List<Date> values) {
            addCriterionForJDBCDate("recruits_end_time in", values, "recruitsEndTime");
            return (Criteria) this;
        }

        public Criteria andRecruitsEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("recruits_end_time not in", values, "recruitsEndTime");
            return (Criteria) this;
        }

        public Criteria andRecruitsEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("recruits_end_time between", value1, value2, "recruitsEndTime");
            return (Criteria) this;
        }

        public Criteria andRecruitsEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("recruits_end_time not between", value1, value2, "recruitsEndTime");
            return (Criteria) this;
        }

        public Criteria andLeadIsNull() {
            addCriterion("lead is null");
            return (Criteria) this;
        }

        public Criteria andLeadIsNotNull() {
            addCriterion("lead is not null");
            return (Criteria) this;
        }

        public Criteria andLeadEqualTo(String value) {
            addCriterion("lead =", value, "lead");
            return (Criteria) this;
        }

        public Criteria andLeadNotEqualTo(String value) {
            addCriterion("lead <>", value, "lead");
            return (Criteria) this;
        }

        public Criteria andLeadGreaterThan(String value) {
            addCriterion("lead >", value, "lead");
            return (Criteria) this;
        }

        public Criteria andLeadGreaterThanOrEqualTo(String value) {
            addCriterion("lead >=", value, "lead");
            return (Criteria) this;
        }

        public Criteria andLeadLessThan(String value) {
            addCriterion("lead <", value, "lead");
            return (Criteria) this;
        }

        public Criteria andLeadLessThanOrEqualTo(String value) {
            addCriterion("lead <=", value, "lead");
            return (Criteria) this;
        }

        public Criteria andLeadLike(String value) {
            addCriterion("lead like", value, "lead");
            return (Criteria) this;
        }

        public Criteria andLeadNotLike(String value) {
            addCriterion("lead not like", value, "lead");
            return (Criteria) this;
        }

        public Criteria andLeadIn(List<String> values) {
            addCriterion("lead in", values, "lead");
            return (Criteria) this;
        }

        public Criteria andLeadNotIn(List<String> values) {
            addCriterion("lead not in", values, "lead");
            return (Criteria) this;
        }

        public Criteria andLeadBetween(String value1, String value2) {
            addCriterion("lead between", value1, value2, "lead");
            return (Criteria) this;
        }

        public Criteria andLeadNotBetween(String value1, String value2) {
            addCriterion("lead not between", value1, value2, "lead");
            return (Criteria) this;
        }

        public Criteria andContactIsNull() {
            addCriterion("contact is null");
            return (Criteria) this;
        }

        public Criteria andContactIsNotNull() {
            addCriterion("contact is not null");
            return (Criteria) this;
        }

        public Criteria andContactEqualTo(String value) {
            addCriterion("contact =", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotEqualTo(String value) {
            addCriterion("contact <>", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThan(String value) {
            addCriterion("contact >", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThanOrEqualTo(String value) {
            addCriterion("contact >=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThan(String value) {
            addCriterion("contact <", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThanOrEqualTo(String value) {
            addCriterion("contact <=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLike(String value) {
            addCriterion("contact like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotLike(String value) {
            addCriterion("contact not like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactIn(List<String> values) {
            addCriterion("contact in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotIn(List<String> values) {
            addCriterion("contact not in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactBetween(String value1, String value2) {
            addCriterion("contact between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotBetween(String value1, String value2) {
            addCriterion("contact not between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andPictureIsNull() {
            addCriterion("picture is null");
            return (Criteria) this;
        }

        public Criteria andPictureIsNotNull() {
            addCriterion("picture is not null");
            return (Criteria) this;
        }

        public Criteria andPictureEqualTo(String value) {
            addCriterion("picture =", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotEqualTo(String value) {
            addCriterion("picture <>", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThan(String value) {
            addCriterion("picture >", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThanOrEqualTo(String value) {
            addCriterion("picture >=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThan(String value) {
            addCriterion("picture <", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThanOrEqualTo(String value) {
            addCriterion("picture <=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLike(String value) {
            addCriterion("picture like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotLike(String value) {
            addCriterion("picture not like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureIn(List<String> values) {
            addCriterion("picture in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotIn(List<String> values) {
            addCriterion("picture not in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureBetween(String value1, String value2) {
            addCriterion("picture between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotBetween(String value1, String value2) {
            addCriterion("picture not between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andReleaseDateIsNull() {
            addCriterion("release_date is null");
            return (Criteria) this;
        }

        public Criteria andReleaseDateIsNotNull() {
            addCriterion("release_date is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseDateEqualTo(Date value) {
            addCriterionForJDBCDate("release_date =", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("release_date <>", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateGreaterThan(Date value) {
            addCriterionForJDBCDate("release_date >", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("release_date >=", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateLessThan(Date value) {
            addCriterionForJDBCDate("release_date <", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("release_date <=", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateIn(List<Date> values) {
            addCriterionForJDBCDate("release_date in", values, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("release_date not in", values, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("release_date between", value1, value2, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("release_date not between", value1, value2, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andLastClickTimeIsNull() {
            addCriterion("last_click_time is null");
            return (Criteria) this;
        }

        public Criteria andLastClickTimeIsNotNull() {
            addCriterion("last_click_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastClickTimeEqualTo(Date value) {
            addCriterion("last_click_time =", value, "lastClickTime");
            return (Criteria) this;
        }

        public Criteria andLastClickTimeNotEqualTo(Date value) {
            addCriterion("last_click_time <>", value, "lastClickTime");
            return (Criteria) this;
        }

        public Criteria andLastClickTimeGreaterThan(Date value) {
            addCriterion("last_click_time >", value, "lastClickTime");
            return (Criteria) this;
        }

        public Criteria andLastClickTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_click_time >=", value, "lastClickTime");
            return (Criteria) this;
        }

        public Criteria andLastClickTimeLessThan(Date value) {
            addCriterion("last_click_time <", value, "lastClickTime");
            return (Criteria) this;
        }

        public Criteria andLastClickTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_click_time <=", value, "lastClickTime");
            return (Criteria) this;
        }

        public Criteria andLastClickTimeIn(List<Date> values) {
            addCriterion("last_click_time in", values, "lastClickTime");
            return (Criteria) this;
        }

        public Criteria andLastClickTimeNotIn(List<Date> values) {
            addCriterion("last_click_time not in", values, "lastClickTime");
            return (Criteria) this;
        }

        public Criteria andLastClickTimeBetween(Date value1, Date value2) {
            addCriterion("last_click_time between", value1, value2, "lastClickTime");
            return (Criteria) this;
        }

        public Criteria andLastClickTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_click_time not between", value1, value2, "lastClickTime");
            return (Criteria) this;
        }

        public Criteria andClickNumIsNull() {
            addCriterion("click_num is null");
            return (Criteria) this;
        }

        public Criteria andClickNumIsNotNull() {
            addCriterion("click_num is not null");
            return (Criteria) this;
        }

        public Criteria andClickNumEqualTo(Integer value) {
            addCriterion("click_num =", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumNotEqualTo(Integer value) {
            addCriterion("click_num <>", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumGreaterThan(Integer value) {
            addCriterion("click_num >", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("click_num >=", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumLessThan(Integer value) {
            addCriterion("click_num <", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumLessThanOrEqualTo(Integer value) {
            addCriterion("click_num <=", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumIn(List<Integer> values) {
            addCriterion("click_num in", values, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumNotIn(List<Integer> values) {
            addCriterion("click_num not in", values, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumBetween(Integer value1, Integer value2) {
            addCriterion("click_num between", value1, value2, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumNotBetween(Integer value1, Integer value2) {
            addCriterion("click_num not between", value1, value2, "clickNum");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}