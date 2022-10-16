package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class TaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskExample() {
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

        public Criteria andTaskNameIsNull() {
            addCriterion("task_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNotNull() {
            addCriterion("task_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNameEqualTo(String value) {
            addCriterion("task_name =", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotEqualTo(String value) {
            addCriterion("task_name <>", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThan(String value) {
            addCriterion("task_name >", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("task_name >=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThan(String value) {
            addCriterion("task_name <", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThanOrEqualTo(String value) {
            addCriterion("task_name <=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLike(String value) {
            addCriterion("task_name like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotLike(String value) {
            addCriterion("task_name not like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIn(List<String> values) {
            addCriterion("task_name in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotIn(List<String> values) {
            addCriterion("task_name not in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameBetween(String value1, String value2) {
            addCriterion("task_name between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotBetween(String value1, String value2) {
            addCriterion("task_name not between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskUrlIsNull() {
            addCriterion("task_url is null");
            return (Criteria) this;
        }

        public Criteria andTaskUrlIsNotNull() {
            addCriterion("task_url is not null");
            return (Criteria) this;
        }

        public Criteria andTaskUrlEqualTo(String value) {
            addCriterion("task_url =", value, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlNotEqualTo(String value) {
            addCriterion("task_url <>", value, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlGreaterThan(String value) {
            addCriterion("task_url >", value, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlGreaterThanOrEqualTo(String value) {
            addCriterion("task_url >=", value, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlLessThan(String value) {
            addCriterion("task_url <", value, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlLessThanOrEqualTo(String value) {
            addCriterion("task_url <=", value, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlLike(String value) {
            addCriterion("task_url like", value, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlNotLike(String value) {
            addCriterion("task_url not like", value, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlIn(List<String> values) {
            addCriterion("task_url in", values, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlNotIn(List<String> values) {
            addCriterion("task_url not in", values, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlBetween(String value1, String value2) {
            addCriterion("task_url between", value1, value2, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlNotBetween(String value1, String value2) {
            addCriterion("task_url not between", value1, value2, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskDescriptionIsNull() {
            addCriterion("task_description is null");
            return (Criteria) this;
        }

        public Criteria andTaskDescriptionIsNotNull() {
            addCriterion("task_description is not null");
            return (Criteria) this;
        }

        public Criteria andTaskDescriptionEqualTo(String value) {
            addCriterion("task_description =", value, "taskDescription");
            return (Criteria) this;
        }

        public Criteria andTaskDescriptionNotEqualTo(String value) {
            addCriterion("task_description <>", value, "taskDescription");
            return (Criteria) this;
        }

        public Criteria andTaskDescriptionGreaterThan(String value) {
            addCriterion("task_description >", value, "taskDescription");
            return (Criteria) this;
        }

        public Criteria andTaskDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("task_description >=", value, "taskDescription");
            return (Criteria) this;
        }

        public Criteria andTaskDescriptionLessThan(String value) {
            addCriterion("task_description <", value, "taskDescription");
            return (Criteria) this;
        }

        public Criteria andTaskDescriptionLessThanOrEqualTo(String value) {
            addCriterion("task_description <=", value, "taskDescription");
            return (Criteria) this;
        }

        public Criteria andTaskDescriptionLike(String value) {
            addCriterion("task_description like", value, "taskDescription");
            return (Criteria) this;
        }

        public Criteria andTaskDescriptionNotLike(String value) {
            addCriterion("task_description not like", value, "taskDescription");
            return (Criteria) this;
        }

        public Criteria andTaskDescriptionIn(List<String> values) {
            addCriterion("task_description in", values, "taskDescription");
            return (Criteria) this;
        }

        public Criteria andTaskDescriptionNotIn(List<String> values) {
            addCriterion("task_description not in", values, "taskDescription");
            return (Criteria) this;
        }

        public Criteria andTaskDescriptionBetween(String value1, String value2) {
            addCriterion("task_description between", value1, value2, "taskDescription");
            return (Criteria) this;
        }

        public Criteria andTaskDescriptionNotBetween(String value1, String value2) {
            addCriterion("task_description not between", value1, value2, "taskDescription");
            return (Criteria) this;
        }

        public Criteria andTaskClassIsNull() {
            addCriterion("task_class is null");
            return (Criteria) this;
        }

        public Criteria andTaskClassIsNotNull() {
            addCriterion("task_class is not null");
            return (Criteria) this;
        }

        public Criteria andTaskClassEqualTo(String value) {
            addCriterion("task_class =", value, "taskClass");
            return (Criteria) this;
        }

        public Criteria andTaskClassNotEqualTo(String value) {
            addCriterion("task_class <>", value, "taskClass");
            return (Criteria) this;
        }

        public Criteria andTaskClassGreaterThan(String value) {
            addCriterion("task_class >", value, "taskClass");
            return (Criteria) this;
        }

        public Criteria andTaskClassGreaterThanOrEqualTo(String value) {
            addCriterion("task_class >=", value, "taskClass");
            return (Criteria) this;
        }

        public Criteria andTaskClassLessThan(String value) {
            addCriterion("task_class <", value, "taskClass");
            return (Criteria) this;
        }

        public Criteria andTaskClassLessThanOrEqualTo(String value) {
            addCriterion("task_class <=", value, "taskClass");
            return (Criteria) this;
        }

        public Criteria andTaskClassLike(String value) {
            addCriterion("task_class like", value, "taskClass");
            return (Criteria) this;
        }

        public Criteria andTaskClassNotLike(String value) {
            addCriterion("task_class not like", value, "taskClass");
            return (Criteria) this;
        }

        public Criteria andTaskClassIn(List<String> values) {
            addCriterion("task_class in", values, "taskClass");
            return (Criteria) this;
        }

        public Criteria andTaskClassNotIn(List<String> values) {
            addCriterion("task_class not in", values, "taskClass");
            return (Criteria) this;
        }

        public Criteria andTaskClassBetween(String value1, String value2) {
            addCriterion("task_class between", value1, value2, "taskClass");
            return (Criteria) this;
        }

        public Criteria andTaskClassNotBetween(String value1, String value2) {
            addCriterion("task_class not between", value1, value2, "taskClass");
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