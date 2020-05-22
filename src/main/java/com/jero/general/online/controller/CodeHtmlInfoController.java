package com.jero.general.online.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jero.general.online.entity.CodeHtmlInfoEO;
import com.jero.general.online.service.CodeHtmlInfoService;
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
* @Description 表对应的html页面属性控制器
* @Author hzwlsoft
* @Date 2020-04-26
**/
@Api("表对应的html页面属性接口")
@RestController
@RequestMapping("/${restPath}/codeHtmlInfo")
@Slf4j
public class CodeHtmlInfoController extends BaseController<CodeHtmlInfoEO> {


    @Autowired
    private CodeHtmlInfoService codeHtmlInfoService;

    @ApiOperation("|CodeHtmlInfoEO|查询表对应的html页面属性列表")
    @GetMapping(value = "/list", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage<List<CodeHtmlInfoEO>> getList(CodeHtmlInfoEO codeHtmlInfo){
        List<CodeHtmlInfoEO> codeHtmlInfoList = super.list(codeHtmlInfo);
        return Result.success(codeHtmlInfoList);
    }

    @ApiOperation("|CodeHtmlInfoEO|查询表对应的html页面属性分页")
    @GetMapping(value = "/page", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage<PageInfo<CodeHtmlInfoEO>> getPage(CodeHtmlInfoEO codeHtmlInfo, PageInfo pageInfo){
        PageInfo<CodeHtmlInfoEO> codeHtmlInfoPage = super.page(pageInfo, codeHtmlInfo);
        return Result.success(codeHtmlInfoPage);
    }

    @ApiOperation("|CodeHtmlInfoEO|查询表对应的html页面属性详情")
    @GetMapping(value = "/get/{id}")
    public ResponseMessage<CodeHtmlInfoEO> get(@NotNull @PathVariable Serializable id){
        return Result.success(super.getById(id));
    }

    @ApiOperation("|CodeHtmlInfoEO|添加新表对应的html页面属性")
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage<Boolean> add(@RequestBody CodeHtmlInfoEO codeHtmlInfo){
        return Result.success(super.save(codeHtmlInfo));
    }

    @ApiOperation("|CodeHtmlInfoEO|修改表对应的html页面属性")
    @PostMapping(value = "/modify", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage<Boolean> modify(@RequestBody CodeHtmlInfoEO codeHtmlInfo){
        return Result.success(super.update(codeHtmlInfo));
    }

    @ApiOperation("|CodeHtmlInfoEO|删除表对应的html页面属性")
    @PostMapping(value = "/delete/{ids}")
    public ResponseMessage<Boolean> delete(@NotNull @PathVariable Serializable... ids){
        return Result.success(super.deleteBatchIds(ids));
    }

    @Override
    protected void expandQuery(QueryWrapper query) {

    }

    @Override
    protected void verifySaveData(CodeHtmlInfoEO data) {

    }

    @Override
    protected void verifyUpdateData(CodeHtmlInfoEO data) {

    }

    @Override
    protected IService<CodeHtmlInfoEO> getService() {
        return codeHtmlInfoService;
    }

}
