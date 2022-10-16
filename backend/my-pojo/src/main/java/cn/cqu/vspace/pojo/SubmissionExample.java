package cn.cqu.vspace.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubmissionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubmissionExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        public Criteria andSubmissionIdIsNull() {
            addCriterion("submission_id is null");
            return (Criteria) this;
        }

        public Criteria andSubmissionIdIsNotNull() {
            addCriterion("submission_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubmissionIdEqualTo(Integer value) {
            addCriterion("submission_id =", value, "submissionId");
            return (Criteria) this;
        }

        public Criteria andSubmissionIdNotEqualTo(Integer value) {
            addCriterion("submission_id <>", value, "submissionId");
            return (Criteria) this;
        }

        public Criteria andSubmissionIdGreaterThan(Integer value) {
            addCriterion("submission_id >", value, "submissionId");
            return (Criteria) this;
        }

        public Criteria andSubmissionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("submission_id >=", value, "submissionId");
            return (Criteria) this;
        }

        public Criteria andSubmissionIdLessThan(Integer value) {
            addCriterion("submission_id <", value, "submissionId");
            return (Criteria) this;
        }

        public Criteria andSubmissionIdLessThanOrEqualTo(Integer value) {
            addCriterion("submission_id <=", value, "submissionId");
            return (Criteria) this;
        }

        public Criteria andSubmissionIdIn(List<Integer> values) {
            addCriterion("submission_id in", values, "submissionId");
            return (Criteria) this;
        }

        public Criteria andSubmissionIdNotIn(List<Integer> values) {
            addCriterion("submission_id not in", values, "submissionId");
            return (Criteria) this;
        }

        public Criteria andSubmissionIdBetween(Integer value1, Integer value2) {
            addCriterion("submission_id between", value1, value2, "submissionId");
            return (Criteria) this;
        }

        public Criteria andSubmissionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("submission_id not between", value1, value2, "submissionId");
            return (Criteria) this;
        }

        public Criteria andDatasetIdIsNull() {
            addCriterion("dataset_id is null");
            return (Criteria) this;
        }

        public Criteria andDatasetIdIsNotNull() {
            addCriterion("dataset_id is not null");
            return (Criteria) this;
        }

        public Criteria andDatasetIdEqualTo(Integer value) {
            addCriterion("dataset_id =", value, "datasetId");
            return (Criteria) this;
        }

        public Criteria andDatasetIdNotEqualTo(Integer value) {
            addCriterion("dataset_id <>", value, "datasetId");
            return (Criteria) this;
        }

        public Criteria andDatasetIdGreaterThan(Integer value) {
            addCriterion("dataset_id >", value, "datasetId");
            return (Criteria) this;
        }

        public Criteria andDatasetIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dataset_id >=", value, "datasetId");
            return (Criteria) this;
        }

        public Criteria andDatasetIdLessThan(Integer value) {
            addCriterion("dataset_id <", value, "datasetId");
            return (Criteria) this;
        }

        public Criteria andDatasetIdLessThanOrEqualTo(Integer value) {
            addCriterion("dataset_id <=", value, "datasetId");
            return (Criteria) this;
        }

        public Criteria andDatasetIdIn(List<Integer> values) {
            addCriterion("dataset_id in", values, "datasetId");
            return (Criteria) this;
        }

        public Criteria andDatasetIdNotIn(List<Integer> values) {
            addCriterion("dataset_id not in", values, "datasetId");
            return (Criteria) this;
        }

        public Criteria andDatasetIdBetween(Integer value1, Integer value2) {
            addCriterion("dataset_id between", value1, value2, "datasetId");
            return (Criteria) this;
        }

        public Criteria andDatasetIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dataset_id not between", value1, value2, "datasetId");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andSubmissionDescriptionIsNull() {
            addCriterion("submission_description is null");
            return (Criteria) this;
        }

        public Criteria andSubmissionDescriptionIsNotNull() {
            addCriterion("submission_description is not null");
            return (Criteria) this;
        }

        public Criteria andSubmissionDescriptionEqualTo(String value) {
            addCriterion("submission_description =", value, "submissionDescription");
            return (Criteria) this;
        }

        public Criteria andSubmissionDescriptionNotEqualTo(String value) {
            addCriterion("submission_description <>", value, "submissionDescription");
            return (Criteria) this;
        }

        public Criteria andSubmissionDescriptionGreaterThan(String value) {
            addCriterion("submission_description >", value, "submissionDescription");
            return (Criteria) this;
        }

        public Criteria andSubmissionDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("submission_description >=", value, "submissionDescription");
            return (Criteria) this;
        }

        public Criteria andSubmissionDescriptionLessThan(String value) {
            addCriterion("submission_description <", value, "submissionDescription");
            return (Criteria) this;
        }

        public Criteria andSubmissionDescriptionLessThanOrEqualTo(String value) {
            addCriterion("submission_description <=", value, "submissionDescription");
            return (Criteria) this;
        }

        public Criteria andSubmissionDescriptionLike(String value) {
            addCriterion("submission_description like", value, "submissionDescription");
            return (Criteria) this;
        }

        public Criteria andSubmissionDescriptionNotLike(String value) {
            addCriterion("submission_description not like", value, "submissionDescription");
            return (Criteria) this;
        }

        public Criteria andSubmissionDescriptionIn(List<String> values) {
            addCriterion("submission_description in", values, "submissionDescription");
            return (Criteria) this;
        }

        public Criteria andSubmissionDescriptionNotIn(List<String> values) {
            addCriterion("submission_description not in", values, "submissionDescription");
            return (Criteria) this;
        }

        public Criteria andSubmissionDescriptionBetween(String value1, String value2) {
            addCriterion("submission_description between", value1, value2, "submissionDescription");
            return (Criteria) this;
        }

        public Criteria andSubmissionDescriptionNotBetween(String value1, String value2) {
            addCriterion("submission_description not between", value1, value2, "submissionDescription");
            return (Criteria) this;
        }

        public Criteria andSubmissionTimeIsNull() {
            addCriterion("submission_time is null");
            return (Criteria) this;
        }

        public Criteria andSubmissionTimeIsNotNull() {
            addCriterion("submission_time is not null");
            return (Criteria) this;
        }

        public Criteria andSubmissionTimeEqualTo(Date value) {
            addCriterion("submission_time =", value, "submissionTime");
            return (Criteria) this;
        }

        public Criteria andSubmissionTimeNotEqualTo(Date value) {
            addCriterion("submission_time <>", value, "submissionTime");
            return (Criteria) this;
        }

        public Criteria andSubmissionTimeGreaterThan(Date value) {
            addCriterion("submission_time >", value, "submissionTime");
            return (Criteria) this;
        }

        public Criteria andSubmissionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("submission_time >=", value, "submissionTime");
            return (Criteria) this;
        }

        public Criteria andSubmissionTimeLessThan(Date value) {
            addCriterion("submission_time <", value, "submissionTime");
            return (Criteria) this;
        }

        public Criteria andSubmissionTimeLessThanOrEqualTo(Date value) {
            addCriterion("submission_time <=", value, "submissionTime");
            return (Criteria) this;
        }

        public Criteria andSubmissionTimeIn(List<Date> values) {
            addCriterion("submission_time in", values, "submissionTime");
            return (Criteria) this;
        }

        public Criteria andSubmissionTimeNotIn(List<Date> values) {
            addCriterion("submission_time not in", values, "submissionTime");
            return (Criteria) this;
        }

        public Criteria andSubmissionTimeBetween(Date value1, Date value2) {
            addCriterion("submission_time between", value1, value2, "submissionTime");
            return (Criteria) this;
        }

        public Criteria andSubmissionTimeNotBetween(Date value1, Date value2) {
            addCriterion("submission_time not between", value1, value2, "submissionTime");
            return (Criteria) this;
        }

        public Criteria andSubmissionNameIsNull() {
            addCriterion("submission_name is null");
            return (Criteria) this;
        }

        public Criteria andSubmissionNameIsNotNull() {
            addCriterion("submission_name is not null");
            return (Criteria) this;
        }

        public Criteria andSubmissionNameEqualTo(String value) {
            addCriterion("submission_name =", value, "submissionName");
            return (Criteria) this;
        }

        public Criteria andSubmissionNameNotEqualTo(String value) {
            addCriterion("submission_name <>", value, "submissionName");
            return (Criteria) this;
        }

        public Criteria andSubmissionNameGreaterThan(String value) {
            addCriterion("submission_name >", value, "submissionName");
            return (Criteria) this;
        }

        public Criteria andSubmissionNameGreaterThanOrEqualTo(String value) {
            addCriterion("submission_name >=", value, "submissionName");
            return (Criteria) this;
        }

        public Criteria andSubmissionNameLessThan(String value) {
            addCriterion("submission_name <", value, "submissionName");
            return (Criteria) this;
        }

        public Criteria andSubmissionNameLessThanOrEqualTo(String value) {
            addCriterion("submission_name <=", value, "submissionName");
            return (Criteria) this;
        }

        public Criteria andSubmissionNameLike(String value) {
            addCriterion("submission_name like", value, "submissionName");
            return (Criteria) this;
        }

        public Criteria andSubmissionNameNotLike(String value) {
            addCriterion("submission_name not like", value, "submissionName");
            return (Criteria) this;
        }

        public Criteria andSubmissionNameIn(List<String> values) {
            addCriterion("submission_name in", values, "submissionName");
            return (Criteria) this;
        }

        public Criteria andSubmissionNameNotIn(List<String> values) {
            addCriterion("submission_name not in", values, "submissionName");
            return (Criteria) this;
        }

        public Criteria andSubmissionNameBetween(String value1, String value2) {
            addCriterion("submission_name between", value1, value2, "submissionName");
            return (Criteria) this;
        }

        public Criteria andSubmissionNameNotBetween(String value1, String value2) {
            addCriterion("submission_name not between", value1, value2, "submissionName");
            return (Criteria) this;
        }

        public Criteria andSubmissionAffiliationIsNull() {
            addCriterion("submission_affiliation is null");
            return (Criteria) this;
        }

        public Criteria andSubmissionAffiliationIsNotNull() {
            addCriterion("submission_affiliation is not null");
            return (Criteria) this;
        }

        public Criteria andSubmissionAffiliationEqualTo(String value) {
            addCriterion("submission_affiliation =", value, "submissionAffiliation");
            return (Criteria) this;
        }

        public Criteria andSubmissionAffiliationNotEqualTo(String value) {
            addCriterion("submission_affiliation <>", value, "submissionAffiliation");
            return (Criteria) this;
        }

        public Criteria andSubmissionAffiliationGreaterThan(String value) {
            addCriterion("submission_affiliation >", value, "submissionAffiliation");
            return (Criteria) this;
        }

        public Criteria andSubmissionAffiliationGreaterThanOrEqualTo(String value) {
            addCriterion("submission_affiliation >=", value, "submissionAffiliation");
            return (Criteria) this;
        }

        public Criteria andSubmissionAffiliationLessThan(String value) {
            addCriterion("submission_affiliation <", value, "submissionAffiliation");
            return (Criteria) this;
        }

        public Criteria andSubmissionAffiliationLessThanOrEqualTo(String value) {
            addCriterion("submission_affiliation <=", value, "submissionAffiliation");
            return (Criteria) this;
        }

        public Criteria andSubmissionAffiliationLike(String value) {
            addCriterion("submission_affiliation like", value, "submissionAffiliation");
            return (Criteria) this;
        }

        public Criteria andSubmissionAffiliationNotLike(String value) {
            addCriterion("submission_affiliation not like", value, "submissionAffiliation");
            return (Criteria) this;
        }

        public Criteria andSubmissionAffiliationIn(List<String> values) {
            addCriterion("submission_affiliation in", values, "submissionAffiliation");
            return (Criteria) this;
        }

        public Criteria andSubmissionAffiliationNotIn(List<String> values) {
            addCriterion("submission_affiliation not in", values, "submissionAffiliation");
            return (Criteria) this;
        }

        public Criteria andSubmissionAffiliationBetween(String value1, String value2) {
            addCriterion("submission_affiliation between", value1, value2, "submissionAffiliation");
            return (Criteria) this;
        }

        public Criteria andSubmissionAffiliationNotBetween(String value1, String value2) {
            addCriterion("submission_affiliation not between", value1, value2, "submissionAffiliation");
            return (Criteria) this;
        }

        public Criteria andSubmissionScoreIsNull() {
            addCriterion("submission_score is null");
            return (Criteria) this;
        }

        public Criteria andSubmissionScoreIsNotNull() {
            addCriterion("submission_score is not null");
            return (Criteria) this;
        }

        public Criteria andSubmissionScoreEqualTo(Float value) {
            addCriterion("submission_score =", value, "submissionScore");
            return (Criteria) this;
        }

        public Criteria andSubmissionScoreNotEqualTo(Float value) {
            addCriterion("submission_score <>", value, "submissionScore");
            return (Criteria) this;
        }

        public Criteria andSubmissionScoreGreaterThan(Float value) {
            addCriterion("submission_score >", value, "submissionScore");
            return (Criteria) this;
        }

        public Criteria andSubmissionScoreGreaterThanOrEqualTo(Float value) {
            addCriterion("submission_score >=", value, "submissionScore");
            return (Criteria) this;
        }

        public Criteria andSubmissionScoreLessThan(Float value) {
            addCriterion("submission_score <", value, "submissionScore");
            return (Criteria) this;
        }

        public Criteria andSubmissionScoreLessThanOrEqualTo(Float value) {
            addCriterion("submission_score <=", value, "submissionScore");
            return (Criteria) this;
        }

        public Criteria andSubmissionScoreIn(List<Float> values) {
            addCriterion("submission_score in", values, "submissionScore");
            return (Criteria) this;
        }

        public Criteria andSubmissionScoreNotIn(List<Float> values) {
            addCriterion("submission_score not in", values, "submissionScore");
            return (Criteria) this;
        }

        public Criteria andSubmissionScoreBetween(Float value1, Float value2) {
            addCriterion("submission_score between", value1, value2, "submissionScore");
            return (Criteria) this;
        }

        public Criteria andSubmissionScoreNotBetween(Float value1, Float value2) {
            addCriterion("submission_score not between", value1, value2, "submissionScore");
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