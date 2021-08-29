package application;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@org.springframework.context.annotation.Configuration
@ComponentScan({"services", "caching"})
@EnableCaching
public class AppConfig {

	@Bean
	public Map<String,String> hashMap() {
		return new HashMap<String, String>();
	}
}
