package com.example.demo.entity;

public class Submit {
    private Integer submitId;

    private Integer submissionId;

    private Float submitRemark;

    private String submitDescription;

    private Float submitFlops;

    private Float submitParams;

    public Integer getSubmitId() {
        return submitId;
    }

    public void setSubmitId(Integer submitId) {
        this.submitId = submitId;
    }

    public Integer getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(Integer submissionId) {
        this.submissionId = submissionId;
    }

    public Float getSubmitRemark() {
        return submitRemark;
    }

    public void setSubmitRemark(Float submitRemark) {
        this.submitRemark = submitRemark;
    }

    public String getSubmitDescription() {
        return submitDescription;
    }

    public void setSubmitDescription(String submitDescription) {
        this.submitDescription = submitDescription == null ? null : submitDescription.trim();
    }

    public Float getSubmitFlops() {
        return submitFlops;
    }

    public void setSubmitFlops(Float submitFlops) {
        this.submitFlops = submitFlops;
    }

    public Float getSubmitParams() {
        return submitParams;
    }

    public void setSubmitParams(Float submitParams) {
        this.submitParams = submitParams;
    }
}