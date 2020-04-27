package com.jero.general.online.service.impl;

import com.jero.general.online.controller.CodeAllInfoController;
import com.jero.general.online.controller.CodeIndexInfoController;
import com.jero.general.online.service.CodeAllInfoService;
import com.jero.general.online.service.CodeBaseInfoService;
import com.jero.general.online.service.CodeDatabaseInfoService;
import com.jero.general.online.service.CodeHtmlInfoService;
import com.jero.general.online.service.CodeIndexInfoService;
import com.jero.general.online.vo.CodeAllInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description 全部信息数据管理实现类
 * @Author lixuetao
 * @Date 2020/4/26
 **/
@Service
@Transactional
public class CodeAllInfoServiceImpl implements CodeAllInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CodeAllInfoServiceImpl.class);

    @Autowired
    private CodeBaseInfoService baseInfoService;

    @Autowired
    private CodeDatabaseInfoService databaseInfoService;

    @Autowired
    private CodeHtmlInfoService htmlInfoService;

    @Autowired
    private CodeIndexInfoService indexInfoService;

    public void add(CodeAllInfoVO allInfoVO){
        baseInfoService.save(allInfoVO.getBaseInfoEO());
        //得到基础信息的id，赋予给其他的字段
        Long primaryKey = allInfoVO.getBaseInfoEO().getId();

        allInfoVO.getDatabaseInfoEOS().forEach(item -> item.setBaseInfoId(primaryKey));
        databaseInfoService.saveBatch(allInfoVO.getDatabaseInfoEOS());

        allInfoVO.getHtmlInfoEOS().forEach(item -> item.setBaseInfoId(primaryKey));
        htmlInfoService.saveBatch(allInfoVO.getHtmlInfoEOS());

        allInfoVO.getIndexInfoEOS().forEach(item -> item.setBaseInfoId(primaryKey));
        indexInfoService.saveBatch(allInfoVO.getIndexInfoEOS());
    }

    /**
     * 删掉所有附表数据，重新添加
     * @param allInfoVO
     */
    public void modify(CodeAllInfoVO allInfoVO){
        baseInfoService.updateById(allInfoVO.getBaseInfoEO());

        //得到基础信息的id，赋予首次添加的数据
        Long primaryKey = allInfoVO.getBaseInfoEO().getId();

        allInfoVO.getDatabaseInfoEOS().forEach(item -> {
            if (item.getBaseInfoId() == null){
                item.setBaseInfoId(primaryKey);
            }
        });
        databaseInfoService.saveOrUpdateBatch(allInfoVO.getDatabaseInfoEOS());

        allInfoVO.getHtmlInfoEOS().forEach(item -> {
            if (item.getBaseInfoId() == null){
                item.setBaseInfoId(primaryKey);
            }
        });
        htmlInfoService.saveOrUpdateBatch(allInfoVO.getHtmlInfoEOS());

        allInfoVO.getIndexInfoEOS().forEach(item -> {
            if (item.getBaseInfoId() == null){
                item.setBaseInfoId(primaryKey);
            }
        });
        indexInfoService.saveOrUpdateBatch(allInfoVO.getIndexInfoEOS());
    }

}
