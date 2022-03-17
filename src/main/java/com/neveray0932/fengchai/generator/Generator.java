package com.neveray0932.fengchai.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.util.Collections;

/**
 * @author CADTECH
 */
public class Generator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://192.168.5.2:3306/fengchai","neveray0932","27070621")
                .globalConfig(builder -> {
                    builder.author("Andy")
                            .enableSwagger()
                            .outputDir("C:\\Users\\CADTECH\\Desktop\\fengchai\\src\\main\\java");
                })
                .packageConfig(builder -> {
                    builder.parent("com.neveray0932.fengchai")
                            .pathInfo(Collections.singletonMap(OutputFile.xml,"C:\\Users\\CADTECH\\Desktop\\fengchai\\src\\main\\resources\\mappers"));
                })
                .strategyConfig(builder -> {

                    builder.addInclude("emp_position")
                            .entityBuilder()
                            .enableLombok()
                            .disableSerialVersionUID();

                })
                .execute();
    }


}
