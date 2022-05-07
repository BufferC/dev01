package com.fc.test;

import org.junit.Test;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.util.HashMap;

public class ThymeleafTest {
    // 渲染静态数据，没啥用
    @Test
    public void testRenderStaticData() {
        // 创建模板引擎对象
        TemplateEngine engine = new TemplateEngine();

        // th:后面跟上属性名就是thymeleaf所支持的标签
        // 能够被模板引擎渲染的内容就是标签中的内容
        // 有点类似jsp中的${username}能够被jsp所渲染
        // 以后会见到非常多个th:
        // 准备一个模板
        String template = "<input type='text' th:value='易烊千玺'>";

        // 准备引擎加载的环境
        // 注意环境不要导入错了
        Context context = new Context();

        // 使用模板引擎渲染模板
        String html = engine.process(template, context);

        System.out.println(html);
    }

    // 渲染动态数据
    @Test
    public void testRenderDynamicDate() {
        // 创建一个模板引擎对象
        TemplateEngine engine = new TemplateEngine();

        // 准备一个模板
        // 模板中可以使用${name}来作为占位符
        // 类似jsp中用于加载域对象的EL表达式
        String template = "<input type='text' th:value='${name}'>";

        // 准备一个环境对象
        Context context = new Context();

        // 通过环境给占位符设置参数
        context.setVariable("name", "玛卡巴卡");

        // 使用模板引擎去渲染页面
        String html = engine.process(template, context);

        System.out.println(html);
    }

    @Test
    public void testRenderHtml() {
        // 创建模板引擎
        TemplateEngine engine = new TemplateEngine();

        // 创建一个模板解析器，用于读取模板文件
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();

        // 给模板引擎设置解析器
        engine.setTemplateResolver(resolver);

        // 准备一个环境
        Context context = new Context();

        context.setVariable("name", "唔西迪西");

        // 使用模板引擎去处理指定路径下的模板文件
        String html = engine.process("templates/index.html", context);

        System.out.println(html);
    }

    @Test
    public void testPrefixAndSuffix() {
        // 创建模板引擎对象
        TemplateEngine engine = new TemplateEngine();

        // 创建一个解析器
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();

        // 给解析器设置前缀后后缀
        resolver.setPrefix("templates/");
        resolver.setSuffix(".html");

        // 设置解析器
        engine.setTemplateResolver(resolver);

        // 创建环境对象
        Context context = new Context();

        // 准备一个Map用于存放多个内容用于替换模板中的占位符
        HashMap<String, Object> variables = new HashMap<>();

        variables.put("name", "易烊千玺");
        variables.put("age", 22);
        variables.put("gender", "男");

        context.setVariables(variables);

        // 渲染页面
        String html = engine.process("main", context);

        System.out.println(html);
    }
}
