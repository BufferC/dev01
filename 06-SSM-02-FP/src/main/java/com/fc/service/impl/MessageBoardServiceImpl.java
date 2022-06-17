package com.fc.service.impl;

import com.fc.dao.MessageBoardMapper;
import com.fc.entity.MessageBoardExample;
import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.service.MessageBoardService;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageBoardServiceImpl implements MessageBoardService {
    @Autowired
    private MessageBoardMapper messageBoardMapper;

    @Override
    public ResultVo add(MessageBoardWithBLOBs messageBoard) {
        if (messageBoard.getCreateTime() == null){
            messageBoard.setCreateTime(new Date());
        }
        ResultVo resultVo;
        int affection = messageBoardMapper.insertSelective(messageBoard);
        try {
            if (affection == 1){
                resultVo = new ResultVo("添加成功!",affection,true,200);
            }else {
                resultVo = new ResultVo("添加失败!",null,false,404);
            }
        }catch (Exception e){
            e.printStackTrace();
            resultVo = new ResultVo("添加参数异常!",null,false,404);
        }
        return resultVo;
    }

    @Override
    public ResultVo del(Long id) {
        ResultVo resultVo;
        try {
            int affection = messageBoardMapper.deleteByPrimaryKey(id);
            if (affection == 1){
                resultVo = new ResultVo("用户删除成功!",affection,true,200);
            }else {
                resultVo = new ResultVo("用户删除失败!",null,false,404);
            }
        }catch (Exception e){
            e.printStackTrace();
            resultVo = new ResultVo("参数异常!",null,false,404);
        }
        return resultVo;
    }

    @Override
    public ResultVo list(Integer pageNo, Integer pageSize,String username) {
        List<MessageBoardWithBLOBs> arrayList;
        PageInfo<MessageBoardWithBLOBs> userPageInfo;
        ResultVo resultVo ;
        PageHelper.startPage(pageNo, pageSize);
        try {
            if (username == null||username.equals("")){
                arrayList = messageBoardMapper.selectByExampleWithBLOBs(null);
            }else {
                MessageBoardExample messageBoardExample = new MessageBoardExample();
                MessageBoardExample.Criteria criteria = messageBoardExample.createCriteria();
                criteria.andUsernameLike("%"+username+"%");
                arrayList = messageBoardMapper.selectByExampleWithBLOBs(messageBoardExample);
            }
            //DataVo<Object> dataVo = new DataVo<>();
            userPageInfo = new PageInfo<>(arrayList);
            if (!arrayList.isEmpty()) {
                resultVo = new ResultVo("用户获取成功!", userPageInfo, true, 200);
            }else {
                resultVo = new ResultVo("用户获取失败!",null,false,404);
            }
        }catch (Exception e){
            resultVo = new ResultVo("用户获取异常!",null,false,500);
        }

        return resultVo;
    }

    @Override
    public ResultVo reply(MessageBoardWithBLOBs messageBoardWithBLOBs/*, String isDel*/) {
        if (messageBoardWithBLOBs.getId() == null){
            return new ResultVo("请求参数异常",null,false,404);
        }
        /*//删除回复
        int delReply = -86;*/
        //修改
        int upReply ;

        ResultVo resultVo;

        try{
            //不删除,只修改
            /*if (isDel == null || isDel.equals("false")||isDel.equals("")){*/
                /*upReply = messageBoardMapper.updateByPrimaryKeyWithBLOBs(messageBoardWithBLOBs);*/
                upReply = messageBoardMapper.updateByPrimaryKeySelective(messageBoardWithBLOBs);
          /*  }else if(messageBoardWithBLOBs.getReply()== null){//删除，修改
                delReply = messageBoardMapper.upReply(messageBoardWithBLOBs.getId(), messageBoardWithBLOBs.getReplyPicture());
            }else {//只修改，不删除
                upReply = messageBoardMapper.updateByPrimaryKeyWithBLOBs(messageBoardWithBLOBs);
            }*/

            if (/*delReply != -86 || */upReply != 0){
                resultVo = new ResultVo("修改成功!",1, true, 200);
            }else {
                resultVo = new ResultVo("修改失败!",null,false,404);
            }
        }catch (Exception e){
            e.printStackTrace();
            resultVo = new ResultVo("执行异常",null,false,500);
        }
        return resultVo;
    }
}
