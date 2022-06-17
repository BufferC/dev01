package com.fc.service.impl;

import com.fc.dao.AlleviationMapper;
import com.fc.entity.AlleviationExample;
import com.fc.entity.AlleviationWithBLOBs;
import com.fc.service.AlleviationService;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AlleviationServiceImpl implements AlleviationService {
    @Autowired
    private AlleviationMapper alleviationMapper;

    @Override
    public ResultVo add(AlleviationWithBLOBs alleviation) {
        ResultVo resultVo;
        int affection = alleviationMapper.insertSelective(alleviation);
        if (affection == 1){
            resultVo = new ResultVo("添加成功!",affection,true,200);
        }else {
            resultVo = new ResultVo("添加失败!",null,false,404);
        }
        return resultVo;
    }

    @Override
    public ResultVo update(AlleviationWithBLOBs alleviation) {
        ResultVo resultVo;
        int affection = alleviationMapper.updateByPrimaryKeySelective(alleviation);
        if (affection == 1){
            resultVo = new ResultVo("修改成功!",alleviationMapper.selectByPrimaryKey(alleviation.getId()),true,200);
        }else {
            resultVo = new ResultVo("修改失败!", null, false, 404);
        }
        return resultVo;
    }

    @Override
    public ResultVo del(Long id) {
        ResultVo resultVo;
        int affection = alleviationMapper.deleteByPrimaryKey(id);
        if (affection == 1){
            resultVo = new ResultVo("删除成功!",affection,true,200);
        }else {
            resultVo = new ResultVo("删除失败!",null,false,404);
        }
        return resultVo;
    }

    @Override
    public ResultVo list(Integer pageNo, Integer pageSize,String type) {
        List<AlleviationWithBLOBs> arrayList = null;
        PageInfo<AlleviationWithBLOBs> userPageInfo;
        ResultVo resultVo ;
        PageHelper.startPage(pageNo, pageSize);
        try {
            if (type == null||type.equals("")){
                arrayList = alleviationMapper.selectByExampleWithBLOBs(null);
                //DataVo<Object> dataVo = new DataVo<>();
            }else {
                AlleviationExample alleviationExample = new AlleviationExample();
                AlleviationExample.Criteria criteria = alleviationExample.createCriteria();
                criteria.andTypeLike("%"+type+"%");
                arrayList = alleviationMapper.selectByExampleWithBLOBs(alleviationExample);
            }
        }catch (Exception e){
            resultVo = new ResultVo("获取异常!",null,false,500);
        }
        userPageInfo = new PageInfo<>(arrayList);
        if (!arrayList.isEmpty()) {
            resultVo = new ResultVo("获取成功!", userPageInfo, true, 200);
        }else {
            resultVo = new ResultVo("获取失败!",null,false,404);
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
            Integer click = alleviationMapper.click(id, clickTime);

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
