package cn.cqu.vspace.pojo;

import java.io.Serializable;
import java.util.Date;

public class Paper implements Serializable {
    private Integer paperId;

    private Integer datasetId;

    private String email;

    private String paperName;

    private String paperWebsite;

    private String paperModel;

    private String paperDescription;

    private String paperCode;

    private Float paperScore;

    private Date paperTime;

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
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

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName == null ? null : paperName.trim();
    }

    public String getPaperWebsite() {
        return paperWebsite;
    }

    public void setPaperWebsite(String paperWebsite) {
        this.paperWebsite = paperWebsite == null ? null : paperWebsite.trim();
    }

    public String getPaperModel() {
        return paperModel;
    }

    public void setPaperModel(String paperModel) {
        this.paperModel = paperModel == null ? null : paperModel.trim();
    }

    public String getPaperDescription() {
        return paperDescription;
    }

    public void setPaperDescription(String paperDescription) {
        this.paperDescription = paperDescription == null ? null : paperDescription.trim();
    }

    public String getPaperCode() {
        return paperCode;
    }

    public void setPaperCode(String paperCode) {
        this.paperCode = paperCode == null ? null : paperCode.trim();
    }

    public Float getPaperScore() {
        return paperScore;
    }

    public void setPaperScore(Float paperScore) {
        this.paperScore = paperScore;
    }

    public Date getPaperTime() {
        return paperTime;
    }

    public void setPaperTime(Date paperTime) {
        this.paperTime = paperTime;
    }
}