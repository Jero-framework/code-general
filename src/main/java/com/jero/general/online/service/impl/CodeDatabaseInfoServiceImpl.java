package com.jero.general.online.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jero.general.online.entity.CodeDatabaseInfoEO;
import com.jero.general.online.dao.CodeDatabaseInfoMapper;
import com.jero.general.online.service.CodeDatabaseInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* 表对应的数据库属性实现类
*
* @author hzwlsoft
* @date 2020-04-26
*/
@Service
@Transactional
public class CodeDatabaseInfoServiceImpl extends ServiceImpl<CodeDatabaseInfoMapper, CodeDatabaseInfoEO> implements CodeDatabaseInfoService {

}
