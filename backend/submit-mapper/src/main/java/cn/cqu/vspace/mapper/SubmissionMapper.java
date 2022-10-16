package cn.cqu.vspace.mapper;


import cn.cqu.vspace.pojo.Submission;
import cn.cqu.vspace.pojo.SubmissionExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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