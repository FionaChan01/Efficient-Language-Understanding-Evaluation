package com.example.demo.entity;

import java.util.Date;

public class Submission {
    private Integer submissionId;

    private Integer datasetId;

    private String email;

    private String submissionDescription;

    private Date submissionTime;

    private String submissionName;

    private String submissionAffiliation;

    private Float submissionScore;

    private String submissionParams;

    public Integer getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(Integer submissionId) {
        this.submissionId = submissionId;
    }

    public Integer getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(Integer datasetId) {
        this.datasetId = datasetId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getSubmissionDescription() {
        return submissionDescription;
    }

    public void setSubmissionDescription(String submissionDescription) {
        this.submissionDescription = submissionDescription == null ? null : submissionDescription.trim();
    }

    public Date getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(Date submissionTime) {
        this.submissionTime = submissionTime;
    }

    public String getSubmissionName() {
        return submissionName;
    }

    public void setSubmissionName(String submissionName) {
        this.submissionName = submissionName == null ? null : submissionName.trim();
    }

    public String getSubmissionAffiliation() {
        return submissionAffiliation;
    }

    public void setSubmissionAffiliation(String submissionAffiliation) {
        this.submissionAffiliation = submissionAffiliation == null ? null : submissionAffiliation.trim();
    }

    public Float getSubmissionScore() {
        return submissionScore;
    }

    public void setSubmissionScore(Float submissionScore) {
        this.submissionScore = submissionScore;
    }

    public String getSubmissionParams() {
        return submissionParams;
    }

    public void setSubmissionParams(String submissionParams) {
        this.submissionParams = submissionParams == null ? null : submissionParams.trim();
    }
}