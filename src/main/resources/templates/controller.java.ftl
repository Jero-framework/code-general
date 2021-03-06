package ${package.Controller};

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import ${package.Entity}.${entity}EO;
import ${package.Service}.${entity}Service;
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
* @Description ${table.comment!}控制器
* @Author ${author}
* @Date ${date}
**/
@Api("${table.comment!}接口")
@RestController
@RequestMapping("/${r'${restPath}'}/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
public class ${table.controllerName} extends BaseController<${entity}EO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(${table.controllerName}.class);

    @Autowired
    private ${table.serviceName} ${"${entity}"?uncap_first}Service;

    @ApiOperation("|${entity}EO|查询${table.comment!}列表")
    @GetMapping(value = "/list")
    public ResponseMessage<List<${entity}EO>> getList(${entity}EO ${"${entity}"?uncap_first}){
        List<${entity}EO> ${"${entity}List"?uncap_first} = super.list(${"${entity}"?uncap_first});
        return Result.success(${"${entity}List"?uncap_first});
    }

    @ApiOperation("|${entity}EO|查询${table.comment!}分页")
    @GetMapping(value = "/page")
    public ResponseMessage<PageInfo<${entity}EO>> getPage(${entity}EO ${"${entity}"?uncap_first}, PageInfo pageInfo){
        PageInfo<${entity}EO> ${"${entity}Page"?uncap_first} = super.page(pageInfo, ${"${entity}"?uncap_first});
        return Result.success(${"${entity}Page"?uncap_first});
    }

    @ApiOperation("|${entity}EO|查询${table.comment!}详情")
    @GetMapping(value = "/get/{id}")
    public ResponseMessage<${entity}EO> get(@NotNull @PathVariable Serializable id){
        return Result.success(super.getById(id));
    }

    @ApiOperation("|${entity}EO|添加新${table.comment!}")
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage<Boolean> add(@RequestBody ${entity}EO ${"${entity}"?uncap_first}){
        return Result.success(super.save(${"${entity}"?uncap_first}));
    }

    @ApiOperation("|${entity}EO|修改${table.comment!}")
    @PostMapping(value = "/modify", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage<Boolean> modify(@RequestBody ${entity}EO ${"${entity}"?uncap_first}){
        return Result.success(super.update(${"${entity}"?uncap_first}));
    }

    @ApiOperation("|${entity}EO|删除${table.comment!}")
    @PostMapping(value = "/delete/{ids}")
    public ResponseMessage<Boolean> delete(@NotNull @PathVariable Serializable... ids){
        return Result.success(super.deleteBatchIds(ids));
    }

    @Override
    protected void expandQuery(QueryWrapper query, ${entity}EO data) {

    }

    @Override
    protected void verifySaveData(${entity}EO data) {

    }

    @Override
    protected void verifyUpdateData(${entity}EO data) {

    }

    @Override
    protected IService<${entity}EO> getService() {
        return ${"${entity}"?uncap_first}Service;
    }

}
