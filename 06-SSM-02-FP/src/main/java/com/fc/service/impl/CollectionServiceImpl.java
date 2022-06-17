package com.fc.service.impl;

import com.fc.dao.CollectionMapper;
import com.fc.entity.Collection;
import com.fc.entity.CollectionExample;
import com.fc.service.CollectionService;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private CollectionMapper collectionMapper;

    @Override
    public ResultVo add(Collection collection) {
        if (collection.getCreateTime() == null){
            collection.setCreateTime(new Date());
        }
        ResultVo resultVo;
        int affection = collectionMapper.insertSelective(collection);
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
            int affection = collectionMapper.deleteByPrimaryKey(id);
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
    public ResultVo list(Integer pageNo, Integer pageSize, String name) {
        List<Collection> arrayList;
        PageInfo<Collection> userPageInfo;
        ResultVo resultVo ;
        PageHelper.startPage(pageNo, pageSize);
        try {
            if (name == null||name.equals("")){
                arrayList = collectionMapper.selectByExample(null);
            }else {
                CollectionExample collectionExample = new CollectionExample();
                CollectionExample.Criteria criteria = collectionExample.createCriteria();
                criteria.andNameLike("%"+name+"%");
                arrayList = collectionMapper.selectByExample(collectionExample);

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
    public ResultVo update(Collection collection) {
        ResultVo resultVo;
        int affection = collectionMapper.updateByPrimaryKeySelective(collection);
        if (affection == 1){
            resultVo = new ResultVo("用户修改成功!",collectionMapper.selectByPrimaryKey(collection.getId()),true,200);
        }else {
            resultVo = new ResultVo("用户修改失败!", null, false, 404);
        }
        return resultVo;
    }

}
