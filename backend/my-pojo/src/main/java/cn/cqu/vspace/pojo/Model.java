package cn.cqu.vspace.pojo;

public class Model {
    private Integer modelId;

    private Integer paperId;

    private Float modelRemark;

    private Integer modelFlops;

    private Integer modelParams;

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

    public Integer getModelFlops() {
        return modelFlops;
    }

    public void setModelFlops(Integer modelFlops) {
        this.modelFlops = modelFlops;
    }

    public Integer getModelParams() {
        return modelParams;
    }

    public void setModelParams(Integer modelParams) {
        this.modelParams = modelParams;
    }

    public String getModelDescription() {
        return modelDescription;
    }

    public void setModelDescription(String modelDescription) {
        this.modelDescription = modelDescription == null ? null : modelDescription.trim();
    }
}