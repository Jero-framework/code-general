package com.jero.general.online.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jero.general.online.entity.CodeIndexInfoEO;
import com.jero.general.online.service.CodeIndexInfoService;
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
* @Description 表对应的索引信息控制器
* @Author hzwlsoft
* @Date 2020-04-26
**/
@Api("表对应的索引信息接口")
@RestController
@RequestMapping("/${restPath}/codeIndexInfo")
@Slf4j
public class CodeIndexInfoController extends BaseController<CodeIndexInfoEO> {

    @Autowired
    private CodeIndexInfoService codeIndexInfoService;

    @ApiOperation("|CodeIndexInfoEO|查询表对应的索引信息列表")
    @GetMapping(value = "/list", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage<List<CodeIndexInfoEO>> getList(CodeIndexInfoEO codeIndexInfo){
        List<CodeIndexInfoEO> codeIndexInfoList = super.list(codeIndexInfo);
        return Result.success(codeIndexInfoList);
    }

    @ApiOperation("|CodeIndexInfoEO|查询表对应的索引信息分页")
    @GetMapping(value = "/page", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage<PageInfo<CodeIndexInfoEO>> getPage(CodeIndexInfoEO codeIndexInfo, PageInfo pageInfo){
        PageInfo<CodeIndexInfoEO> codeIndexInfoPage = super.page(pageInfo, codeIndexInfo);
        return Result.success(codeIndexInfoPage);
    }

    @ApiOperation("|CodeIndexInfoEO|查询表对应的索引信息详情")
    @GetMapping(value = "/get/{id}")
    public ResponseMessage<CodeIndexInfoEO> get(@NotNull @PathVariable Serializable id){
        return Result.success(super.getById(id));
    }

    @ApiOperation("|CodeIndexInfoEO|添加新表对应的索引信息")
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage<Boolean> add(@RequestBody CodeIndexInfoEO codeIndexInfo){
        return Result.success(super.save(codeIndexInfo));
    }

    @ApiOperation("|CodeIndexInfoEO|修改表对应的索引信息")
    @PostMapping(value = "/modify", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage<Boolean> modify(@RequestBody CodeIndexInfoEO codeIndexInfo){
        return Result.success(super.update(codeIndexInfo));
    }

    @ApiOperation("|CodeIndexInfoEO|删除表对应的索引信息")
    @PostMapping(value = "/delete/{ids}")
    public ResponseMessage<Boolean> delete(@NotNull @PathVariable Serializable... ids){
        return Result.success(super.deleteBatchIds(ids));
    }

    @Override
    protected void expandQuery(QueryWrapper query) {

    }

    @Override
    protected void verifySaveData(CodeIndexInfoEO data) {

    }

    @Override
    protected void verifyUpdateData(CodeIndexInfoEO data) {

    }

    @Override
    protected IService<CodeIndexInfoEO> getService() {
        return codeIndexInfoService;
    }

}
