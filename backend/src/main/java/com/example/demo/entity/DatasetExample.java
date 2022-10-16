package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class DatasetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DatasetExample() {
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

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Integer value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Integer value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Integer value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Integer value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Integer value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Integer> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Integer> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Integer value1, Integer value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Integer value1, Integer value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andDatasetNameIsNull() {
            addCriterion("dataset_name is null");
            return (Criteria) this;
        }

        public Criteria andDatasetNameIsNotNull() {
            addCriterion("dataset_name is not null");
            return (Criteria) this;
        }

        public Criteria andDatasetNameEqualTo(String value) {
            addCriterion("dataset_name =", value, "datasetName");
            return (Criteria) this;
        }

        public Criteria andDatasetNameNotEqualTo(String value) {
            addCriterion("dataset_name <>", value, "datasetName");
            return (Criteria) this;
        }

        public Criteria andDatasetNameGreaterThan(String value) {
            addCriterion("dataset_name >", value, "datasetName");
            return (Criteria) this;
        }

        public Criteria andDatasetNameGreaterThanOrEqualTo(String value) {
            addCriterion("dataset_name >=", value, "datasetName");
            return (Criteria) this;
        }

        public Criteria andDatasetNameLessThan(String value) {
            addCriterion("dataset_name <", value, "datasetName");
            return (Criteria) this;
        }

        public Criteria andDatasetNameLessThanOrEqualTo(String value) {
            addCriterion("dataset_name <=", value, "datasetName");
            return (Criteria) this;
        }

        public Criteria andDatasetNameLike(String value) {
            addCriterion("dataset_name like", value, "datasetName");
            return (Criteria) this;
        }

        public Criteria andDatasetNameNotLike(String value) {
            addCriterion("dataset_name not like", value, "datasetName");
            return (Criteria) this;
        }

        public Criteria andDatasetNameIn(List<String> values) {
            addCriterion("dataset_name in", values, "datasetName");
            return (Criteria) this;
        }

        public Criteria andDatasetNameNotIn(List<String> values) {
            addCriterion("dataset_name not in", values, "datasetName");
            return (Criteria) this;
        }

        public Criteria andDatasetNameBetween(String value1, String value2) {
            addCriterion("dataset_name between", value1, value2, "datasetName");
            return (Criteria) this;
        }

        public Criteria andDatasetNameNotBetween(String value1, String value2) {
            addCriterion("dataset_name not between", value1, value2, "datasetName");
            return (Criteria) this;
        }

        public Criteria andDatasetEvalutionIsNull() {
            addCriterion("dataset_evalution is null");
            return (Criteria) this;
        }

        public Criteria andDatasetEvalutionIsNotNull() {
            addCriterion("dataset_evalution is not null");
            return (Criteria) this;
        }

        public Criteria andDatasetEvalutionEqualTo(String value) {
            addCriterion("dataset_evalution =", value, "datasetEvalution");
            return (Criteria) this;
        }

        public Criteria andDatasetEvalutionNotEqualTo(String value) {
            addCriterion("dataset_evalution <>", value, "datasetEvalution");
            return (Criteria) this;
        }

        public Criteria andDatasetEvalutionGreaterThan(String value) {
            addCriterion("dataset_evalution >", value, "datasetEvalution");
            return (Criteria) this;
        }

        public Criteria andDatasetEvalutionGreaterThanOrEqualTo(String value) {
            addCriterion("dataset_evalution >=", value, "datasetEvalution");
            return (Criteria) this;
        }

        public Criteria andDatasetEvalutionLessThan(String value) {
            addCriterion("dataset_evalution <", value, "datasetEvalution");
            return (Criteria) this;
        }

        public Criteria andDatasetEvalutionLessThanOrEqualTo(String value) {
            addCriterion("dataset_evalution <=", value, "datasetEvalution");
            return (Criteria) this;
        }

        public Criteria andDatasetEvalutionLike(String value) {
            addCriterion("dataset_evalution like", value, "datasetEvalution");
            return (Criteria) this;
        }

        public Criteria andDatasetEvalutionNotLike(String value) {
            addCriterion("dataset_evalution not like", value, "datasetEvalution");
            return (Criteria) this;
        }

        public Criteria andDatasetEvalutionIn(List<String> values) {
            addCriterion("dataset_evalution in", values, "datasetEvalution");
            return (Criteria) this;
        }

        public Criteria andDatasetEvalutionNotIn(List<String> values) {
            addCriterion("dataset_evalution not in", values, "datasetEvalution");
            return (Criteria) this;
        }

        public Criteria andDatasetEvalutionBetween(String value1, String value2) {
            addCriterion("dataset_evalution between", value1, value2, "datasetEvalution");
            return (Criteria) this;
        }

        public Criteria andDatasetEvalutionNotBetween(String value1, String value2) {
            addCriterion("dataset_evalution not between", value1, value2, "datasetEvalution");
            return (Criteria) this;
        }

        public Criteria andTestsetUrlIsNull() {
            addCriterion("testset_url is null");
            return (Criteria) this;
        }

        public Criteria andTestsetUrlIsNotNull() {
            addCriterion("testset_url is not null");
            return (Criteria) this;
        }

        public Criteria andTestsetUrlEqualTo(String value) {
            addCriterion("testset_url =", value, "testsetUrl");
            return (Criteria) this;
        }

        public Criteria andTestsetUrlNotEqualTo(String value) {
            addCriterion("testset_url <>", value, "testsetUrl");
            return (Criteria) this;
        }

        public Criteria andTestsetUrlGreaterThan(String value) {
            addCriterion("testset_url >", value, "testsetUrl");
            return (Criteria) this;
        }

        public Criteria andTestsetUrlGreaterThanOrEqualTo(String value) {
            addCriterion("testset_url >=", value, "testsetUrl");
            return (Criteria) this;
        }

        public Criteria andTestsetUrlLessThan(String value) {
            addCriterion("testset_url <", value, "testsetUrl");
            return (Criteria) this;
        }

        public Criteria andTestsetUrlLessThanOrEqualTo(String value) {
            addCriterion("testset_url <=", value, "testsetUrl");
            return (Criteria) this;
        }

        public Criteria andTestsetUrlLike(String value) {
            addCriterion("testset_url like", value, "testsetUrl");
            return (Criteria) this;
        }

        public Criteria andTestsetUrlNotLike(String value) {
            addCriterion("testset_url not like", value, "testsetUrl");
            return (Criteria) this;
        }

        public Criteria andTestsetUrlIn(List<String> values) {
            addCriterion("testset_url in", values, "testsetUrl");
            return (Criteria) this;
        }

        public Criteria andTestsetUrlNotIn(List<String> values) {
            addCriterion("testset_url not in", values, "testsetUrl");
            return (Criteria) this;
        }

        public Criteria andTestsetUrlBetween(String value1, String value2) {
            addCriterion("testset_url between", value1, value2, "testsetUrl");
            return (Criteria) this;
        }

        public Criteria andTestsetUrlNotBetween(String value1, String value2) {
            addCriterion("testset_url not between", value1, value2, "testsetUrl");
            return (Criteria) this;
        }

        public Criteria andDatasetDescriptionIsNull() {
            addCriterion("dataset_description is null");
            return (Criteria) this;
        }

        public Criteria andDatasetDescriptionIsNotNull() {
            addCriterion("dataset_description is not null");
            return (Criteria) this;
        }

        public Criteria andDatasetDescriptionEqualTo(String value) {
            addCriterion("dataset_description =", value, "datasetDescription");
            return (Criteria) this;
        }

        public Criteria andDatasetDescriptionNotEqualTo(String value) {
            addCriterion("dataset_description <>", value, "datasetDescription");
            return (Criteria) this;
        }

        public Criteria andDatasetDescriptionGreaterThan(String value) {
            addCriterion("dataset_description >", value, "datasetDescription");
            return (Criteria) this;
        }

        public Criteria andDatasetDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("dataset_description >=", value, "datasetDescription");
            return (Criteria) this;
        }

        public Criteria andDatasetDescriptionLessThan(String value) {
            addCriterion("dataset_description <", value, "datasetDescription");
            return (Criteria) this;
        }

        public Criteria andDatasetDescriptionLessThanOrEqualTo(String value) {
            addCriterion("dataset_description <=", value, "datasetDescription");
            return (Criteria) this;
        }

        public Criteria andDatasetDescriptionLike(String value) {
            addCriterion("dataset_description like", value, "datasetDescription");
            return (Criteria) this;
        }

        public Criteria andDatasetDescriptionNotLike(String value) {
            addCriterion("dataset_description not like", value, "datasetDescription");
            return (Criteria) this;
        }

        public Criteria andDatasetDescriptionIn(List<String> values) {
            addCriterion("dataset_description in", values, "datasetDescription");
            return (Criteria) this;
        }

        public Criteria andDatasetDescriptionNotIn(List<String> values) {
            addCriterion("dataset_description not in", values, "datasetDescription");
            return (Criteria) this;
        }

        public Criteria andDatasetDescriptionBetween(String value1, String value2) {
            addCriterion("dataset_description between", value1, value2, "datasetDescription");
            return (Criteria) this;
        }

        public Criteria andDatasetDescriptionNotBetween(String value1, String value2) {
            addCriterion("dataset_description not between", value1, value2, "datasetDescription");
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