package org.chisj.weight.dao;

import org.chisj.weight.pojo.Record;

import java.util.List;
import java.util.Map;

public interface RecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Record record);

    int insertSelective(Record record);

    Record selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);

    /**
     * 根据条件查询体重记录
     *
     * @param param
     * @return
     */
    List<Map<String,Object>> recordShowAll(Map<String, Object> param);
}