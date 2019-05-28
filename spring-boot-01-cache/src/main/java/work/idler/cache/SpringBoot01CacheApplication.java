package work.idler.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 一.搭建基本环境
 * 1.导入数据库文件,创建出department和employee表
 * 2.创建JavaBean
 * 3.整合MyBatis操作数据库
 *   3.1 配置数据源信息
 *   3.2 使用注解版mybatis
 *       3.2.1 @MapperScan指定需要扫描得mapper接口所在得包
 * 二.快速体验缓存
 * 1.开启基于注解得缓存
 * 2.标注缓存注解即可
 * @Cacheable
 * @CacheEvict
 * @CachePut
 * 默认使用的是ConcurrentMapCacheManager==ConcurrentMapCache: 将数据保存在 ConcurrentMap<Object, Object>
 * 开发中使用缓存中间件: redis, memcached, ehcahe;
 * 三.整合redis作为缓存
 * Redis 是一个开源（BSD许可）的，内存中的数据结构存储系统，它可以用作数据库、缓存和消息中间件。
 * 1.安装redis,使用docker安装
 * 2.引入redis的starter
 * 3.配置redis
 * 4.测试缓存
 *      原理: CacheManager==Cache 缓存组件来实际给缓存中存取数据
 *      1).引入redis的stater, 容器中保存的是RedisCacheManager
 *      2).RedisCacheManager帮我们创建 RedisCache来作为缓存组件,RedisCache通过操作redis缓存数据
 *      3).默认保存的数据 k-v 都是Object 利用序列化保存,如何保存为json
 *          1.引入了redis的stater, cacheManager变为RedisCacheManager
 *          2.默认创建的 RedisCacheManager 操作 redis 的时候使用的是 RedisTemplate<Object, Object>
 *          3.RedisTemplate<Object,Object> 是 默认使用jdk序列化机制
 *      4).自定义CacheManager
 */
@MapperScan("work.idler.cache.mapper")
@SpringBootApplication
@EnableCaching
public class SpringBoot01CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot01CacheApplication.class, args);
    }

}

