package com.rickren.mpinaction.config.generator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * TODO
 *
 * @author rickren
 * @date 2022/7/22 11:32
 * @since
 */
public class MybatisPlusGenerator {

    public static void main(String[] args) {
        fastGenerate();
    }
    /**
     * 数据源配置
     */
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;CASE_INSENSITIVE_IDENTIFIERS=TRUE;MODE=MYSQL", "sa", "");

    /**
     * 交互式生成 可配置性更强
     */
    private static void generateByScanner() {
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                // 全局配置
                .globalConfig((scanner, builder) -> builder.author(scanner.apply("请输入作者名称？")).fileOverride())
                // 包配置
                .packageConfig((scanner, builder) -> builder.parent(scanner.apply("请输入包名？")))
                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
                        .controllerBuilder().enableRestStyle().enableHyphenStyle()
                        .entityBuilder().enableLombok().addTableFills(
                                new Column("create_time", FieldFill.INSERT)
                        ).build())
                /*
                    模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                   .templateEngine(new BeetlTemplateEngine())
                   .templateEngine(new FreemarkerTemplateEngine())
                 */
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }

    /**
     * 快速生成 但是有些策略不支持
     */
    private static void fastGenerate() {
        String url = "jdbc:mysql://127.0.0.1:3306/rickren?characterEncoding=UTF-8&useSSL=false&characterSetResults=utf8&autoReconnect=true&failOverReadOnly=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false";
        String username = "root";
        String password = "rootroot";
        System.out.println(System.getProperty("user.dir") + "/jdk17-in-action/src/main/java");
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("rickren") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            //.fileOverride() // 覆盖已生成文件
                            .outputDir(System.getProperty("user.dir") + "/jdk17-in-action/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder
                            .parent("com.rickren.jdk17inaction") // 设置父包名
                            .moduleName("user") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,
                                    System.getProperty("user.dir") + "/jdk17-in-action/src/main/resources/mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_")// 设置过滤表前缀
                            .controllerBuilder()
                            .enableRestStyle()//开启rest风格
                            .enableHyphenStyle(); //开启下划线转驼峰

                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }

}
