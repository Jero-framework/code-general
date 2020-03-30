package ${package.ServiceImpl};

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ${package.Entity}.${entity}EO;
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;

/**
* ${table.comment!}实现类
*
* @author ${author}
* @date ${date}
*/
@Service
public class ${entity}ServiceImpl extends ServiceImpl<${entity}Mapper, ${entity}EO> implements ${entity}Service {

}
