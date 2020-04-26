package com.jero.general.online.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jero.general.online.entity.CodeIndexInfoEO;
import com.jero.general.online.dao.CodeIndexInfoMapper;
import com.jero.general.online.service.CodeIndexInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* 表对应的索引信息实现类
*
* @author hzwlsoft
* @date 2020-04-26
*/
@Service
@Transactional
public class CodeIndexInfoServiceImpl extends ServiceImpl<CodeIndexInfoMapper, CodeIndexInfoEO> implements CodeIndexInfoService {

}
