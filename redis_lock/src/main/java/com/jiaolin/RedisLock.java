package com.jiaolin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author johnny
 * @Classname RedisLock
 * @Description 分布式锁会遇到的问题
 * 1. 单机加syn关键字和ReentrantLock 可重入锁 改成分布式的
 * 2. 加上nginx 进行转发 使用redis 的setnx
 * 3. 设置过期时间 到了一定的时间,不管程序如何释放锁
 * 4。需要加finally 关键字 不管啥原因 需要释放锁
 * 5。保证原子性,过期时间和值需要保持原子性
 * 6。不能把他人的锁删除调 使用事务和lua 语言进行
 * 7。保证时间的可续性,redis过期时间大于业务执行时间,master宕机后,slave机收不到的问题
 * 8。使用官网推荐的redisson 进行 lock加锁问题。
 *
 * nginx weight=1 设置无效,正常是权重+轮询。后续查看。
 * 上锁,redisson.getlock("获取的是一个常量") 获取锁 进行加锁
 * finally的时候,需要判断是否还持有锁 并且是当前线程持有的锁 才进行unlock
 * @Date 2022/6/18 21:06
 */
@SpringBootApplication
public class RedisLock {
    public static void main(String[] args) {
        SpringApplication.run(RedisLock.class,args);
    }
}
