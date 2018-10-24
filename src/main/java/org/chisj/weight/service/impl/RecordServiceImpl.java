package org.chisj.weight.service.impl;

import com.github.pagehelper.PageHelper;
import org.chisj.weight.dao.RecordMapper;
import org.chisj.weight.pojo.Record;
import org.chisj.weight.service.RecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Auther: chisj chisj@foxmal.com
 * @Date: 2018-10-12 11:46
 * @Description:
 */
@Service("recordService")
public class RecordServiceImpl implements RecordService {

    @Resource
    private RecordMapper recordDao;


    /**
     * 添加体重记录
     *
     * @param record
     */
    @Override
    public int save(Record record) {
        return recordDao.insertSelective(record);
    }

    /**
     * 更新体重记录
     *
     * @param record
     * @return
     */
    @Override
    public int update(Record record) {
        return recordDao.updateByPrimaryKeySelective(record);
    }

    /**
     * 查询单个体重记录
     *
     * @param id
     * @return
     */
    @Override
    public Record showById(Integer id) {
        return recordDao.selectByPrimaryKey(id);
    }

    /**
     * 根据Id删除体重记录
     *
     * @param id
     * @return
     */
    @Override
    public int delete(Integer id) {
        return recordDao.deleteByPrimaryKey(id);
    }

    /**
     * 根据条件查询体重记录
     *
     * @param param
     * @return
     */
    @Override
    public List<Map<String, Object>> recordShowAll(Map<String, Object> param) {

        return recordDao.recordShowAll(param);
    }
}
