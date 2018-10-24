package org.chisj.weight.service;

import org.chisj.weight.pojo.Record;

import java.util.List;
import java.util.Map;

/**
 * @Auther: chisj chisj@foxmal.com
 * @Date: 2018-10-12 11:46
 * @Description:
 */
public interface RecordService {

    /**
     * 添加体重记录
     */
    public int save(Record record);

    /**
     * 更新体重记录
     * @param record
     * @return
     */
    public int update(Record record);

    /**
     * 查询单个体重记录
     * @param id
     * @return
     */
    public Record showById(Integer id);

    /**
     * 根据Id删除体重记录
     * @param id
     * @return
     */
    public int delete(Integer id);

    /**
     * 根据条件查询体重记录
     * @param param
     * @return
     */
    public List<Map<String,Object>> recordShowAll(Map<String, Object> param);
}
