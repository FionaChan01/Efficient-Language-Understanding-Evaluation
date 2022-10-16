package cn.cqu.vspace.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaperExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PaperExample() {
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

        public Criteria andPaperNameIsNull() {
            addCriterion("paper_name is null");
            return (Criteria) this;
        }

        public Criteria andPaperNameIsNotNull() {
            addCriterion("paper_name is not null");
            return (Criteria) this;
        }

        public Criteria andPaperNameEqualTo(String value) {
            addCriterion("paper_name =", value, "paperName");
            return (Criteria) this;
        }

        public Criteria andPaperNameNotEqualTo(String value) {
            addCriterion("paper_name <>", value, "paperName");
            return (Criteria) this;
        }

        public Criteria andPaperNameGreaterThan(String value) {
            addCriterion("paper_name >", value, "paperName");
            return (Criteria) this;
        }

        public Criteria andPaperNameGreaterThanOrEqualTo(String value) {
            addCriterion("paper_name >=", value, "paperName");
            return (Criteria) this;
        }

        public Criteria andPaperNameLessThan(String value) {
            addCriterion("paper_name <", value, "paperName");
            return (Criteria) this;
        }

        public Criteria andPaperNameLessThanOrEqualTo(String value) {
            addCriterion("paper_name <=", value, "paperName");
            return (Criteria) this;
        }

        public Criteria andPaperNameLike(String value) {
            addCriterion("paper_name like", value, "paperName");
            return (Criteria) this;
        }

        public Criteria andPaperNameNotLike(String value) {
            addCriterion("paper_name not like", value, "paperName");
            return (Criteria) this;
        }

        public Criteria andPaperNameIn(List<String> values) {
            addCriterion("paper_name in", values, "paperName");
            return (Criteria) this;
        }

        public Criteria andPaperNameNotIn(List<String> values) {
            addCriterion("paper_name not in", values, "paperName");
            return (Criteria) this;
        }

        public Criteria andPaperNameBetween(String value1, String value2) {
            addCriterion("paper_name between", value1, value2, "paperName");
            return (Criteria) this;
        }

        public Criteria andPaperNameNotBetween(String value1, String value2) {
            addCriterion("paper_name not between", value1, value2, "paperName");
            return (Criteria) this;
        }

        public Criteria andPaperWebsiteIsNull() {
            addCriterion("paper_website is null");
            return (Criteria) this;
        }

        public Criteria andPaperWebsiteIsNotNull() {
            addCriterion("paper_website is not null");
            return (Criteria) this;
        }

        public Criteria andPaperWebsiteEqualTo(String value) {
            addCriterion("paper_website =", value, "paperWebsite");
            return (Criteria) this;
        }

        public Criteria andPaperWebsiteNotEqualTo(String value) {
            addCriterion("paper_website <>", value, "paperWebsite");
            return (Criteria) this;
        }

        public Criteria andPaperWebsiteGreaterThan(String value) {
            addCriterion("paper_website >", value, "paperWebsite");
            return (Criteria) this;
        }

        public Criteria andPaperWebsiteGreaterThanOrEqualTo(String value) {
            addCriterion("paper_website >=", value, "paperWebsite");
            return (Criteria) this;
        }

        public Criteria andPaperWebsiteLessThan(String value) {
            addCriterion("paper_website <", value, "paperWebsite");
            return (Criteria) this;
        }

        public Criteria andPaperWebsiteLessThanOrEqualTo(String value) {
            addCriterion("paper_website <=", value, "paperWebsite");
            return (Criteria) this;
        }

        public Criteria andPaperWebsiteLike(String value) {
            addCriterion("paper_website like", value, "paperWebsite");
            return (Criteria) this;
        }

        public Criteria andPaperWebsiteNotLike(String value) {
            addCriterion("paper_website not like", value, "paperWebsite");
            return (Criteria) this;
        }

        public Criteria andPaperWebsiteIn(List<String> values) {
            addCriterion("paper_website in", values, "paperWebsite");
            return (Criteria) this;
        }

        public Criteria andPaperWebsiteNotIn(List<String> values) {
            addCriterion("paper_website not in", values, "paperWebsite");
            return (Criteria) this;
        }

        public Criteria andPaperWebsiteBetween(String value1, String value2) {
            addCriterion("paper_website between", value1, value2, "paperWebsite");
            return (Criteria) this;
        }

        public Criteria andPaperWebsiteNotBetween(String value1, String value2) {
            addCriterion("paper_website not between", value1, value2, "paperWebsite");
            return (Criteria) this;
        }

        public Criteria andPaperModelIsNull() {
            addCriterion("paper_model is null");
            return (Criteria) this;
        }

        public Criteria andPaperModelIsNotNull() {
            addCriterion("paper_model is not null");
            return (Criteria) this;
        }

        public Criteria andPaperModelEqualTo(String value) {
            addCriterion("paper_model =", value, "paperModel");
            return (Criteria) this;
        }

        public Criteria andPaperModelNotEqualTo(String value) {
            addCriterion("paper_model <>", value, "paperModel");
            return (Criteria) this;
        }

        public Criteria andPaperModelGreaterThan(String value) {
            addCriterion("paper_model >", value, "paperModel");
            return (Criteria) this;
        }

        public Criteria andPaperModelGreaterThanOrEqualTo(String value) {
            addCriterion("paper_model >=", value, "paperModel");
            return (Criteria) this;
        }

        public Criteria andPaperModelLessThan(String value) {
            addCriterion("paper_model <", value, "paperModel");
            return (Criteria) this;
        }

        public Criteria andPaperModelLessThanOrEqualTo(String value) {
            addCriterion("paper_model <=", value, "paperModel");
            return (Criteria) this;
        }

        public Criteria andPaperModelLike(String value) {
            addCriterion("paper_model like", value, "paperModel");
            return (Criteria) this;
        }

        public Criteria andPaperModelNotLike(String value) {
            addCriterion("paper_model not like", value, "paperModel");
            return (Criteria) this;
        }

        public Criteria andPaperModelIn(List<String> values) {
            addCriterion("paper_model in", values, "paperModel");
            return (Criteria) this;
        }

        public Criteria andPaperModelNotIn(List<String> values) {
            addCriterion("paper_model not in", values, "paperModel");
            return (Criteria) this;
        }

        public Criteria andPaperModelBetween(String value1, String value2) {
            addCriterion("paper_model between", value1, value2, "paperModel");
            return (Criteria) this;
        }

        public Criteria andPaperModelNotBetween(String value1, String value2) {
            addCriterion("paper_model not between", value1, value2, "paperModel");
            return (Criteria) this;
        }

        public Criteria andPaperDescriptionIsNull() {
            addCriterion("paper_description is null");
            return (Criteria) this;
        }

        public Criteria andPaperDescriptionIsNotNull() {
            addCriterion("paper_description is not null");
            return (Criteria) this;
        }

        public Criteria andPaperDescriptionEqualTo(String value) {
            addCriterion("paper_description =", value, "paperDescription");
            return (Criteria) this;
        }

        public Criteria andPaperDescriptionNotEqualTo(String value) {
            addCriterion("paper_description <>", value, "paperDescription");
            return (Criteria) this;
        }

        public Criteria andPaperDescriptionGreaterThan(String value) {
            addCriterion("paper_description >", value, "paperDescription");
            return (Criteria) this;
        }

        public Criteria andPaperDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("paper_description >=", value, "paperDescription");
            return (Criteria) this;
        }

        public Criteria andPaperDescriptionLessThan(String value) {
            addCriterion("paper_description <", value, "paperDescription");
            return (Criteria) this;
        }

        public Criteria andPaperDescriptionLessThanOrEqualTo(String value) {
            addCriterion("paper_description <=", value, "paperDescription");
            return (Criteria) this;
        }

        public Criteria andPaperDescriptionLike(String value) {
            addCriterion("paper_description like", value, "paperDescription");
            return (Criteria) this;
        }

        public Criteria andPaperDescriptionNotLike(String value) {
            addCriterion("paper_description not like", value, "paperDescription");
            return (Criteria) this;
        }

        public Criteria andPaperDescriptionIn(List<String> values) {
            addCriterion("paper_description in", values, "paperDescription");
            return (Criteria) this;
        }

        public Criteria andPaperDescriptionNotIn(List<String> values) {
            addCriterion("paper_description not in", values, "paperDescription");
            return (Criteria) this;
        }

        public Criteria andPaperDescriptionBetween(String value1, String value2) {
            addCriterion("paper_description between", value1, value2, "paperDescription");
            return (Criteria) this;
        }

        public Criteria andPaperDescriptionNotBetween(String value1, String value2) {
            addCriterion("paper_description not between", value1, value2, "paperDescription");
            return (Criteria) this;
        }

        public Criteria andPaperCodeIsNull() {
            addCriterion("paper_code is null");
            return (Criteria) this;
        }

        public Criteria andPaperCodeIsNotNull() {
            addCriterion("paper_code is not null");
            return (Criteria) this;
        }

        public Criteria andPaperCodeEqualTo(String value) {
            addCriterion("paper_code =", value, "paperCode");
            return (Criteria) this;
        }

        public Criteria andPaperCodeNotEqualTo(String value) {
            addCriterion("paper_code <>", value, "paperCode");
            return (Criteria) this;
        }

        public Criteria andPaperCodeGreaterThan(String value) {
            addCriterion("paper_code >", value, "paperCode");
            return (Criteria) this;
        }

        public Criteria andPaperCodeGreaterThanOrEqualTo(String value) {
            addCriterion("paper_code >=", value, "paperCode");
            return (Criteria) this;
        }

        public Criteria andPaperCodeLessThan(String value) {
            addCriterion("paper_code <", value, "paperCode");
            return (Criteria) this;
        }

        public Criteria andPaperCodeLessThanOrEqualTo(String value) {
            addCriterion("paper_code <=", value, "paperCode");
            return (Criteria) this;
        }

        public Criteria andPaperCodeLike(String value) {
            addCriterion("paper_code like", value, "paperCode");
            return (Criteria) this;
        }

        public Criteria andPaperCodeNotLike(String value) {
            addCriterion("paper_code not like", value, "paperCode");
            return (Criteria) this;
        }

        public Criteria andPaperCodeIn(List<String> values) {
            addCriterion("paper_code in", values, "paperCode");
            return (Criteria) this;
        }

        public Criteria andPaperCodeNotIn(List<String> values) {
            addCriterion("paper_code not in", values, "paperCode");
            return (Criteria) this;
        }

        public Criteria andPaperCodeBetween(String value1, String value2) {
            addCriterion("paper_code between", value1, value2, "paperCode");
            return (Criteria) this;
        }

        public Criteria andPaperCodeNotBetween(String value1, String value2) {
            addCriterion("paper_code not between", value1, value2, "paperCode");
            return (Criteria) this;
        }

        public Criteria andPaperScoreIsNull() {
            addCriterion("paper_score is null");
            return (Criteria) this;
        }

        public Criteria andPaperScoreIsNotNull() {
            addCriterion("paper_score is not null");
            return (Criteria) this;
        }

        public Criteria andPaperScoreEqualTo(Float value) {
            addCriterion("paper_score =", value, "paperScore");
            return (Criteria) this;
        }

        public Criteria andPaperScoreNotEqualTo(Float value) {
            addCriterion("paper_score <>", value, "paperScore");
            return (Criteria) this;
        }

        public Criteria andPaperScoreGreaterThan(Float value) {
            addCriterion("paper_score >", value, "paperScore");
            return (Criteria) this;
        }

        public Criteria andPaperScoreGreaterThanOrEqualTo(Float value) {
            addCriterion("paper_score >=", value, "paperScore");
            return (Criteria) this;
        }

        public Criteria andPaperScoreLessThan(Float value) {
            addCriterion("paper_score <", value, "paperScore");
            return (Criteria) this;
        }

        public Criteria andPaperScoreLessThanOrEqualTo(Float value) {
            addCriterion("paper_score <=", value, "paperScore");
            return (Criteria) this;
        }

        public Criteria andPaperScoreIn(List<Float> values) {
            addCriterion("paper_score in", values, "paperScore");
            return (Criteria) this;
        }

        public Criteria andPaperScoreNotIn(List<Float> values) {
            addCriterion("paper_score not in", values, "paperScore");
            return (Criteria) this;
        }

        public Criteria andPaperScoreBetween(Float value1, Float value2) {
            addCriterion("paper_score between", value1, value2, "paperScore");
            return (Criteria) this;
        }

        public Criteria andPaperScoreNotBetween(Float value1, Float value2) {
            addCriterion("paper_score not between", value1, value2, "paperScore");
            return (Criteria) this;
        }

        public Criteria andPaperTimeIsNull() {
            addCriterion("paper_time is null");
            return (Criteria) this;
        }

        public Criteria andPaperTimeIsNotNull() {
            addCriterion("paper_time is not null");
            return (Criteria) this;
        }

        public Criteria andPaperTimeEqualTo(Date value) {
            addCriterion("paper_time =", value, "paperTime");
            return (Criteria) this;
        }

        public Criteria andPaperTimeNotEqualTo(Date value) {
            addCriterion("paper_time <>", value, "paperTime");
            return (Criteria) this;
        }

        public Criteria andPaperTimeGreaterThan(Date value) {
            addCriterion("paper_time >", value, "paperTime");
            return (Criteria) this;
        }

        public Criteria andPaperTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("paper_time >=", value, "paperTime");
            return (Criteria) this;
        }

        public Criteria andPaperTimeLessThan(Date value) {
            addCriterion("paper_time <", value, "paperTime");
            return (Criteria) this;
        }

        public Criteria andPaperTimeLessThanOrEqualTo(Date value) {
            addCriterion("paper_time <=", value, "paperTime");
            return (Criteria) this;
        }

        public Criteria andPaperTimeIn(List<Date> values) {
            addCriterion("paper_time in", values, "paperTime");
            return (Criteria) this;
        }

        public Criteria andPaperTimeNotIn(List<Date> values) {
            addCriterion("paper_time not in", values, "paperTime");
            return (Criteria) this;
        }

        public Criteria andPaperTimeBetween(Date value1, Date value2) {
            addCriterion("paper_time between", value1, value2, "paperTime");
            return (Criteria) this;
        }

        public Criteria andPaperTimeNotBetween(Date value1, Date value2) {
            addCriterion("paper_time not between", value1, value2, "paperTime");
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