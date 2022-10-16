package cn.cqu.vspace.pojo;

import java.io.Serializable;

public class Submit implements Serializable {
    private Integer submitId;

    private Integer submissionId;

    private Float submitRemark;

    private String submitDescription;

    private Integer submitFlops;

    private Integer submitParams;

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

    public Integer getSubmitFlops() {
        return submitFlops;
    }

    public void setSubmitFlops(Integer submitFlops) {
        this.submitFlops = submitFlops;
    }

    public Integer getSubmitParams() {
        return submitParams;
    }

    public void setSubmitParams(Integer submitParams) {
        this.submitParams = submitParams;
    }
}