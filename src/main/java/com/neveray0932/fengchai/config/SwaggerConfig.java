package com.neveray0932.fengchai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CADTECH
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**swagger會幫助生成api文檔
     * 1:配置生成的文檔信息
     * 2:配置生成規則
     *
     * 注意
     * SpringBoot使用Swagger2本來可以使用的，後來出現的異常No mapping for GET / swagger -ui.html
     * ,這個異常其實不用怎麼解釋，說白了就是找不到了
     * 遇到這種情況請先查找，最近你所添加繼承了【WebMvcConfigurationSupport】的類
     * 如果繼承了WebMvcConfigurationSupport，則在配置文件在中配置的相關內容會失效，需要重新指定靜態資源
     * 需要重新指定swagger靜態資源
     */


    /**
     Docket封裝api文檔信息
     */
    @Bean
    public Docket getDocket(){

        /**1.如何獲取一個接口對象
         2.new接口，需要在構造器後的{}實現接口中的所有抽象法
         3.new子類或實現類
         4.工廠模式
         */

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title("豐彩藝術API文檔")
                .description("此文檔詳細說明了豐彩藝術項目後端接口規範")
                .version("1.0.1")
                .contact(new Contact("AndyChen","http://www.cadtech.com.tw/","neveray0932@gmail.com"));


        ApiInfo apiInfo =  apiInfoBuilder.build();


        /**
         * header 參數
         */
        ParameterBuilder parameterBuilder = new ParameterBuilder();

        List<Parameter> parameterList = new ArrayList<>();

        Parameter build = parameterBuilder.name("token").description("Jwt")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        parameterList.add(build);





        /**指定文檔風格*/
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.neveray0932.fengchai.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameterList);
        /**指定生成的文檔中的封面信息*/



        return docket;
    }
}
