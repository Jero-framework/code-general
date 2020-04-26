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
        databaseInfoService.save(allInfoVO.getDatabaseInfoEO());
        htmlInfoService.save(allInfoVO.getHtmlInfoEO());
        indexInfoService.save(allInfoVO.getIndexInfoEO());
    }

}
