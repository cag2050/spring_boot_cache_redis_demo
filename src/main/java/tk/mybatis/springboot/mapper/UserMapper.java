package tk.mybatis.springboot.mapper;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import tk.mybatis.springboot.model.User;

import java.util.List;
//@CacheConfig：主要用于配置该类中会用到的一些共用的缓存配置。在这里@CacheConfig(cacheNames = "users")：配置了该数据访问对象中返回的内容将存储于名为users的缓存对象中，我们也可以不使用该注解，直接通过@Cacheable配置缓存集的名字来定义。
@CacheConfig(cacheNames = "users")
public interface UserMapper {

	@Cacheable
	List<User> getAll();
	
	User getOne(Long id);

	void insert(User user);

	void update(User user);

	void delete(Long id);

}