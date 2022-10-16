package com.example.demo.dao;


import com.example.demo.entity.Dataset;
import com.example.demo.entity.DatasetExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DatasetMapper {
    long countByExample(DatasetExample example);

    int deleteByExample(DatasetExample example);

    int deleteByPrimaryKey(Integer datasetId);

    int insert(Dataset record);

    int insertSelective(Dataset record);

    List<Dataset> selectByExample(DatasetExample example);

    Dataset selectByPrimaryKey(Integer datasetId);

    int updateByExampleSelective(@Param("record") Dataset record, @Param("example") DatasetExample example);

    int updateByExample(@Param("record") Dataset record, @Param("example") DatasetExample example);

    int updateByPrimaryKeySelective(Dataset record);

    int updateByPrimaryKey(Dataset record);
}