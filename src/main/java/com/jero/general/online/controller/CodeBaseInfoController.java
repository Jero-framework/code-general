package com.jero.general.online.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jero.general.online.entity.CodeBaseInfoEO;
import com.jero.general.online.service.CodeBaseInfoService;
import com.jero.core.controller.BaseController;
import com.jero.http.ResponseMessage;
import com.jero.http.Result;
import com.jero.http.page.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
* @Description 代码生成基本字段控制器
* @Author hzwlsoft
* @Date 2020-04-26
**/
@Api("代码生成基本字段接口")
@RestController
@RequestMapping("/${restPath}/codeBaseInfo")
@Slf4j
public class CodeBaseInfoController extends BaseController<CodeBaseInfoEO> {

    @Autowired
    private CodeBaseInfoService codeBaseInfoService;

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

    @ApiOperation("|CodeBaseInfoEO|查询代码生成基本字段详情")
    @GetMapping(value = "/get/{id}")
    public ResponseMessage<CodeBaseInfoEO> get(@NotNull @PathVariable Serializable id){
        return Result.success(super.getById(id));
    }

    @ApiOperation("|CodeBaseInfoEO|添加新代码生成基本字段")
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage<Boolean> add(@RequestBody CodeBaseInfoEO codeBaseInfo){
        return Result.success(super.save(codeBaseInfo));
    }

    @ApiOperation("|CodeBaseInfoEO|修改代码生成基本字段")
    @PostMapping(value = "/modify", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage<Boolean> modify(@RequestBody CodeBaseInfoEO codeBaseInfo){
        return Result.success(super.update(codeBaseInfo));
    }

    @ApiOperation("|CodeBaseInfoEO|删除代码生成基本字段")
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
        return codeBaseInfoService;
    }

}
