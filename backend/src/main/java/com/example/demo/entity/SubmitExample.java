package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class SubmitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubmitExample() {
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

        public Criteria andSubmitIdIsNull() {
            addCriterion("submit_id is null");
            return (Criteria) this;
        }

        public Criteria andSubmitIdIsNotNull() {
            addCriterion("submit_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitIdEqualTo(Integer value) {
            addCriterion("submit_id =", value, "submitId");
            return (Criteria) this;
        }

        public Criteria andSubmitIdNotEqualTo(Integer value) {
            addCriterion("submit_id <>", value, "submitId");
            return (Criteria) this;
        }

        public Criteria andSubmitIdGreaterThan(Integer value) {
            addCriterion("submit_id >", value, "submitId");
            return (Criteria) this;
        }

        public Criteria andSubmitIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("submit_id >=", value, "submitId");
            return (Criteria) this;
        }

        public Criteria andSubmitIdLessThan(Integer value) {
            addCriterion("submit_id <", value, "submitId");
            return (Criteria) this;
        }

        public Criteria andSubmitIdLessThanOrEqualTo(Integer value) {
            addCriterion("submit_id <=", value, "submitId");
            return (Criteria) this;
        }

        public Criteria andSubmitIdIn(List<Integer> values) {
            addCriterion("submit_id in", values, "submitId");
            return (Criteria) this;
        }

        public Criteria andSubmitIdNotIn(List<Integer> values) {
            addCriterion("submit_id not in", values, "submitId");
            return (Criteria) this;
        }

        public Criteria andSubmitIdBetween(Integer value1, Integer value2) {
            addCriterion("submit_id between", value1, value2, "submitId");
            return (Criteria) this;
        }

        public Criteria andSubmitIdNotBetween(Integer value1, Integer value2) {
            addCriterion("submit_id not between", value1, value2, "submitId");
            return (Criteria) this;
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

        public Criteria andSubmitRemarkIsNull() {
            addCriterion("submit_remark is null");
            return (Criteria) this;
        }

        public Criteria andSubmitRemarkIsNotNull() {
            addCriterion("submit_remark is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitRemarkEqualTo(Float value) {
            addCriterion("submit_remark =", value, "submitRemark");
            return (Criteria) this;
        }

        public Criteria andSubmitRemarkNotEqualTo(Float value) {
            addCriterion("submit_remark <>", value, "submitRemark");
            return (Criteria) this;
        }

        public Criteria andSubmitRemarkGreaterThan(Float value) {
            addCriterion("submit_remark >", value, "submitRemark");
            return (Criteria) this;
        }

        public Criteria andSubmitRemarkGreaterThanOrEqualTo(Float value) {
            addCriterion("submit_remark >=", value, "submitRemark");
            return (Criteria) this;
        }

        public Criteria andSubmitRemarkLessThan(Float value) {
            addCriterion("submit_remark <", value, "submitRemark");
            return (Criteria) this;
        }

        public Criteria andSubmitRemarkLessThanOrEqualTo(Float value) {
            addCriterion("submit_remark <=", value, "submitRemark");
            return (Criteria) this;
        }

        public Criteria andSubmitRemarkIn(List<Float> values) {
            addCriterion("submit_remark in", values, "submitRemark");
            return (Criteria) this;
        }

        public Criteria andSubmitRemarkNotIn(List<Float> values) {
            addCriterion("submit_remark not in", values, "submitRemark");
            return (Criteria) this;
        }

        public Criteria andSubmitRemarkBetween(Float value1, Float value2) {
            addCriterion("submit_remark between", value1, value2, "submitRemark");
            return (Criteria) this;
        }

        public Criteria andSubmitRemarkNotBetween(Float value1, Float value2) {
            addCriterion("submit_remark not between", value1, value2, "submitRemark");
            return (Criteria) this;
        }

        public Criteria andSubmitDescriptionIsNull() {
            addCriterion("submit_description is null");
            return (Criteria) this;
        }

        public Criteria andSubmitDescriptionIsNotNull() {
            addCriterion("submit_description is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitDescriptionEqualTo(String value) {
            addCriterion("submit_description =", value, "submitDescription");
            return (Criteria) this;
        }

        public Criteria andSubmitDescriptionNotEqualTo(String value) {
            addCriterion("submit_description <>", value, "submitDescription");
            return (Criteria) this;
        }

        public Criteria andSubmitDescriptionGreaterThan(String value) {
            addCriterion("submit_description >", value, "submitDescription");
            return (Criteria) this;
        }

        public Criteria andSubmitDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("submit_description >=", value, "submitDescription");
            return (Criteria) this;
        }

        public Criteria andSubmitDescriptionLessThan(String value) {
            addCriterion("submit_description <", value, "submitDescription");
            return (Criteria) this;
        }

        public Criteria andSubmitDescriptionLessThanOrEqualTo(String value) {
            addCriterion("submit_description <=", value, "submitDescription");
            return (Criteria) this;
        }

        public Criteria andSubmitDescriptionLike(String value) {
            addCriterion("submit_description like", value, "submitDescription");
            return (Criteria) this;
        }

        public Criteria andSubmitDescriptionNotLike(String value) {
            addCriterion("submit_description not like", value, "submitDescription");
            return (Criteria) this;
        }

        public Criteria andSubmitDescriptionIn(List<String> values) {
            addCriterion("submit_description in", values, "submitDescription");
            return (Criteria) this;
        }

        public Criteria andSubmitDescriptionNotIn(List<String> values) {
            addCriterion("submit_description not in", values, "submitDescription");
            return (Criteria) this;
        }

        public Criteria andSubmitDescriptionBetween(String value1, String value2) {
            addCriterion("submit_description between", value1, value2, "submitDescription");
            return (Criteria) this;
        }

        public Criteria andSubmitDescriptionNotBetween(String value1, String value2) {
            addCriterion("submit_description not between", value1, value2, "submitDescription");
            return (Criteria) this;
        }

        public Criteria andSubmitFlopsIsNull() {
            addCriterion("submit_flops is null");
            return (Criteria) this;
        }

        public Criteria andSubmitFlopsIsNotNull() {
            addCriterion("submit_flops is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitFlopsEqualTo(Float value) {
            addCriterion("submit_flops =", value, "submitFlops");
            return (Criteria) this;
        }

        public Criteria andSubmitFlopsNotEqualTo(Float value) {
            addCriterion("submit_flops <>", value, "submitFlops");
            return (Criteria) this;
        }

        public Criteria andSubmitFlopsGreaterThan(Float value) {
            addCriterion("submit_flops >", value, "submitFlops");
            return (Criteria) this;
        }

        public Criteria andSubmitFlopsGreaterThanOrEqualTo(Float value) {
            addCriterion("submit_flops >=", value, "submitFlops");
            return (Criteria) this;
        }

        public Criteria andSubmitFlopsLessThan(Float value) {
            addCriterion("submit_flops <", value, "submitFlops");
            return (Criteria) this;
        }

        public Criteria andSubmitFlopsLessThanOrEqualTo(Float value) {
            addCriterion("submit_flops <=", value, "submitFlops");
            return (Criteria) this;
        }

        public Criteria andSubmitFlopsIn(List<Float> values) {
            addCriterion("submit_flops in", values, "submitFlops");
            return (Criteria) this;
        }

        public Criteria andSubmitFlopsNotIn(List<Float> values) {
            addCriterion("submit_flops not in", values, "submitFlops");
            return (Criteria) this;
        }

        public Criteria andSubmitFlopsBetween(Float value1, Float value2) {
            addCriterion("submit_flops between", value1, value2, "submitFlops");
            return (Criteria) this;
        }

        public Criteria andSubmitFlopsNotBetween(Float value1, Float value2) {
            addCriterion("submit_flops not between", value1, value2, "submitFlops");
            return (Criteria) this;
        }

        public Criteria andSubmitParamsIsNull() {
            addCriterion("submit_params is null");
            return (Criteria) this;
        }

        public Criteria andSubmitParamsIsNotNull() {
            addCriterion("submit_params is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitParamsEqualTo(Float value) {
            addCriterion("submit_params =", value, "submitParams");
            return (Criteria) this;
        }

        public Criteria andSubmitParamsNotEqualTo(Float value) {
            addCriterion("submit_params <>", value, "submitParams");
            return (Criteria) this;
        }

        public Criteria andSubmitParamsGreaterThan(Float value) {
            addCriterion("submit_params >", value, "submitParams");
            return (Criteria) this;
        }

        public Criteria andSubmitParamsGreaterThanOrEqualTo(Float value) {
            addCriterion("submit_params >=", value, "submitParams");
            return (Criteria) this;
        }

        public Criteria andSubmitParamsLessThan(Float value) {
            addCriterion("submit_params <", value, "submitParams");
            return (Criteria) this;
        }

        public Criteria andSubmitParamsLessThanOrEqualTo(Float value) {
            addCriterion("submit_params <=", value, "submitParams");
            return (Criteria) this;
        }

        public Criteria andSubmitParamsIn(List<Float> values) {
            addCriterion("submit_params in", values, "submitParams");
            return (Criteria) this;
        }

        public Criteria andSubmitParamsNotIn(List<Float> values) {
            addCriterion("submit_params not in", values, "submitParams");
            return (Criteria) this;
        }

        public Criteria andSubmitParamsBetween(Float value1, Float value2) {
            addCriterion("submit_params between", value1, value2, "submitParams");
            return (Criteria) this;
        }

        public Criteria andSubmitParamsNotBetween(Float value1, Float value2) {
            addCriterion("submit_params not between", value1, value2, "submitParams");
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