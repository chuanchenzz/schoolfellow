package com.chuanchen.dao;

import com.chuanchen.entity.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chuanchenwine on 2017/5/1.
 */
public interface ProjectMapper {

    int getTotalCount();

    List<Project> findProjectList(@Param("begin") int begin,@Param("limit") int limit,@Param("type") int type);

    Project findProjectById(@Param("id") int id);

    int deleteProject(@Param("id") int id);
}
