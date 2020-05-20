package com.jero.general.local.mp;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.jero.general.local.mp.utils.DBTypeConstant;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 继承Mybatis plus的代码生成器
 *
 * @Author lixuetao
 * @Date 2020/3/30
 **/
public class  CodeGenerator {

    private static String parentPackage = "com.jero.business";  //TODO 请在此处填写包名
    private static String moduleName = "enterprise.position";    //TODO 请在此处填写模块
    private static String author = "lixuetao";    //TODO 请在此处填写作者
    private static String projectPath = "G:\\1";    //TODO 请在此处修改代码生成路径
    private static String[] tableNames = new String[] {"hzwl_enterprise_position"};    //TODO 请在此处填写需要生成代码的数据库表名
    private static String[] tablePrefix = new String[] { "SYS_", "TS_", "V_" , "hzwl_"};    //表前缀

    private static String dbType = DBTypeConstant.MYSQL_8; //数据库类型，包含MYSQL_5、MYSQL_8、ORACLE三种

    //TODO 请在此处填写数据库链接、账号、密码
    private static String url = "jdbc:mysql://10.0.3.44:3306/employment_business?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";    //数据源url
    private static String username = "root";    //数据源连接用户名
    private static String password = "123456";    //数据源连接密码

    public static void main(String[] args) {

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(author);
        gc.setOpen(false);
        gc.setSwagger2(true); //实体属性 Swagger2 注解
        gc.setBaseColumnList(true);
        gc.setBaseResultMap(true);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setFileOverride(true);
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
//        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);

        dsc.setDriverName(dbType);
        dsc.setUsername(username);
        dsc.setPassword(password);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(moduleName);
        pc.setParent(parentPackage);
        pc.setMapper("dao");
        mpg.setPackageInfo(pc);

        // 如果模板引擎是 freemarker
        String mapperTemplatePath = "/templates/mapper.xml.ftl";
        String entityTemplatePath = "/templates/entity.java.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(mapperTemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                String moduleNameFinal = moduleName.replace(".", "/");
                return projectPath + "/src/main/resources/mybatis/mapper/" + moduleNameFinal+ "/" + tableInfo.getEntityName() + "Mapper" +
                        StringPool.DOT_XML;
            }
        });
        focList.add(new FileOutConfig(entityTemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                String moduleNameFinal = moduleName.replace(".", "/");
                String parentPackageFinal = parentPackage.replace(".", "/");
                return projectPath + "/src/main/java/" + parentPackageFinal + "/" + moduleNameFinal + "/entity/" + tableInfo.getEntityName() + "EO" +
                        StringPool.DOT_JAVA;
            }
        });

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        templateConfig.setEntity(null);
//        templateConfig.setService(null);
//        templateConfig.setServiceImpl(null);
//        templateConfig.setController(null);
//        templateConfig.setMapper(null);
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setControllerMappingHyphenStyle(false);
        strategy.setEntityTableFieldAnnotationEnable(true);
        strategy.setEntityColumnConstant(true);
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(false);
        strategy.setEntitySerialVersionUID(true);
        strategy.setInclude(tableNames);
        // 公共父类
        strategy.setSuperControllerClass("com.jero.core.controller");
        strategy.setTablePrefix(tablePrefix);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

}
