package com.jero.general.online.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jero.core.controller.BaseController;
import com.jero.general.online.entity.CodeBaseInfoEO;
import com.jero.general.online.service.CodeAllInfoService;
import com.jero.general.online.service.CodeBaseInfoService;
import com.jero.general.online.vo.CodeAllInfoVO;
import com.jero.http.ResponseMessage;
import com.jero.http.Result;
import com.jero.http.page.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @Description 代码生成器所有信息的控制器。查询和分页采用基础信息即可
 * @Author lixuetao
 * @Date 2020/4/26
 **/
@Api("代码生成器所有信息的对接接口")
@RestController
@RequestMapping("/${restPath}/codeAllInfo")
public class CodeAllInfoController extends BaseController<CodeBaseInfoEO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CodeAllInfoController.class);

    @Autowired
    CodeAllInfoService allInfoService;

    @Autowired
    CodeBaseInfoService baseInfoService;

    @ApiOperation("|CodeBaseInfoEO|查询代码生成基本字段列表")
    @GetMapping(value = "/list", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage<List<CodeBaseInfoEO>> getList(CodeBaseInfoEO codeBaseInfo){
        List<CodeBaseInfoEO> codeBaseInfoList = super.list(codeBaseInfo);
        return Result.success(codeBaseInfoList);
    }

    @ApiOperation("|CodeBaseInfoEO|查询代码生成基本字段分页")
    @GetMapping(value = "/page", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage<PageInfo<CodeBaseInfoEO>> getPage(CodeBaseInfoEO codeBaseInfo, PageInfo pageInfo){
        PageInfo<CodeBaseInfoEO> codeBaseInfoPage = super.page(pageInfo, codeBaseInfo);
        return Result.success(codeBaseInfoPage);
    }

    @ApiOperation("|CodeAllInfoVO|添加代码生成器所有字段")
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage add(@RequestBody @Valid CodeAllInfoVO allInfoVO){
        allInfoService.add(allInfoVO);
        return Result.success();
    }

    @ApiOperation("|CodeAllInfoVO|修改代码生成器所有字段")
    @PostMapping(value = "/modify", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage<Boolean> modify(@RequestBody @Valid CodeAllInfoVO allInfoVO){

        return Result.success();
    }

    @ApiOperation("|CodeAllInfoVO|删除代码生成器所有字段")
    @PostMapping(value = "/delete/{ids}")
    public ResponseMessage<Boolean> delete(@NotNull @PathVariable Serializable... ids){
        return Result.success(super.deleteBatchIds(ids));
    }

    @Override
    protected void expandQuery(QueryWrapper query) {

    }

    @Override
    protected void verifySaveData(CodeBaseInfoEO data) {

    }

    @Override
    protected void verifyUpdateData(CodeBaseInfoEO data) {

    }

    @Override
    protected IService<CodeBaseInfoEO> getService() {
        return baseInfoService;
    }
}
