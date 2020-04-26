package com.jero.general.online.controller;

import com.jero.general.online.service.CodeAllInfoService;
import com.jero.general.online.vo.CodeAllInfoVO;
import com.jero.http.ResponseMessage;
import com.jero.http.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Description 代码生成器所有信息的控制器
 * @Author lixuetao
 * @Date 2020/4/26
 **/
@Api("代码生成器所有信息的对接接口")
@RestController
@RequestMapping("/${restPath}/codeAllInfo")
public class CodeAllInfoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CodeAllInfoController.class);

    @Autowired
    CodeAllInfoService allInfoService;

    @ApiOperation("|CodeAllInfoVO|添加代码生成器所有字段")
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage add(@RequestBody @Valid CodeAllInfoVO allInfoVO){
        allInfoService.add(allInfoVO);
        return Result.success();
    }

}
