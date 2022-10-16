package com.example.demo.dao;

import com.example.demo.entity.Submission;
import com.example.demo.entity.SubmissionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SubmissionMapper {
    long countByExample(SubmissionExample example);

    int deleteByExample(SubmissionExample example);

    int deleteByPrimaryKey(Integer submissionId);

    int insert(Submission record);

    int insertSelective(Submission record);

    List<Submission> selectByExample(SubmissionExample example);

    Submission selectByPrimaryKey(Integer submissionId);

    int updateByExampleSelective(@Param("record") Submission record, @Param("example") SubmissionExample example);

    int updateByExample(@Param("record") Submission record, @Param("example") SubmissionExample example);

    int updateByPrimaryKeySelective(Submission record);

    int updateByPrimaryKey(Submission record);
}