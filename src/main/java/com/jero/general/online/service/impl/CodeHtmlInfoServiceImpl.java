package com.jero.general.online.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jero.general.online.entity.CodeHtmlInfoEO;
import com.jero.general.online.dao.CodeHtmlInfoMapper;
import com.jero.general.online.service.CodeHtmlInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* 表对应的html页面属性实现类
*
* @author hzwlsoft
* @date 2020-04-26
*/
@Service
@Transactional
public class CodeHtmlInfoServiceImpl extends ServiceImpl<CodeHtmlInfoMapper, CodeHtmlInfoEO> implements CodeHtmlInfoService {

}
