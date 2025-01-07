package com.zankeu.netease.spider.config;

import com.zankeu.netease.spider.pojo.TestPojo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NeteaseSpiderAutoConfiguration {
    @Bean
    public TestPojo testPojo() {
        return new TestPojo();
    }
}
