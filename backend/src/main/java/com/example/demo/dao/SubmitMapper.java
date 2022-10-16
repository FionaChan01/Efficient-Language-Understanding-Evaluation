package com.example.demo.dao;

import com.example.demo.entity.Submit;
import com.example.demo.entity.SubmitExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SubmitMapper {
    long countByExample(SubmitExample example);

    int deleteByExample(SubmitExample example);

    int deleteByPrimaryKey(Integer submitId);

    int insert(Submit record);

    int insertSelective(Submit record);

    List<Submit> selectByExample(SubmitExample example);

    Submit selectByPrimaryKey(Integer submitId);

    int updateByExampleSelective(@Param("record") Submit record, @Param("example") SubmitExample example);

    int updateByExample(@Param("record") Submit record, @Param("example") SubmitExample example);

    int updateByPrimaryKeySelective(Submit record);

    int updateByPrimaryKey(Submit record);
}