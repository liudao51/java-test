package com.liudao51.test.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * MyBatisPlus代码生成器（可以快速生成 Entity、Mapper、Mapper XML、Service、Controller 等各个模块的代码）
 * 参考：
 * MyBatis-Plus代码生成器：https://baomidou.com/guide/generator.html
 * mybatis-plus自动生成代码到相应的model: https://blog.csdn.net/qq_32331997/article/details/74908570
 */
public class MyBatisPlusCodeGenerator {

    //项目路径
    private static String projectPath = "";

    /**
     * 读取控制台内容
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        try {
            projectPath = new File("").getCanonicalPath() + "/MybatisPlus-Test";
        } catch (IOException e) {
            e.printStackTrace();
        }

        //1.全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setFileOverride(false); //已存在相同文件时是否覆盖
        //gc.setActiveRecord(true);  // 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);  // XML 二级缓存
        gc.setBaseResultMap(true);  // XML ResultMap
        gc.setBaseColumnList(false);  // XML columList
        gc.setSwagger2(true);    //实体属性 Swagger2 注解
        gc.setOpen(false);   //生成后打开文件夹
        gc.setAuthor("Jewel"); //设置文件作者
        //---自定义文件名（%s会自动填充为表实体属性）
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("I%sService");
        gc.setServiceImplName("%sServerImpl");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);


        //2.数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        //dsc.setTypeConvert(new MySqlTypeConvert());
        dsc.setUrl("jdbc:mysql://192.168.99.131:3306/liudao51_test?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        // dsc.setSchemaName("public");
        mpg.setDataSource(dsc);


        //3.包配置
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName(scanner("模块名"));
        pc.setParent("com.liudao51.test");
        pc.setEntity("pojo.po");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setController("controller");
        mpg.setPackageInfo(pc);


        //4.策略配置
        StrategyConfig strategy = new StrategyConfig();
        //---设置数据库表
        strategy.setTablePrefix("mp_"); //设置表名前缀，支持多个
        strategy.setNaming(NamingStrategy.underline_to_camel); //表名生成策略
        //strategy.setInclude("");  //需要生成的表，支持多个
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(",")); //需要生成的表,这里使用从控制台读取
        //strategy.setExclude(new String[]{"test"}); // 排除生成的表
        //strategy.setColumnNaming(NamingStrategy.underline_to_camel); //列名生成策略
        //---设置entity类
        //strategy.setSuperEntityClass(); //你自己的父类实体,没有就不用设置
        strategy.setSuperEntityColumns(null); //写于父类中的公共字段
        strategy.setEntityLombokModel(true); //实体设置lombok
        strategy.setVersionFieldName("version"); //设置乐观锁字段名
        strategy.setLogicDeleteFieldName("deleted"); //设置逻辑删除字段名
        //---设置自动填充
        TableFill createdTime = new TableFill("created_time", FieldFill.INSERT);
        TableFill updatedTime = new TableFill("updated_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(createdTime);
        tableFills.add(updatedTime);
        strategy.setTableFillList(tableFills);
        // ---设置mapper类
        // strategy.setSuperMapperClass("com.liudao51.test.mapper.BaseMapper");
        // ---设置service类
        //strategy.setSuperServiceClass("");
        //strategy.setSuperServiceImplClass("");
        //---设置controller类
        //strategy.setSuperControllerClass(""); //你自己的父类控制器,没有就不用设置
        strategy.setRestControllerStyle(true); //控制器使用restful风格，如：localhost:8080/hello/id/2
        //strategy.setControllerMappingHyphenStyle(true); //设置路径参数风格，如：localhost:8080/hello_id_2
        mpg.setStrategy(strategy);


        //5.自定义配置
        //---自定义属性注入
        InjectionConfig cfg = new InjectionConfig() {
            //自定义属性注入:abc
            //在.ftl(或者是.vm)模板中，通过${cfg.abc}获取属性
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };

        //---自定义文件输出配置(自定义配置会被优先输出)
        //设置模板引擎为freemarker
        //String templatePath = "/templates/mapper.xml.ftl";
        //设置模板引擎为velocity（默认）
        String templatePath = "/templates/mapper.xml.vm";

        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String moduleNamePath = (pc.getModuleName() != null && !"".equals(pc.getModuleName().trim())) ? pc.getModuleName().trim() + "/" : "";
                //自定义输出文件名，如果你的Entity设置了前后缀，此处注意xml的名称会跟着发生变化
                return projectPath + moduleNamePath + "/src/main/java/com/liudao51/test/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录，自定义目录用");
                if (fileType == FileType.MAPPER) {
                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                    return !new File(filePath).exists();
                }
                // 允许生成模板文件
                return true;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        //设置模板引擎
        //如果您选择了非默认引擎velocity，需要在 AutoGenerator 中 设置模板引擎
        //如：设置模板引擎freemarker
        //mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        //---自定义模板配置
        //可以 copy 源码 mybatis-plus/src/main/resources/template 下面内容修改，并放置自己项目的 src/main/resources/template 目录下
        //在指定自定义模板路径位置：/resources/templates/entity2.java.vm(或.ftl)时，注意不要带上.ftl/.vm, 程序会根据使用的模板引擎自动识别
        TemplateConfig tc = new TemplateConfig();
        tc.setEntity("mp_templates/entity.java");  //注意这里设置的值不要带上.vm/.ftl, 程序会根据使用的模板引擎自动识别
        tc.setMapper("mp_templates/mapper.java");
        tc.setXml(null);  //不在mapper文件夹下生成*Mapper.xml文件,改用通过<自定义属性注入>设置生成resources/mapper/*Mapper.xml文件
        tc.setService("mp_templates/service.java");
        tc.setServiceImpl("mp_templates/serviceImpl.java");
        tc.setController("mp_templates/controller.java");
        //如上任何一个模块如果设置为空字符串(或null)，则将不生成该模块
        mpg.setTemplate(tc);


        //6.执行生成
        mpg.execute();

        // 打印注入设置【可无】
        //System.err.println(mpg.getCfg().getMap().get("abc"));
    }

}
