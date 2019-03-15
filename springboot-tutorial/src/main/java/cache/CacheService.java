package cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 缓存。
 * 
 * @since 2018.9.10
 */
@Service
public class CacheService {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	CacheManager cacheManager;
	
	@Cacheable(value = "mapping", key = "#remoteCode")
	public String getLocalCode(String remoteCode, String mappingType) {

		logger.debug("cache manager string : {}", cacheManager.toString());

		
		

		// 如果没有配置，直接返回对端编码
		return remoteCode;
	}
}
