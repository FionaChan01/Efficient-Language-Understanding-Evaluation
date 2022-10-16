package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class ModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModelExample() {
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

        public Criteria andModelIdIsNull() {
            addCriterion("model_id is null");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNotNull() {
            addCriterion("model_id is not null");
            return (Criteria) this;
        }

        public Criteria andModelIdEqualTo(Integer value) {
            addCriterion("model_id =", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotEqualTo(Integer value) {
            addCriterion("model_id <>", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThan(Integer value) {
            addCriterion("model_id >", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("model_id >=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThan(Integer value) {
            addCriterion("model_id <", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThanOrEqualTo(Integer value) {
            addCriterion("model_id <=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdIn(List<Integer> values) {
            addCriterion("model_id in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotIn(List<Integer> values) {
            addCriterion("model_id not in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdBetween(Integer value1, Integer value2) {
            addCriterion("model_id between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("model_id not between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andPaperIdIsNull() {
            addCriterion("paper_id is null");
            return (Criteria) this;
        }

        public Criteria andPaperIdIsNotNull() {
            addCriterion("paper_id is not null");
            return (Criteria) this;
        }

        public Criteria andPaperIdEqualTo(Integer value) {
            addCriterion("paper_id =", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotEqualTo(Integer value) {
            addCriterion("paper_id <>", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdGreaterThan(Integer value) {
            addCriterion("paper_id >", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("paper_id >=", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdLessThan(Integer value) {
            addCriterion("paper_id <", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdLessThanOrEqualTo(Integer value) {
            addCriterion("paper_id <=", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdIn(List<Integer> values) {
            addCriterion("paper_id in", values, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotIn(List<Integer> values) {
            addCriterion("paper_id not in", values, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdBetween(Integer value1, Integer value2) {
            addCriterion("paper_id between", value1, value2, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotBetween(Integer value1, Integer value2) {
            addCriterion("paper_id not between", value1, value2, "paperId");
            return (Criteria) this;
        }

        public Criteria andModelRemarkIsNull() {
            addCriterion("model_remark is null");
            return (Criteria) this;
        }

        public Criteria andModelRemarkIsNotNull() {
            addCriterion("model_remark is not null");
            return (Criteria) this;
        }

        public Criteria andModelRemarkEqualTo(Float value) {
            addCriterion("model_remark =", value, "modelRemark");
            return (Criteria) this;
        }

        public Criteria andModelRemarkNotEqualTo(Float value) {
            addCriterion("model_remark <>", value, "modelRemark");
            return (Criteria) this;
        }

        public Criteria andModelRemarkGreaterThan(Float value) {
            addCriterion("model_remark >", value, "modelRemark");
            return (Criteria) this;
        }

        public Criteria andModelRemarkGreaterThanOrEqualTo(Float value) {
            addCriterion("model_remark >=", value, "modelRemark");
            return (Criteria) this;
        }

        public Criteria andModelRemarkLessThan(Float value) {
            addCriterion("model_remark <", value, "modelRemark");
            return (Criteria) this;
        }

        public Criteria andModelRemarkLessThanOrEqualTo(Float value) {
            addCriterion("model_remark <=", value, "modelRemark");
            return (Criteria) this;
        }

        public Criteria andModelRemarkIn(List<Float> values) {
            addCriterion("model_remark in", values, "modelRemark");
            return (Criteria) this;
        }

        public Criteria andModelRemarkNotIn(List<Float> values) {
            addCriterion("model_remark not in", values, "modelRemark");
            return (Criteria) this;
        }

        public Criteria andModelRemarkBetween(Float value1, Float value2) {
            addCriterion("model_remark between", value1, value2, "modelRemark");
            return (Criteria) this;
        }

        public Criteria andModelRemarkNotBetween(Float value1, Float value2) {
            addCriterion("model_remark not between", value1, value2, "modelRemark");
            return (Criteria) this;
        }

        public Criteria andModelFlopsIsNull() {
            addCriterion("model_flops is null");
            return (Criteria) this;
        }

        public Criteria andModelFlopsIsNotNull() {
            addCriterion("model_flops is not null");
            return (Criteria) this;
        }

        public Criteria andModelFlopsEqualTo(Float value) {
            addCriterion("model_flops =", value, "modelFlops");
            return (Criteria) this;
        }

        public Criteria andModelFlopsNotEqualTo(Float value) {
            addCriterion("model_flops <>", value, "modelFlops");
            return (Criteria) this;
        }

        public Criteria andModelFlopsGreaterThan(Float value) {
            addCriterion("model_flops >", value, "modelFlops");
            return (Criteria) this;
        }

        public Criteria andModelFlopsGreaterThanOrEqualTo(Float value) {
            addCriterion("model_flops >=", value, "modelFlops");
            return (Criteria) this;
        }

        public Criteria andModelFlopsLessThan(Float value) {
            addCriterion("model_flops <", value, "modelFlops");
            return (Criteria) this;
        }

        public Criteria andModelFlopsLessThanOrEqualTo(Float value) {
            addCriterion("model_flops <=", value, "modelFlops");
            return (Criteria) this;
        }

        public Criteria andModelFlopsIn(List<Float> values) {
            addCriterion("model_flops in", values, "modelFlops");
            return (Criteria) this;
        }

        public Criteria andModelFlopsNotIn(List<Float> values) {
            addCriterion("model_flops not in", values, "modelFlops");
            return (Criteria) this;
        }

        public Criteria andModelFlopsBetween(Float value1, Float value2) {
            addCriterion("model_flops between", value1, value2, "modelFlops");
            return (Criteria) this;
        }

        public Criteria andModelFlopsNotBetween(Float value1, Float value2) {
            addCriterion("model_flops not between", value1, value2, "modelFlops");
            return (Criteria) this;
        }

        public Criteria andModelParamsIsNull() {
            addCriterion("model_params is null");
            return (Criteria) this;
        }

        public Criteria andModelParamsIsNotNull() {
            addCriterion("model_params is not null");
            return (Criteria) this;
        }

        public Criteria andModelParamsEqualTo(Float value) {
            addCriterion("model_params =", value, "modelParams");
            return (Criteria) this;
        }

        public Criteria andModelParamsNotEqualTo(Float value) {
            addCriterion("model_params <>", value, "modelParams");
            return (Criteria) this;
        }

        public Criteria andModelParamsGreaterThan(Float value) {
            addCriterion("model_params >", value, "modelParams");
            return (Criteria) this;
        }

        public Criteria andModelParamsGreaterThanOrEqualTo(Float value) {
            addCriterion("model_params >=", value, "modelParams");
            return (Criteria) this;
        }

        public Criteria andModelParamsLessThan(Float value) {
            addCriterion("model_params <", value, "modelParams");
            return (Criteria) this;
        }

        public Criteria andModelParamsLessThanOrEqualTo(Float value) {
            addCriterion("model_params <=", value, "modelParams");
            return (Criteria) this;
        }

        public Criteria andModelParamsIn(List<Float> values) {
            addCriterion("model_params in", values, "modelParams");
            return (Criteria) this;
        }

        public Criteria andModelParamsNotIn(List<Float> values) {
            addCriterion("model_params not in", values, "modelParams");
            return (Criteria) this;
        }

        public Criteria andModelParamsBetween(Float value1, Float value2) {
            addCriterion("model_params between", value1, value2, "modelParams");
            return (Criteria) this;
        }

        public Criteria andModelParamsNotBetween(Float value1, Float value2) {
            addCriterion("model_params not between", value1, value2, "modelParams");
            return (Criteria) this;
        }

        public Criteria andModelDescriptionIsNull() {
            addCriterion("model_description is null");
            return (Criteria) this;
        }

        public Criteria andModelDescriptionIsNotNull() {
            addCriterion("model_description is not null");
            return (Criteria) this;
        }

        public Criteria andModelDescriptionEqualTo(String value) {
            addCriterion("model_description =", value, "modelDescription");
            return (Criteria) this;
        }

        public Criteria andModelDescriptionNotEqualTo(String value) {
            addCriterion("model_description <>", value, "modelDescription");
            return (Criteria) this;
        }

        public Criteria andModelDescriptionGreaterThan(String value) {
            addCriterion("model_description >", value, "modelDescription");
            return (Criteria) this;
        }

        public Criteria andModelDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("model_description >=", value, "modelDescription");
            return (Criteria) this;
        }

        public Criteria andModelDescriptionLessThan(String value) {
            addCriterion("model_description <", value, "modelDescription");
            return (Criteria) this;
        }

        public Criteria andModelDescriptionLessThanOrEqualTo(String value) {
            addCriterion("model_description <=", value, "modelDescription");
            return (Criteria) this;
        }

        public Criteria andModelDescriptionLike(String value) {
            addCriterion("model_description like", value, "modelDescription");
            return (Criteria) this;
        }

        public Criteria andModelDescriptionNotLike(String value) {
            addCriterion("model_description not like", value, "modelDescription");
            return (Criteria) this;
        }

        public Criteria andModelDescriptionIn(List<String> values) {
            addCriterion("model_description in", values, "modelDescription");
            return (Criteria) this;
        }

        public Criteria andModelDescriptionNotIn(List<String> values) {
            addCriterion("model_description not in", values, "modelDescription");
            return (Criteria) this;
        }

        public Criteria andModelDescriptionBetween(String value1, String value2) {
            addCriterion("model_description between", value1, value2, "modelDescription");
            return (Criteria) this;
        }

        public Criteria andModelDescriptionNotBetween(String value1, String value2) {
            addCriterion("model_description not between", value1, value2, "modelDescription");
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