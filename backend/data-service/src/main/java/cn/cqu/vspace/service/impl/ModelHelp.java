package cn.cqu.vspace.service.impl;

import java.util.Objects;

public class ModelHelp {
    private String modelName;
    private Integer params;
    private Integer flops;

    public String getModelName() {
        return modelName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModelHelp modelHelp = (ModelHelp) o;
        return modelName.equals(modelHelp.modelName) && params.equals(modelHelp.params) && flops.equals(modelHelp.flops);
    }

    @Override
    public int hashCode() {
        return (modelName+params+flops).hashCode();
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Integer getParams() {
        return params;
    }

    public void setParams(Integer params) {
        this.params = params;
    }

    public Integer getFlops() {
        return flops;
    }

    public void setFlops(Integer flops) {
        this.flops = flops;
    }

    public ModelHelp(String modelName, Integer params, Integer flops) {
        this.modelName = modelName;
        this.params = params;
        this.flops = flops;
    }
}
