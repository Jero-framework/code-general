package com.jero.general.online.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jero.general.online.entity.CodeDatabaseInfoEO;
import com.jero.general.online.service.CodeDatabaseInfoService;
import com.jero.core.controller.BaseController;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
* @Description 表对应的数据库属性控制器
* @Author hzwlsoft
* @Date 2020-04-26
**/
@Api("表对应的数据库属性接口")
@RestController
@RequestMapping("/${restPath}/codeDatabaseInfo")
public class CodeDatabaseInfoController extends BaseController<CodeDatabaseInfoEO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CodeDatabaseInfoController.class);

    @Autowired
    private CodeDatabaseInfoService codeDatabaseInfoService;

    @ApiOperation("|CodeDatabaseInfoEO|查询表对应的数据库属性列表")
    @GetMapping(value = "/list", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage<List<CodeDatabaseInfoEO>> getList(CodeDatabaseInfoEO codeDatabaseInfo){
        List<CodeDatabaseInfoEO> codeDatabaseInfoList = super.list(codeDatabaseInfo);
        return Result.success(codeDatabaseInfoList);
    }

    @ApiOperation("|CodeDatabaseInfoEO|查询表对应的数据库属性分页")
    @GetMapping(value = "/page", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage<PageInfo<CodeDatabaseInfoEO>> getPage(CodeDatabaseInfoEO codeDatabaseInfo, PageInfo pageInfo){
        PageInfo<CodeDatabaseInfoEO> codeDatabaseInfoPage = super.page(pageInfo, codeDatabaseInfo);
        return Result.success(codeDatabaseInfoPage);
    }

    @ApiOperation("|CodeDatabaseInfoEO|查询表对应的数据库属性详情")
    @GetMapping(value = "/get/{id}")
    public ResponseMessage<CodeDatabaseInfoEO> get(@NotNull @PathVariable Serializable id){
        return Result.success(super.getById(id));
    }

    @ApiOperation("|CodeDatabaseInfoEO|添加新表对应的数据库属性")
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage<Boolean> add(@RequestBody CodeDatabaseInfoEO codeDatabaseInfo){
        return Result.success(super.save(codeDatabaseInfo));
    }

    @ApiOperation("|CodeDatabaseInfoEO|修改表对应的数据库属性")
    @PostMapping(value = "/modify", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage<Boolean> modify(@RequestBody CodeDatabaseInfoEO codeDatabaseInfo){
        return Result.success(super.update(codeDatabaseInfo));
    }

    @ApiOperation("|CodeDatabaseInfoEO|删除表对应的数据库属性")
    @PostMapping(value = "/delete/{ids}")
    public ResponseMessage<Boolean> delete(@NotNull @PathVariable Serializable... ids){
        return Result.success(super.deleteBatchIds(ids));
    }

    @Override
    protected void expandQuery(QueryWrapper query) {

    }

    @Override
    protected void verifySaveData(CodeDatabaseInfoEO data) {

    }

    @Override
    protected void verifyUpdateData(CodeDatabaseInfoEO data) {

    }

    @Override
    protected IService<CodeDatabaseInfoEO> getService() {
        return codeDatabaseInfoService;
    }

}
