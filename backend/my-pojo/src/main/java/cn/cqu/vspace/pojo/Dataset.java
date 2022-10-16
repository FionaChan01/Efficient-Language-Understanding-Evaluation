package cn.cqu.vspace.pojo;

import java.io.Serializable;

public class Dataset implements Serializable {
    private Integer datasetId;

    private Integer taskId;

    private String datasetName;

    private String datasetEvalution;

    private String testsetUrl;

    private String datasetDescription;

    public Integer getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(Integer datasetId) {
        this.datasetId = datasetId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getDatasetName() {
        return datasetName;
    }

    public void setDatasetName(String datasetName) {
        this.datasetName = datasetName == null ? null : datasetName.trim();
    }

    public String getDatasetEvalution() {
        return datasetEvalution;
    }

    public void setDatasetEvalution(String datasetEvalution) {
        this.datasetEvalution = datasetEvalution == null ? null : datasetEvalution.trim();
    }

    public String getTestsetUrl() {
        return testsetUrl;
    }

    public void setTestsetUrl(String testsetUrl) {
        this.testsetUrl = testsetUrl == null ? null : testsetUrl.trim();
    }

    public String getDatasetDescription() {
        return datasetDescription;
    }

    public void setDatasetDescription(String datasetDescription) {
        this.datasetDescription = datasetDescription == null ? null : datasetDescription.trim();
    }
}