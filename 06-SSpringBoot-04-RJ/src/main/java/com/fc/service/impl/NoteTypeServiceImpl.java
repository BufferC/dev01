package com.fc.service.impl;

import com.fc.dao.TbNoteMapper;
import com.fc.dao.TbNoteTypeMapper;
import com.fc.entity.TbNote;
import com.fc.entity.TbNoteExample;
import com.fc.entity.TbNoteType;
import com.fc.entity.TbNoteTypeExample;
import com.fc.service.NoteTypeService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteTypeServiceImpl implements NoteTypeService {
    @Autowired
    private TbNoteTypeMapper tbNoteTypeDao;
    @Override
    public List<TbNoteType> selectTypeById(Integer id) {
        TbNoteTypeExample tbNoteTypeExample = new TbNoteTypeExample();
        TbNoteTypeExample.Criteria criteria = tbNoteTypeExample.createCriteria();
        criteria.andUserIdEqualTo(id);

        return tbNoteTypeDao.selectByExample(tbNoteTypeExample);
    }

    @Autowired
    private TbNoteMapper tbNoteDao;

    // 添加的时候虽然不需要日记的id，但是需要用户的id
    @Override
    public ResultVo add(String typeName, Integer userId) {
        ResultVo resultVO = new ResultVo();

        TbNoteType type = new TbNoteType();

        type.setUserId(userId);
        type.setTypeName(typeName);

        int affectedRows = tbNoteTypeDao.insertSelective(type);

        if (affectedRows > 0) {
            resultVO.setCode(1);
            resultVO.setMessage("添加成功");
            resultVO.setData(type.getId());
        } else {
            resultVO.setCode(0);
            resultVO.setMessage("添加失败");
        }

        return resultVO;
    }

    @Override
    public ResultVo update(TbNoteType noteType) {
        ResultVo resultVO = new ResultVo();

        int affectedRows = tbNoteTypeDao.updateByPrimaryKeySelective(noteType);

        if (affectedRows > 0) {
            resultVO.setCode(1);
            resultVO.setMessage("修改成功");
            resultVO.setData(noteType.getId());
        } else {
            resultVO.setCode(0);
            resultVO.setMessage("修改失败");
        }

        return resultVO;
    }

    @Override
    public int delete(Integer id) {
        TbNoteExample example = new TbNoteExample();

        TbNoteExample.Criteria criteria = example.createCriteria();

        criteria.andTypeIdEqualTo(id);

        List<TbNote> notes = tbNoteDao.selectByExample(example);

        int result = 0;

        // 如果要被删除的类型下还有日记，当前类型就不能删除
        if (notes.size() == 0) {
            result = tbNoteTypeDao.deleteByPrimaryKey(id);
        }

        return result;
    }
}
