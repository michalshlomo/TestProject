package caching;

import java.util.Arrays;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CacheProcessorAspect {

	@Autowired
	private Map<String, String> cacheHashMap;
	
	@Around("@annotation(Cachable)")
	public String Cachable(ProceedingJoinPoint joinPoint) throws Throwable {
				
		// Get all the method params
		Object[] parameters = joinPoint.getArgs();
		
		// Use the params to create a key
		String key = generateKey(parameters);

		// get the value for the given key if not execute  method to get the return object to be cached
		String cacheValue = cacheHashMap.get(key);
		if (cacheValue != null)
			return cacheValue;

		// execute method to get the return object
		Object returnObject = joinPoint.proceed(parameters);
		
		// cache the method return object to redis cache with the key generated
		cacheHashMap.put(key, (String)returnObject);

		return (String)returnObject;
	}
	
	/**
	 * Append the method name , param to an array and create a deepHashCode of the array as redis cache key
	 * @param params
	 * @return
	 */
	public static String generateKey(Object... params) {
		Object[] paramList = new Object[params.length+1];
		System.arraycopy(params, 0, paramList, 0, params.length);
		int hashCode = Arrays.deepHashCode(paramList);
		return Integer.valueOf(hashCode).toString();
	}
}
