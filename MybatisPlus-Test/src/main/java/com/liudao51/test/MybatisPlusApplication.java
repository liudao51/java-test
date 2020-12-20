package com.liudao51.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.liudao51.test.mapper") // 扫描我们的 mapper 文件夹
public class MybatisPlusApplication
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
