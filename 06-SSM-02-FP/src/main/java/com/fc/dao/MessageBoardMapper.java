package com.fc.dao;

import com.fc.entity.MessageBoard;
import com.fc.entity.MessageBoardExample;
import com.fc.entity.MessageBoardWithBLOBs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageBoardMapper {
    int rPicture(@Param("picture") String picture,@Param("id") long id);

    int upReply(@Param("reply") String reply,@Param("id") long id);

    long countByExample(MessageBoardExample example);

    int deleteByExample(MessageBoardExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MessageBoardWithBLOBs record);

    int insertSelective(MessageBoardWithBLOBs record);

    List<MessageBoardWithBLOBs> selectByExampleWithBLOBs(MessageBoardExample example);

    List<MessageBoard> selectByExample(MessageBoardExample example);

    MessageBoardWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MessageBoardWithBLOBs record, @Param("example") MessageBoardExample example);

    int updateByExampleWithBLOBs(@Param("record") MessageBoardWithBLOBs record, @Param("example") MessageBoardExample example);

    int updateByExample(@Param("record") MessageBoard record, @Param("example") MessageBoardExample example);

    int updateByPrimaryKeySelective(MessageBoardWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MessageBoardWithBLOBs record);

    int updateByPrimaryKey(MessageBoard record);
}