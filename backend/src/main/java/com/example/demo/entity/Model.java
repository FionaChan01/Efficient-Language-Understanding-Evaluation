package com.example.demo.entity;

public class Model {
    private Integer modelId;

    private Integer paperId;

    private Float modelRemark;

    private Float modelFlops;

    private Float modelParams;

    private String modelDescription;

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Float getModelRemark() {
        return modelRemark;
    }

    public void setModelRemark(Float modelRemark) {
        this.modelRemark = modelRemark;
    }

    public Float getModelFlops() {
        return modelFlops;
    }

    public void setModelFlops(Float modelFlops) {
        this.modelFlops = modelFlops;
    }

    public Float getModelParams() {
        return modelParams;
    }

    public void setModelParams(Float modelParams) {
        this.modelParams = modelParams;
    }

    public String getModelDescription() {
        return modelDescription;
    }

    public void setModelDescription(String modelDescription) {
        this.modelDescription = modelDescription == null ? null : modelDescription.trim();
    }
}