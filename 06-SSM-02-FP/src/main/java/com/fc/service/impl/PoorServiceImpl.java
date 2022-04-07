package com.fc.service.impl;

import com.fc.dao.PoorMapper;
import com.fc.entity.Poor;
import com.fc.entity.PoorWithBLOBs;
import com.fc.service.PoorService;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PoorServiceImpl implements PoorService {
    @Autowired
    private PoorMapper poorMapper;
    @Override
    public ResultVo add(PoorWithBLOBs poor) {
        if (poor.getCreateTime() == null){
            poor.setCreateTime(new Date());
        }
        ResultVo resultVo;
        int affection = poorMapper.insertSelective(poor);
        if (affection == 1){
            resultVo = new ResultVo("添加成功!",affection,true,200);
        }else {
            resultVo = new ResultVo("添加失败!",null,false,404);
        }
        return resultVo;
    }

    @Override
    public ResultVo del(Long id) {
        ResultVo resultVo;
        int affection = poorMapper.deleteByPrimaryKey(id);
        if (affection == 1){
            resultVo = new ResultVo("删除成功!",affection,true,200);
        }else {
            resultVo = new ResultVo("删除失败!",null,false,404);
        }
        return resultVo;
    }

    @Override
    public ResultVo update(PoorWithBLOBs poor) {
        ResultVo resultVo;
        int affection = poorMapper.updateByPrimaryKeySelective(poor);
        if (affection == 1){
            resultVo = new ResultVo("用户修改成功!",poorMapper.selectByPrimaryKey(poor.getId()),true,200);
        }else {
            resultVo = new ResultVo("用户修改失败!", null, false, 404);
        }
        return resultVo;
    }

    @Override
    public ResultVo list(Integer pageNo, Integer pageSize,Long id) {
        List<Poor> arrayList;
        PageInfo<Poor> userPageInfo;
        ResultVo resultVo ;

        try {
            if (id == null){
                PageHelper.startPage(pageNo, pageSize);
                arrayList = poorMapper.selectByExample(null);
            }else {
                PoorWithBLOBs poor = poorMapper.selectByPrimaryKey(id);
                arrayList = new ArrayList<>();
                if(poor != null){
                    arrayList.add(poor);
                }
            }
            //DataVo<Object> dataVo = new DataVo<>();
            userPageInfo = new PageInfo<>(arrayList);
            if (userPageInfo.getPageNum() != 0) {
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
    public ResultVo click(Long id, Date clickTime) {
        ResultVo resultVo ;
        if(clickTime == null){
            clickTime = new Date();
        }
        if (id == null){
            return new ResultVo("请求参数异常",null,false,404);
        }

        try {
            Integer click = poorMapper.click(id, clickTime);

            if (click == 1){
                resultVo = new ResultVo("点击成功!", click, true, 200);
            }else {
                resultVo = new ResultVo("点击失败!",null,false,404);
            }
        }catch (Exception e){
            e.printStackTrace();
            resultVo = new ResultVo("执行异常",null,false,500);
        }

        return resultVo;
    }
}
