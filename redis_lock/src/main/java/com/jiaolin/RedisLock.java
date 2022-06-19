package com.jiaolin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author johnny
 * @Classname RedisLock
 * @Description
 * @Date 2022/6/18 21:06
 */
@SpringBootApplication
public class RedisLock {
    public static void main(String[] args) {
        SpringApplication.run(RedisLock.class,args);
    }
}
