package org.chisj.weight.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.chisj.weight.config.VariableConfig;
import org.chisj.weight.entity.ResultModel;
import org.chisj.weight.entity.ResultStatus;
import org.chisj.weight.pojo.Record;
import org.chisj.weight.service.RecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Auther: chisj chisj@foxmal.com
 * @Date: 2018-10-12 10:44
 * @Description: 体重记录控制器
 */
@RestController
@RequestMapping("/Record")
public class RecordController {

    @Resource
    private RecordService recordService;

    @Resource
    private VariableConfig variableConfig;

    /**
     * 添加体重记录
     */
    @RequestMapping(value = "/recordSave", method = RequestMethod.POST)
    public ResponseEntity<ResultModel> recordSave(Record record) {

        System.out.println("height = " + variableConfig.getHeight());

        float bmi = record.getWeight() / (variableConfig.getHeight() * variableConfig.getHeight());
        BigDecimal bd = new BigDecimal((float) bmi);
        // 保留两位小数, 尾数四舍五入
        bd = bd.setScale(2, 4);
        bmi = bd.floatValue();

        record.setBmi(bmi);
        System.out.println("bmi = " + bmi);

        recordService.save(record);

        return new ResponseEntity<>(ResultModel.ok(record), HttpStatus.OK);
    }

    /**
     * 修改体重记录
     */
    @RequestMapping(value = "/recordUpdate", method = RequestMethod.POST)
    public ResponseEntity<ResultModel> recordUpdate(Record record) {

        // 判断是否对体重进行修改
        if (record.getWeight() != null) {
            // 更新bmi
            float bmi = record.getWeight() / (variableConfig.getHeight() * variableConfig.getHeight());
            BigDecimal bd = new BigDecimal((float) bmi);
            // 保留两位小数, 尾数四舍五入
            bd = bd.setScale(2, 4);
            bmi = bd.floatValue();

            record.setBmi(bmi);
        }

        recordService.update(record);

        return new ResponseEntity<>(ResultModel.ok(record), HttpStatus.OK);
    }

    /**
     * 查看单个体重记录
     */
    @RequestMapping(value = "/recordShowById", method = RequestMethod.POST)
    public ResponseEntity<ResultModel> recordShowById(Integer id) {

        Record record = recordService.showById(id);

        return new ResponseEntity<>(ResultModel.ok(record), HttpStatus.OK);
    }

    /**
     * 删除体重记录
     */
    @RequestMapping(value = "/recordDel", method = RequestMethod.POST)
    public ResponseEntity<ResultModel> recordDel(Integer id) {

        Record  record = recordService.showById(id);
        if (record == null) {
            return new ResponseEntity<>(ResultModel.error(ResultStatus.OBJECT_NOT_FOUND), HttpStatus.NOT_FOUND);
        }

        int ret = recordService.delete(id);

        return new ResponseEntity<>(ResultModel.ok(record), HttpStatus.OK);
    }

    /**
     * 根据条件查询体重记录
     */
    @RequestMapping(value = "/recordShowAll", method = RequestMethod.POST)
    public ResponseEntity<ResultModel> recordShowAll(@RequestBody Map<String, Object> param) {

        Integer pageNum = (Integer) param.get("pageNum");
        Integer pageSize = (Integer) param.get("pageSize");

        if (pageNum == null) {
            pageNum = 1;
        }

        if (pageSize == null) {
            pageSize = 10;
        }

        System.out.println("pageNum = " + pageNum);
        System.out.println("pageSize = " + pageSize);

        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> records = recordService.recordShowAll(param);

        // 分页
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(records);

        return new ResponseEntity<>(ResultModel.ok(pageInfo), HttpStatus.OK);
    }
}
