package com.xu.nk_community.dao;

import com.xu.nk_community.pojo.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    //查询所有用户，考虑到分页情况
    List<DiscussPost> selectDiscussPosts(@Param("userId") int userId,@Param("offset")int offset,@Param("limit")int limit);

    //查询所有用户的数量，便于分页
    int selectDiscussPostRows(@Param("userId") int userId);
}
